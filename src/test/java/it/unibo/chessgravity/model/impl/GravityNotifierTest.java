package it.unibo.chessgravity.model.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.chessgravity.model.api.GravityObservable;
import it.unibo.chessgravity.model.api.GravityObserver;
import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Test class for {@link GravityNotifier} class
 */
public class GravityNotifierTest {

    /**
     * Mock class for {@link GravityObserver} reference
     */
    public class GravityObserverMock implements GravityObserver {

        private static SquarePosition result = new SquarePosition(0, 0);
        
        private SquarePosition pos;

        public GravityObserverMock(final SquarePosition pos) {
            this.pos = pos;
        }

        @Override
        public void gravity() {
            this.pos = result;
            result = new SquarePosition(0, result.getPosY() + 1);
        }

        @Override
        public SquarePosition getPos() {
            return this.pos;
        }
    }
    
    private GravityObservable notifier;
    private List<GravityObserver> observers;
    private SquarePosition start;
    private int posX;
    private int posY;

    @BeforeEach
    void setup() {
        posX = 0;
        posY = 4;
        start = new SquarePosition(posX, posY);
        observers = new ArrayList<>();

        for (int i = posY + 1; i < posY + 4; ++i) {
            observers.add(new GravityObserverMock(
                new SquarePosition(posX, i)
            ));
        }

        observers.add(new GravityObserverMock(
            new SquarePosition(posX + 2, posY - 3)
        ));
        observers.add(new GravityObserverMock(
            new SquarePosition(posX + 4, posY + 5)
        ));
        observers.add(new GravityObserverMock(
            new SquarePosition(posX + 1, posY + 2)
        ));

        notifier = new GravityNotifier();
        notifier.subscribeAll(observers);
    }

    /**
     * Checks if the notification works correctly
     */
    @Test
    void testNotification() {
        List<GravityObserver> expected = new ArrayList<>();
        observers.stream()
        .filter(x -> x.getPos().getPosX() == 0)
        .forEach(x -> expected.add(x));

        List<GravityObserver> res = notifier.notifyObservers(start);

        assertEquals(expected.size(), res.size());

        for (int i = 0; i < res.size(); ++i) {
            // checks if the observer order is correct
            assertEquals(expected.get(i), res.get(i));
            // checks if the current element is at the right position
            assertEquals(res.get(i).getPos().getPosY(), i);
        }
    }
}