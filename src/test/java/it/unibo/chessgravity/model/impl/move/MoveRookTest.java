package it.unibo.chessgravity.model.impl.move;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import it.unibo.chessgravity.model.api.move.MoveResponse;
import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.impl.BoardImpl;
import it.unibo.chessgravity.model.mocks.PieceMock;

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
    private SquarePosition top;
    private SquarePosition bottom;
    private SquarePosition left;
    private SquarePosition right;
    private SquarePosition enemyPos;

    @BeforeEach
    void setup() {
        enemyPos = new SquarePosition(LEN, 1);
        move = new MoveRook();
        board = new BoardImpl(LEN, LEN, new HashSet<>(), enemyPos);
        start = new SquarePosition(5, 5);
        dest = new ArrayList<>();
        posX = start.getPosX();
        posY = start.getPosY();
        top = new SquarePosition(posX, posY + 3);
        bottom = new SquarePosition(posX, posY - 3);
        right = new SquarePosition(posX + 3, posY);
        left = new SquarePosition(posX - 3, posY);
    }

    /**
     * Checks if the move works correctly
     */
    @Test
    void testSimpleMoves() {
        dest.addAll(Arrays.asList(
            // Move left
            left,
            // Move right
            right,
            // Move top
            top,
            // Move bottom
            bottom,
            // Don't move
            start
        ));
        
        for (SquarePosition pos : dest) {
            final MoveResponse res = move.move(start, pos, board);
            assertTrue(res.canMove());
            assertEquals(res.getPos(), pos);
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
            assertFalse(move.move(start, pos, board).canMove());
        }
    }

    /*
     * Utility method that check if collisions with pieces and obstacles works correctly
     */
    private void collisionMove(final SquarePosition collision, 
                                final SquarePosition afterCollision) throws Exception {
        Set<SquarePosition> obs = new HashSet<>();
        obs.add(collision);
        board = new BoardImpl(LEN, LEN, obs, enemyPos);

        dest.addAll(Arrays.asList(
            collision,
            afterCollision
        ));

        // Test collision with an obstacle
        for (SquarePosition pos : dest) {
            assertFalse(move.move(start, pos, board).canMove());
        }

        board = new BoardImpl(LEN, LEN, new HashSet<>(), enemyPos);
        board.setPiece(new PieceMock(collision));

        // Test collision with a piece
        for (SquarePosition pos : dest) {
            assertFalse(move.move(start, pos, board).canMove());
        }
    }

    /**
     * Checks if the collision is handled correctly on top
     */
    @Test
    void testCollisionsMoveTop() throws Exception {
        collisionMove(
            top,
            new SquarePosition(top.getPosX(), top.getPosY() + 1));
    }

    /**
     * Checks if the collision is handled correctly on bottom
     */
    @Test
    void testCollisionsMoveBottom() throws Exception {
        collisionMove(
            bottom,
            new SquarePosition(bottom.getPosX(), bottom.getPosY() - 1));
    }

    /**
     * Checks if the collision is handled correctly on right
     */
    @Test
    void testCollisionsMoveRight() throws Exception {
        collisionMove(
            right,
            new SquarePosition(right.getPosX() + 1, right.getPosY()));
    }

    /**
     * Checks if the collision is handled correctly on left
     */
    @Test
    void testCollisionsMoveLeft() throws Exception {
        collisionMove(
            left,
            new SquarePosition(left.getPosX() - 1, left.getPosY()));
    }
}
