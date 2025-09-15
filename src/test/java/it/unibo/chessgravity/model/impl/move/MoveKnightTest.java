package it.unibo.chessgravity.model.impl.move;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.move.MovePiece;
import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.impl.BoardImpl;

/**
 * Test class for {@link MoveKnight} class
 */
public class MoveKnightTest {

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
            System.out.println(pos);
            assertTrue(move.move(start, pos, board));
        }
    }

}
