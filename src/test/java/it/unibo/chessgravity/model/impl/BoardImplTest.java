package it.unibo.chessgravity.model.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.Piece;
import it.unibo.chessgravity.model.api.exceptions.IllegalSquarePositionException;
import it.unibo.chessgravity.model.api.exceptions.SquareFullException;
import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Test class for {@link BoardImpl} class
 */
public class BoardImplTest {
    
    private final int LEN = 10;
    private Board board;
    private Set<SquarePosition> obs;
    private Piece piece1;
    private Piece piece2;
    private SquarePosition illegalPos;
    private SquarePosition obstacle;

    @BeforeEach
    void setup() throws Exception {
        obstacle = new SquarePosition(3, 3);
        obs = new HashSet<>();
        obs.addAll(Arrays.asList(
            obstacle,
            new SquarePosition(5, 5),
            new SquarePosition(8, 2)
        ));
        piece1 = new PieceImpl(board, new SquarePosition(2, 2), null, null);
        piece2 = new PieceImpl(board, new SquarePosition(3, 6), null, null);

        board = new BoardImpl(LEN, LEN, obs);

        board.setPiece(piece1);
        board.setPiece(piece2);

        illegalPos = new SquarePosition(LEN + 1, LEN + 1);
    }
    
    /**
     * Checks if the board is created correctly
     */
    @Test
    void testCreateBoard() {
        // check obstacles
        for (SquarePosition pos : obs) {
            assertFalse(board.isSquareFree(pos));
        }

        assertFalse(board.isSquareFree(piece1.getPos()));
        assertFalse(board.isSquareFree(piece2.getPos()));
    }

    /**
     * Checks if the board throws {@link IllegalSquarePositionException} after
     * attempting to place a piece in an invalid position.
     * 
     * Then, it verifies that the state has not changed.
     */
    @Test
    void testIllegalPosition() {
        final Piece piece = new PieceImpl(board, illegalPos, null, null);
        assertThrows(IllegalSquarePositionException.class, () -> { board.setPiece(piece); });

        assertNull(board.getPiece(illegalPos));
    }

    /**
     * Checks if the board throws {@link SquareFullException} after attempting to
     * place a piece in a square that is not free (occupied by another piece or an obstacle).
     * 
     * Then, it verifies that the state has not changed.
     */
    @Test
    void testSquareFull() {
        // place p1Test in the same position of piece1
        final Piece p1Test = new PieceImpl(board, piece1.getPos(), null, null);
        assertThrows(SquareFullException.class, () -> { board.setPiece(p1Test); });
        assertEquals(board.getPiece(piece1.getPos()), piece1);

        // place the piece in the same position of an obstacle
        final Piece p2Test = new PieceImpl(board, obstacle, null, null);
        assertThrows(SquareFullException.class, () -> { board.setPiece(p2Test); });
        assertNull(board.getPiece(obstacle));
    }

    /**
     * Checks if the move works correctly
     */
    @Test
    void testMove() throws Exception {
        final SquarePosition pos = new SquarePosition(LEN, LEN);
        board.move(piece1.getPos(), pos);
        assertTrue(board.isSquareFree(piece1.getPos()));
        assertFalse(board.isSquareFree(pos));

        // move piece1 in the same position
        board.move(pos, pos);
        assertFalse(board.isSquareFree(pos));
    }

    /**
     * Checks if throws {@link SquareFullException} with a piece collision.
     * 
     * Then, it verifies that the state has not changed.
     */
    @Test
    void testPieceCollision() {
        assertThrows(
            SquareFullException.class,
            () -> { board.move(piece1.getPos(), piece2.getPos()); }
        );

        assertEquals(board.getPiece(piece1.getPos()), piece1);
        assertEquals(board.getPiece(piece2.getPos()), piece2);
    }

    /**
     * Checks if throws {@link SquareFullException} with an obstacle collision.
     * 
     * Then, it verifies that the state has not changed.
     */
    @Test
    void testObstacleCollision() {
        assertThrows(
            SquareFullException.class,
            () -> { board.move(piece1.getPos(), obstacle); }
        );

        assertEquals(board.getPiece(piece1.getPos()), piece1);
        assertFalse(board.isSquareFree(obstacle));
        assertNull(board.getPiece(obstacle));
    }

    /**
     * Checks if the board throws {@link IllegalSquarePositionException}
     * after attempting to move a piece in a square that is not valid.
     * 
     * Then, it verifies that the state has not changed.
     */
    @Test
    void testIllegalDestination() {
        // check illegal destination position
        assertThrows(
            IllegalSquarePositionException.class,
            () -> { board.move(piece1.getPos(), illegalPos); }
        );

        assertEquals(board.getPiece(piece1.getPos()), piece1);
    }

    /**
     * Checks if the board throws {@link IllegalSquarePositionException}
     * after attempting to move a piece from a square that is not valid.
     * 
     * Then, it verifies that the state has not changed.
     */
    @Test
    void testIllegalStart() {
        // check illegal start position
        final SquarePosition pos = illegalPos;
        assertThrows(
            IllegalSquarePositionException.class,
            () -> { board.move(pos, piece1.getPos()); }
        );

        assertEquals(board.getPiece(piece1.getPos()), piece1);
    }

}
