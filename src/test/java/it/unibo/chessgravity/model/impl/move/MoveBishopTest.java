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
 * Test class for {@link MoveBishop} class.
 */
public class MoveBishopTest {
    
    private int LEN = 10;
    private MovePiece move;
    private Board board;
    private SquarePosition start;
    private List<SquarePosition> dest;

    @BeforeEach
    void setup() {
        move = new MoveBishop();
        board = new BoardImpl(LEN, LEN, new HashSet<>());
        start = new SquarePosition(5, 5);
        dest = new ArrayList<>();
    }

    /**
     * Checks if the movement works correctly
     */
    @Test
    void testSimpleMoves() {
        dest.addAll(Arrays.asList(
            // Move top left
            new SquarePosition(start.getPosX() - 3, start.getPosY() + 3),
            // Move top right
            new SquarePosition(start.getPosX() + 3, start.getPosY() + 3),
            // Move bottom left
            new SquarePosition(start.getPosX() - 3, start.getPosY() - 3),
            // Move bottom right
            new SquarePosition(start.getPosX() + 3, start.getPosY() - 3),
            // Don't move
            start
        ));
        
        for (SquarePosition pos : dest) {
            assertTrue(move.move(start, pos, board));
        }
    }

    /**
     * Checks if illegal moves are handled correctly
     */
    @Test
    void testIllegalMove() {
        dest.addAll(Arrays.asList(
            // Move like a rook
            new SquarePosition(start.getPosX(), 10),
            // Move like a night
            new SquarePosition(7, 8),
            // Move random
            new SquarePosition(9, 3),
            // Move outside the board
            new SquarePosition(LEN + 1, LEN + 1)
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

    /**
     * Checks if the collision is handled correctly on top left
     */
    @Test
    void testCollisionsMoveTopLeft() throws Exception {
        collisionMove(
            new SquarePosition(start.getPosX() - 3, start.getPosY() + 3),
            new SquarePosition(start.getPosX() - 4, start.getPosY() + 4));
    }

    /**
     * Checks if the collision is handled correctly on top right
     */
    @Test
    void testCollisionsMoveTopRight() throws Exception {
        collisionMove(
            new SquarePosition(start.getPosX() + 3, start.getPosY() + 3),
            new SquarePosition(start.getPosX() + 4, start.getPosY() + 4));
    }

    /**
     * Checks if the collision is handled correctly on bottom left
     */
    @Test
    void testCollisionsMoveBottomLeft() throws Exception {
        collisionMove(
            new SquarePosition(start.getPosX() - 3, start.getPosY() - 3),
            new SquarePosition(start.getPosX() - 4, start.getPosY() - 4));
    }

    /**
     * Checks if the collision is handled correctly on bottom right
     */
    @Test
    void testCollisionsMoveBottomRight() throws Exception {
        collisionMove(
            new SquarePosition(start.getPosX() + 3, start.getPosY() - 3),
            new SquarePosition(start.getPosX() + 4, start.getPosY() - 4));
    }
}
