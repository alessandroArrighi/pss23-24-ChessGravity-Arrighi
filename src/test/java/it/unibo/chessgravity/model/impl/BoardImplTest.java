package it.unibo.chessgravity.model.impl;

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

    @BeforeEach
    void setup() throws Exception {
        obs = new HashSet<>();
        obs.addAll(Arrays.asList(
            new SquarePosition(3, 3),
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

}
