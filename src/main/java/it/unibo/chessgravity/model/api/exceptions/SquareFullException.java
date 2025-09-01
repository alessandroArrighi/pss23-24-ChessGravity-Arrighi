package it.unibo.chessgravity.model.api.exceptions;

import it.unibo.chessgravity.model.api.square.SquarePiece;

/**
 * Chacked exception that handles the state when a square is
 * already occupated by another piece.
 */

public class SquareFullException extends Exception {
    public SquareFullException(SquarePiece square) {
        super("the square in "
                + square.getPos() + " has already another piece");
    }
}
