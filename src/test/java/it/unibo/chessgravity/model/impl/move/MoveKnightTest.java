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
import it.unibo.chessgravity.model.api.move.MoveResponse;
import it.unibo.chessgravity.model.api.move.MoveStrategy;
import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.impl.BoardImpl;
import it.unibo.chessgravity.model.mocks.PieceMock;

/**
 * Test class for {@link MoveKnight} class
 */
public class MoveKnightTest {

    private int LEN = 10;
    private MoveStrategy move;
    private Board board;
    private SquarePosition start;
    private List<SquarePosition> dest;
    private int posX;
    private int posY;
    private List<SquarePosition> topLeft;
    private List<SquarePosition> topRight;
    private List<SquarePosition> bottomLeft;
    private List<SquarePosition> bottomRight;
    private SquarePosition enemyPos;

    @BeforeEach
    void setup() {
        enemyPos = new SquarePosition(LEN, 1);
        move = new MoveKnight();
        board = new BoardImpl(LEN, LEN, new HashSet<>(), enemyPos);
        start = new SquarePosition(5, 5);
        posX = start.getPosX();
        posY = start.getPosY();
        dest = new ArrayList<>();

        topLeft = new ArrayList<>();
        topLeft.addAll(Arrays.asList(
            new SquarePosition(posX - 1, posY + 2),
            new SquarePosition(posX - 2, posY + 1)
        ));
        topRight = new ArrayList<>();
        topRight.addAll(Arrays.asList(
            new SquarePosition(posX + 1, posY + 2),
            new SquarePosition(posX + 2, posY + 1)
        ));
        bottomLeft = new ArrayList<>();
        bottomLeft.addAll(Arrays.asList(
            new SquarePosition(posX - 1, posY - 2),
            new SquarePosition(posX - 2, posY - 1)
        ));
        bottomRight = new ArrayList<>();
        bottomRight.addAll(Arrays.asList(
            new SquarePosition(posX - 2, posY + 1),
            new SquarePosition(posX - 1, posY + 2)
        ));
    }

    /**
     * Checks if move works correctly
     */
    @Test
    void testSimpleMove() {
        dest.addAll(Arrays.asList(
            // Move top left
            topLeft.get(0),
            topLeft.get(1),
            // Move top right
            topRight.get(0),
            topRight.get(1),
            // Move bottom left
            bottomLeft.get(0),
            bottomLeft.get(1),
            // Move bottom right
            bottomRight.get(0),
            bottomRight.get(1),
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
            // Move like a bishop
            new SquarePosition(1, 1),
            // Move like a rook
            new SquarePosition(posX, 10),
            // Move random
            new SquarePosition(9, 3),
            // Move outside the board
            new SquarePosition(LEN + 1, LEN + 1)
        ));

        for (SquarePosition pos : dest) {
            assertFalse(move.move(start, pos, board).canMove());
        }
    }

    /*
     * Utility method that check if collisions with pieces and obstacles works correctly
     */
    private void collisionMove(final SquarePosition collision) throws Exception {
        Set<SquarePosition> obs = new HashSet<>();
        obs.add(collision);
        board = new BoardImpl(LEN, LEN, obs, enemyPos);

        // Test collision with an obstacle
        assertFalse(move.move(start, collision, board).canMove());

        board = new BoardImpl(LEN, LEN, new HashSet<>(), enemyPos);
        board.setPiece(new PieceMock(collision));

        // Test collision with a piece
        assertFalse(move.move(start, collision, board).canMove());
    }

    /**
     * Checks if the collision is handled correctly on the two top left squares
     */
    @Test
    void testCollisionsMoveTopLeft() throws Exception {
        for (SquarePosition pos: topLeft) {
            collisionMove(pos);
        }
    }

    /**
     * Checks if the collision is handled correctly on the two top right squares
     */
    @Test
    void testCollisionsMoveTopRight() throws Exception {
        for (SquarePosition pos : topRight) {
            collisionMove(pos);
        }
    }

    /**
     * Checks if the collision is handled correctly on the two bottom left squares
     */
    @Test
    void testCollisionsMoveBottomLeft() throws Exception {
        for (SquarePosition pos : bottomLeft) {
            collisionMove(pos);
        }
    }

    /**
     * Checks if the collision is handled correctly on the two bottom right squares
     */
    @Test
    void testCollisionsMoveBottomRight() throws Exception {
        for (SquarePosition pos : bottomRight) {
            collisionMove(pos);
        }
    }
}
