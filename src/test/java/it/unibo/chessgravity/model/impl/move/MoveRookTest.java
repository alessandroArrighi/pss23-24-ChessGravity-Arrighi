package it.unibo.chessgravity.model.impl.move;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.move.MovePiece;
import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.impl.BoardImpl;
import it.unibo.chessgravity.model.impl.PieceImpl;

/**
 * Test class the {@link MoveRook} class
 */
public class MoveRookTest {
    
    private int LEN = 10;
    private MovePiece move;
    private Board board;
    private SquarePosition start;
    private List<SquarePosition> dest;
    private int posX;
    private int posY;

    @BeforeEach
    void setup() {
        move = new MoveRook();
        board = new BoardImpl(LEN, LEN, new HashSet<>());
        start = new SquarePosition(5, 5);
        dest = new ArrayList<>();
        posX = start.getPosX();
        posY = start.getPosY();
    }

    /**
     * Checks if the move works correctly
     */
    @Test
    void testSimpleMoves() {
        dest.addAll(Arrays.asList(
            // Move left
            new SquarePosition(1, posY),
            // Move right
            new SquarePosition(1, posY),
            // Move top
            new SquarePosition(posX, 10),
            // Move bottom
            new SquarePosition(posX, 1),
            // Don't move
            start
        ));
        
        for (SquarePosition pos : dest) {
            assertTrue(move.move(start, pos, board));
        }
    }

    /**
     * Checks if handle correclty illegal movements
     */
    @Test
    void testIllegalMove() {
        dest.addAll(Arrays.asList(
            // Move like a bishop
            new SquarePosition(1, 1),
            // Move like a night
            new SquarePosition(7, 8),
            // Move random
            new SquarePosition(9, 3),
            // Move outside the board
            new SquarePosition(posX, posY + LEN)
        ));

        for (SquarePosition pos : dest) {
            assertFalse(move.move(start, pos, board));
        }
    }

    /*
     * Utility method that check if collisions with pieces and obstacles works correctly
     */
    private void collisionMove(final SquarePosition collision, 
                                final SquarePosition afterCollision) throws Exception {
        Set<SquarePosition> obs = new HashSet<>();
        obs.add(collision);
        board = new BoardImpl(LEN, LEN, obs);

        dest.addAll(Arrays.asList(
            collision,
            afterCollision
        ));

        // Test collision with an obstacle
        for (SquarePosition pos : dest) {
            assertFalse(move.move(start, pos, board));
        }

        board = new BoardImpl(LEN, LEN, new HashSet<>());
        board.setPiece(new PieceImpl(board, collision, move, null));

        // Test collision with a piece
        for (SquarePosition pos : dest) {
            assertFalse(move.move(start, pos, board));
        }
    }
}
