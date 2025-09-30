package it.unibo.chessgravity.model.utils;

import static it.unibo.chessgravity.model.utils.PieceGroup.*;

/**
 * Utility class that models the type of a {@link Piece}.
 * Each type is grouped according to a category 
 * defined in the {@link PieceGroup} class.
 */
public enum PieceType {
    KING(STANDARD), 
    QUEEN(STANDARD),
    ROOK(STANDARD),
    BISHOP(STANDARD),
    KNIGHT(STANDARD);

    private final PieceGroup group;

    /**
     * Class constructor.
     * 
     * @param group The group that defines the catory of the istance.
     */
    private PieceType(final PieceGroup group) {
        this.group = group;
    }

    public PieceGroup getGroup() {
        return this.group;
    }
}
