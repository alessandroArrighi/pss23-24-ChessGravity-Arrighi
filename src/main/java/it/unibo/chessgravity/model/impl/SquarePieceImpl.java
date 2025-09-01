package it.unibo.chessgravity.model.impl;

import it.unibo.chessgravity.model.api.Piece;
import it.unibo.chessgravity.model.api.square.*;

/**
 * Implementazione dell'interfaccia SquarePiece.
 * La classe rappresenta tutte le case in cui è possibile
 * posizionare un pezzo.
 */

public class SquarePieceImpl implements SquarePiece {
    private final SquarePosition pos;
    
    private Piece piece;
    private boolean free;

    public SquarePieceImpl(final SquarePosition pos) {
        this.pos = pos;
        this.free = true;
    }
    
    @Override
    public boolean isFree() {
        return this.free;
    }

    @Override
    public SquarePosition getPos() {
        return this.pos;
    }

    @Override
    public Piece getPiece() {
        return this.piece;
    }

    @Override
    public void setPiece(Piece piece) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPiece'");
    }
}
