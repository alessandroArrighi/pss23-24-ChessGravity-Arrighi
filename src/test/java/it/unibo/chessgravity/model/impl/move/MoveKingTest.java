package it.unibo.chessgravity.model.impl.move;

import java.util.List;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.move.MovePiece;
import it.unibo.chessgravity.model.api.square.SquarePosition;

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

}
