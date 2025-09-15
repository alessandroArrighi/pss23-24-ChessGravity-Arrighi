package it.unibo.chessgravity.model.impl.move;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.move.MovePiece;
import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.impl.BoardImpl;

/**
 * Test class for {@link MoveNight} class
 */
public class MoveNightTest {

    private int LEN = 10;
    private MovePiece move;
    private Board board;
    private SquarePosition start;
    private List<SquarePosition> dest;
    private int posX;
    private int posY;
    private List<SquarePosition> topLeft;
    private List<SquarePosition> topRight;
    private List<SquarePosition> bottomLeft;
    private List<SquarePosition> bottomRight;

    @BeforeEach
    void setup() {
        move = new MoveKnight();
        board = new BoardImpl(LEN, LEN, new HashSet<>());
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

    
}
