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
 * Test class for {@link MoveBishop} class.
 */
public class MoveBishopTest {
    
    private int LEN = 10;
    private MovePiece move;
    private Board board;
    private SquarePosition start;
    private List<SquarePosition> dest;
    private int posX;
    private int posY;
    private SquarePosition topLeft;
    private SquarePosition topRight;
    private SquarePosition bottomLeft;
    private SquarePosition bottomRight;
    private SquarePosition enemyPos;

    @BeforeEach
    void setup() {
        enemyPos = new SquarePosition(LEN, LEN);
        move = new MoveBishop();
        board = new BoardImpl(LEN, LEN, new HashSet<>(), enemyPos);
        start = new SquarePosition(5, 5);
        dest = new ArrayList<>();
        posX = start.getPosX();
        posY = start.getPosY();
        topLeft = new SquarePosition(posX - 3, posY + 3);
        topRight = new SquarePosition(posX + 3, posY + 3);
        bottomLeft = new SquarePosition(posX - 3, posY - 3);
        bottomRight = new SquarePosition(posX + 3, posY - 3);
    }

    /**
     * Checks if the movement works correctly
     */
    @Test
    void testSimpleMoves() {
        dest.addAll(Arrays.asList(
            // Move top left
            topLeft,
            // Move top right
            topRight,
            // Move bottom left
            bottomLeft,
            // Move bottom right
            bottomRight,
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
     * Checks if illegal moves are handled correctly
     */
    @Test
    void testIllegalMove() {
        dest.addAll(Arrays.asList(
            // Move like a rook
            new SquarePosition(posX, 10),
            // Move like a night
            new SquarePosition(7, 8),
            // Move random
            new SquarePosition(9, 3),
            // Move outside the board
            new SquarePosition(LEN + 2, LEN + 1)
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
     * Checks if the collision is handled correctly on top left
     */
    @Test
    void testCollisionsMoveTopLeft() throws Exception {
        collisionMove(
            topLeft,
            new SquarePosition(topLeft.getPosX() - 1, topLeft.getPosY() + 1));
    }

    /**
     * Checks if the collision is handled correctly on top right
     */
    @Test
    void testCollisionsMoveTopRight() throws Exception {
        collisionMove(
            topRight,
            new SquarePosition(topRight.getPosX() + 1, topRight.getPosY() + 1));
    }

    /**
     * Checks if the collision is handled correctly on bottom left
     */
    @Test
    void testCollisionsMoveBottomLeft() throws Exception {
        collisionMove(
            bottomLeft,
            new SquarePosition(bottomLeft.getPosX() - 1, bottomLeft.getPosY() - 1));
    }

    /**
     * Checks if the collision is handled correctly on bottom right
     */
    @Test
    void testCollisionsMoveBottomRight() throws Exception {
        collisionMove(
            bottomRight,
            new SquarePosition(bottomRight.getPosX() + 1, bottomRight.getPosY() - 1));
    }
}
