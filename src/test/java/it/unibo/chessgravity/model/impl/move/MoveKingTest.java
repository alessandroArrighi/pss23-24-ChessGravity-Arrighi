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
 * Test class for {@link MoveKing} class
 */
public class MoveKingTest {
    
    private int LEN = 10;
    private MovePiece move;
    private Board board;
    private SquarePosition start;
    private List<SquarePosition> dest;
    private int posX;
    private int posY;
    private final int step = 1;
    private SquarePosition topLeft;
    private SquarePosition top;
    private SquarePosition topRight;
    private SquarePosition left;
    private SquarePosition right;
    private SquarePosition bottomLeft;
    private SquarePosition bottom;
    private SquarePosition bottoRight;

    @BeforeEach
    void setup() {
        move = new MoveKing();
        board = new BoardImpl(LEN, LEN, new HashSet<>());
        start = new SquarePosition(5, 5);
        posX = start.getPosX();
        posY = start.getPosY();
        dest = new ArrayList<>();

        // init moves positon
        topLeft = new SquarePosition(posX - step, posY + step);
        top = new SquarePosition(posX, posY + step);
        topRight = new SquarePosition(posX + step, posY + step);
        left = new SquarePosition(posX - step, posY);
        right = new SquarePosition(posX + step, posY);
        bottomLeft = new SquarePosition(posX - step, posY - step);
        bottom = new SquarePosition(posX, posY - step);
        bottoRight = new SquarePosition(posX + step, posY - step);
    }
}
