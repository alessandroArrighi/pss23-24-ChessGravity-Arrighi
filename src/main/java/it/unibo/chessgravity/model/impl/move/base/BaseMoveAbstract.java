package it.unibo.chessgravity.model.impl.move.base;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.exceptions.IllegalSquarePositionException;
import it.unibo.chessgravity.model.api.move.BaseMove;
import it.unibo.chessgravity.model.api.square.Square;
import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Abstract class that implement the base movement of a piece.
 * 
 * This class provide a template method, to be implemented by each specific
 * move subclass.
 */

public abstract class BaseMoveAbstract implements BaseMove {
    private final int DEFAULT_STEP = 1;
    protected int STEP = DEFAULT_STEP;

    @Override
    public SquarePosition move(SquarePosition start, Board board) {
        // calculate new position
        SquarePosition pos = calculatePos(start.getPosX(), start.getPosY());

        try {
            Square square = board.getSquare(pos);

            if (square.isFree()) {
                return pos;
            }
        } catch (IllegalSquarePositionException e) { }

        /*
         * return null if the getSquare method throws IllegalSquarePositionException
         * or the square to move the piece is not free
         */
        return null;
    }

    /*
     * takes the step value to be used for a different movement caluclation.
     * If the step moves the
     */
    @Override
    public SquarePosition move(SquarePosition start, Board board, int step) {
        STEP = step;
        
        final SquarePosition pos = move(start, board);

        STEP = DEFAULT_STEP;

        return pos;
    }

    /*
     * The template method that calculate a specific type of movement for a piece.
     */
    abstract protected SquarePosition calculatePos(int posX, int posY);
}
