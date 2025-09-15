package it.unibo.chessgravity.model.impl.move;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.move.MovePiece;
import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.impl.BoardImpl;

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

    
}
