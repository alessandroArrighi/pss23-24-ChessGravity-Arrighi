package it.unibo.chessgravity.model.impl;

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

        @Override
        public void gravity() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'gravity'");
        }

        @Override
        public SquarePosition getPos() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getPos'");
        }
    }
}