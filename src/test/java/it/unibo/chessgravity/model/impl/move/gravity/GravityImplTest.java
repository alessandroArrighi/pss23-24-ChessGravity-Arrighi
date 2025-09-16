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

    @BeforeEach
    void setup() {
        gravity = new GravityImpl();
        board = new BoardImpl(LEN, LEN, new HashSet<>());
    }

    /**
     * Checks if gravity works correctly
     */
    @Test
    void testGravity() throws Exception {
        start = new SquarePosition(defaultPosX, defaultPosX);
        dest = new SquarePosition(defaultPosX, 1);
        board.setPiece(new PieceMock(start));

        assertEquals(gravity.gravity(start, board), dest);
    }

    /**
     * Checks if the gravity works correctly with no movement
     */
    @Test
    void testNoGravity() throws Exception {
        start = new SquarePosition(defaultPosX, 1);
        board.setPiece(new PieceMock(start));
        
        assertEquals(gravity.gravity(start, board), start);
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
        board = new BoardImpl(LEN, LEN, obs);
        board.setPiece(new PieceMock(start));

        assertEquals(gravity.gravity(start, board), dest);
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

        assertEquals(gravity.gravity(start, board), dest);
    }
}
