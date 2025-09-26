package it.unibo.chessgravity.model.api;

import it.unibo.chessgravity.model.api.move.MoveResponse;
import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.utils.PieceSetting;

/**
 * Interface used to define the usage of a piece.
 */

public interface Piece {
    PieceSetting info();

    SquarePosition getPos();

    /**
     * Method used to move the current piece istance. This will handle all the
     * collision and the communication with the board. 
     * It also handles the gravity calls.
     * 
     * @param dest The destination position of the requested movement.
     * @return {@link MoveResponse} object with all calculated results.
     */
    MoveResponse move(SquarePosition dest);
}
