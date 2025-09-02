package it.unibo.chessgravity.model.impl.move.base;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.exceptions.IllegalSquarePositionException;
import it.unibo.chessgravity.model.api.move.BaseMove;
import it.unibo.chessgravity.model.api.square.Square;
import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Class that models the base movement in direction of the bottom
 * of the square.
 */
public class MoveBottom implements BaseMove {
    @Override
    public SquarePosition move(SquarePosition start, Board board) {
        // calculate new position
        SquarePosition pos = new SquarePosition(start.getPosX(), start.getPosY() - STEP);

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
}
