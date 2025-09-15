package it.unibo.chessgravity.model.impl.move.base;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.move.BaseMove;
import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.impl.BoardImpl;
import it.unibo.chessgravity.model.impl.PieceImpl;

/**
 * Test class for {@link BaseMoveAbstract} class.
 */
public class BaseMoveAbstractTest {

    /**
     * Movement mock class.
     * 
     * This class implement the mock methods of the {@link BaseMoveAbstract} class.
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

    /**
     * Checks if the movement works correctly
     */
    @Test
    void testMove() {
        assertEquals(move.move(startPos, board), endPos);
    }

    /**
     * Checks if the class handle an illegal move
     */
    @Test
    void testIllegalMove() {
        LEN = 3;
        board = new BoardImpl(LEN, LEN, new HashSet<>());
        startPos = new SquarePosition(LEN, LEN);

        assertEquals(move.move(startPos, board), null);
    }

    /**
     * Checks if the class handle a collision with an obstacle and a piece
     */
    @Test
    void testMoveCollision() throws Exception {
        // Obstacle collision
        Set<SquarePosition> obs = new HashSet<>();
        obs.add(endPos);
        board = new BoardImpl(LEN, LEN, obs);
        assertEquals(move.move(startPos, board), null);

        // Piece collision
        board = new BoardImpl(LEN, LEN, new HashSet<>());
        board.setPiece(new PieceImpl(board, endPos, null, null));
        assertEquals(move.move(startPos, board), null);
    }
}
