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

}
