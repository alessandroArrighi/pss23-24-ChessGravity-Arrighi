package it.unibo.chessgravity.model.api.exceptions;

import it.unibo.chessgravity.model.api.square.SquarePosition;

public class IllegalSquarePositionException extends Exception {
    public IllegalSquarePositionException(final SquarePosition pos) {
        super(pos + " is not valid");
    }
}
