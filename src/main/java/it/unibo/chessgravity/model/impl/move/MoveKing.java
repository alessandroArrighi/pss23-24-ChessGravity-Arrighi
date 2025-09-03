package it.unibo.chessgravity.model.impl.move;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.move.BaseMove;
import it.unibo.chessgravity.model.api.move.MovePiece;
import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.impl.move.base.*;

/**
 * Class that models the movement strategy that has to be done by a king piece.
 */
public class MoveKing implements MovePiece {
    private final BaseMove moveTopLeft;
    private final BaseMove moveTop;
    private final BaseMove moveTopRight;
    private final BaseMove moveLeft;
    private final BaseMove moveRight;
    private final BaseMove moveBottomLeft;
    private final BaseMove moveBottom;
    private final BaseMove moveBottomRight;

    public MoveKing() {
        moveTopLeft = new MoveTopLeft();
        moveTop = new MoveTop();
        moveTopRight = new MoveTopRight();
        moveLeft = new MoveLeft();
        moveRight = new MoveRight();
        moveBottomLeft = new MoveBottomLeft();
        moveBottom = new MoveBottom();
        moveBottomRight = new MoveBottomRight();
    }

    @Override
    public boolean move(SquarePosition start, SquarePosition dest, Board board) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }
    
}
