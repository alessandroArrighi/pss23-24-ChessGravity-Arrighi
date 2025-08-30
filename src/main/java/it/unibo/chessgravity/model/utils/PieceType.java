package it.unibo.chessgravity.model.utils;

import static it.unibo.chessgravity.model.utils.PieceGroup.*;

public enum PieceType {
    KING(STANDARD), 
    QUEEN(STANDARD),
    ROOK(STANDARD),
    BISHOP(STANDARD),
    KNIGHT(STANDARD);

    private final PieceGroup group;

    private PieceType(final PieceGroup group) {
        this.group = group;
    }

    public PieceGroup getGroup() {
        return this.group;
    }
}
