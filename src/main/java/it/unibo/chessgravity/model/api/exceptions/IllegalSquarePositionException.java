package it.unibo.chessgravity.model.api.exceptions;

import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Checked exception that handles an invalid position provided.
 */
public class IllegalSquarePositionException extends Exception {
    public IllegalSquarePositionException(final SquarePosition pos) {
        super(pos + " is not valid");
    }
}
