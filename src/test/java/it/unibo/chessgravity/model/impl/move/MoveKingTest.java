package it.unibo.chessgravity.model.impl.move;

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
import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.impl.BoardImpl;
import it.unibo.chessgravity.model.impl.PieceImpl;

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
    
    /**
     * Checks if all the moves work correctly
     */
    @Test
    void testSimpleMove() {
        dest.addAll(Arrays.asList(
            // Move top left
            topLeft,
            // Move top
            top,
            // Move top right
            topRight,
            // Move left
            left,
            // Move right
            right,
            // Move bottom left
            bottomLeft,
            // Move bottom
            bottom,
            // Move bottom right
            bottoRight,
            // Don't move
            start
        ));
        
        for (SquarePosition pos : dest) {
            assertTrue(move.move(start, pos, board));
        }
    }

    /**
     * Cheks if handle correctly an illegal move
     */
    @Test
    void testIllegalMove() {
        dest.addAll(Arrays.asList(
            // Move like a bishop
            new SquarePosition(1, 1),
            // Move like a rook
            new SquarePosition(posX, 10),
            // Move like a night
            new SquarePosition(7, 8),
            // Move random
            new SquarePosition(9, 3),
            // Move outside the board
            new SquarePosition(LEN + 1, LEN + 1)
        ));

        for (SquarePosition pos : dest) {
            assertFalse(move.move(start, pos, board));
        }
    }

    /*
     * Utility method for cheks if a collision works correctly. This provides a template
     * to use for each type of movement
     */
    private void collisionMove(final SquarePosition collision) throws Exception {
        Set<SquarePosition> obs = new HashSet<>();
        obs.add(collision);
        board = new BoardImpl(LEN, LEN, obs);

        // Test collision with an obstacle
        assertFalse(move.move(start, collision, board));

        board = new BoardImpl(LEN, LEN, new HashSet<>());
        board.setPiece(new PieceImpl(board, collision, move, null));

        // Test collision with a piece
        assertFalse(move.move(start, collision, board));
    }
}
