package it.unibo.chessgravity.model.impl.move.base;

import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.move.BaseMove;
import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.impl.BoardImpl;

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

    @BeforeEach
    void setUp() {
        LEN = 10;
        board = new BoardImpl(LEN, LEN, new HashSet<>());
        startPos = new SquarePosition(3, 3);
        endPos = new SquarePosition(4, 4);
        move = new MoveMock(endPos);

    }
}
