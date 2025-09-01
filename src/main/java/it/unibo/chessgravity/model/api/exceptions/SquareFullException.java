package it.unibo.chessgravity.model.api.exceptions;

import it.unibo.chessgravity.model.api.square.SquarePiece;
import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Chacked exception that handles the state when a square is
 * already occupated by another piece.
 */

public class SquareFullException extends Exception {
    private final SquarePosition pos;

    public SquareFullException(SquarePiece square) {
        super();

        this.pos = square.getPos();
    }

    @Override
    public String toString() {
        return "Faild with exception: the square in "
                + pos + " has already another piece";
    }
}
