package it.unibo.chessgravity.model.api.exceptions;

import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Chacked exception that handles the state when a square is
 * already occupated by another piece.
 */

public class SquareFullException extends Exception {
    public SquareFullException(SquarePosition pos) {
        super("the square in "
                + pos + " has already another piece");
    }
}
