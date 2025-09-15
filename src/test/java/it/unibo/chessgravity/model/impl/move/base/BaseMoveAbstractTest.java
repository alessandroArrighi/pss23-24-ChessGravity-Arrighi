package it.unibo.chessgravity.model.impl.move.base;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.move.BaseMove;
import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Test class for BaseMoveAbstract class.
 */
public class BaseMoveAbstractTest {

    /**
     * Movement mock class.
     * 
     * This class implement the mock methods of the BaseMoveAbstract class.
     */
    public class MoveMock extends BaseMoveAbstract {

        private final SquarePosition pos;

        public MoveMock(final SquarePosition pos) {
            super();
            this.pos = pos;
        }

        @Override
        protected SquarePosition calculatePos(int posX, int posY) {
            return this.pos;
        }
    }

    private int LEN;
    private Board board;
    private SquarePosition startPos;
    private SquarePosition endPos;
    private BaseMove move;
}
