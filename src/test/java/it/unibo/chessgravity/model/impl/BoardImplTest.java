package it.unibo.chessgravity.model.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.Piece;
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
    }
}
