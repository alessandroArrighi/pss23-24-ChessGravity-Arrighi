package it.unibo.chessgravity.model.impl.move.gravity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.move.Gravity;
import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.impl.BoardImpl;
import it.unibo.chessgravity.model.mocks.PieceMock;

/**
 * Test class for the {@link GravityImpl} class
 */
public class GravityImplTest {
    
    private int LEN = 10;
    private int defaultPosX = 5;
    private Gravity gravity;
    private Board board;
    private SquarePosition start;
    private SquarePosition dest;
    private SquarePosition enemyPos;

    @BeforeEach
    void setup() {
        gravity = new GravityImpl();
        enemyPos = new SquarePosition(LEN, LEN);
        board = new BoardImpl(LEN, LEN, new HashSet<>(), enemyPos);
    }

    /**
     * Checks if gravity works correctly
     */
    @Test
    void testGravity() throws Exception {
        start = new SquarePosition(defaultPosX, defaultPosX);
        dest = new SquarePosition(defaultPosX, 1);
        board.setPiece(new PieceMock(start));

        assertEquals(gravity.gravity(start, board).getPos(), dest);
    }

    /**
     * Checks if the gravity works correctly with no movement
     */
    @Test
    void testNoGravity() throws Exception {
        start = new SquarePosition(defaultPosX, 1);
        board.setPiece(new PieceMock(start));
        
        assertEquals(gravity.gravity(start, board).getPos(), start);
    }

    /**
     * Checks if the gravity works correctly with an obstacle in the middle
     */
    @Test
    void testGravityOnObstacle() throws Exception {
        final Set<SquarePosition> obs = new HashSet<>();
        obs.add(new SquarePosition(defaultPosX, 1));
        start = new SquarePosition(defaultPosX, defaultPosX);
        dest = new SquarePosition(defaultPosX, 2);
        board = new BoardImpl(LEN, LEN, obs, enemyPos);
        board.setPiece(new PieceMock(start));

        assertEquals(gravity.gravity(start, board).getPos(), dest);
    }

    /**
     * Checks if the gravity works correctly with a piece in the middle
     */
    @Test
    void testGravityOnPiece() throws Exception {
        start = new SquarePosition(defaultPosX, defaultPosX);
        dest = new SquarePosition(defaultPosX, 2);
        board.setPiece(new PieceMock(new SquarePosition(defaultPosX, 1)));
        board.setPiece(new PieceMock(start));

        assertEquals(gravity.gravity(start, board).getPos(), dest);
    }
}
