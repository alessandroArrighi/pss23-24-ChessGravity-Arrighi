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
}