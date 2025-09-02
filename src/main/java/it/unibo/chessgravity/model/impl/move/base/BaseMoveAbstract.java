package it.unibo.chessgravity.model.impl.move.base;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.move.BaseMove;
import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Abstract class that implement the base movement of a piece.
 * 
 * This class provide a template method, to be implemented by each specific
 * move subclass.
 */

public abstract class BaseMoveAbstract implements BaseMove {

    @Override
    public SquarePosition move(SquarePosition start, Board board) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }

    /*
     * The template method that calculate a specific type of movement for a piece.
     */
    abstract protected SquarePosition calculatePos(int posX, int posY);

}
