package it.unibo.chessgravity.model.impl.move.gravity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.move.Gravity;
import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.impl.BoardImpl;
import it.unibo.chessgravity.model.impl.PieceImpl;

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
        board.setPiece(new PieceImpl(board, start, null, null));

        assertEquals(gravity.gravity(start, board), dest);
    }
}
