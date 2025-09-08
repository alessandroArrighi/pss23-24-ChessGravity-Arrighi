package it.unibo.chessgravity.model.impl.move;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.move.BaseMove;
import it.unibo.chessgravity.model.api.move.MovePiece;
import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.impl.move.base.BaseMoveAbstract.MoveChecker;
import it.unibo.chessgravity.model.impl.move.base.*;

/**
 * Class that models the movement strategy that has to be done by a knight piece.
 */
public class MoveKnight implements MovePiece {

    private final BaseMove moveTop;
    private final BaseMove moveLeft;
    private final BaseMove moveRight;
    private final BaseMove moveBottom;

    public MoveKnight() {
        final MoveChecker unCheck = (a, b) -> true;
        
        moveTop = new MoveTop(unCheck);
        moveLeft = new MoveLeft(unCheck);
        moveRight = new MoveRight(unCheck);
        moveBottom = new MoveBottom(unCheck);
    }


    @Override
    public boolean move(SquarePosition start, SquarePosition dest, Board board) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }
    
}
