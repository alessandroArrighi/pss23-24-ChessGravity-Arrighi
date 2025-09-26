package it.unibo.chessgravity.model.api.move;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Interface that maps a gravity movement.
 */
public interface Gravity {
    /**
     * Method used to hanlde the gravity calculation.
     * 
     * @param start The start position.
     * @param board The board used to checks the collisions.
     * @return {@link MoveResponse} object with all calculated results.
     */
    MoveResponse gravity(SquarePosition start, Board board);
}
