package it.unibo.chessgravity.model.utils;

import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Utility class for store the setting for each piece to create in a Map.
 * The class store the type value and the position of a piece.
 * 
 * These data will be esued to create a piece.
 */
public class PieceSetting {

    private final SquarePosition pos;
    private final PieceType type;

    public PieceSetting(final SquarePosition pos, final PieceType type) {
        this.pos = pos;
        this.type = type;
    }

    public SquarePosition getPos() {
        return this.pos;
    }

    public PieceType getType() {
        return this.type;
    }
}
