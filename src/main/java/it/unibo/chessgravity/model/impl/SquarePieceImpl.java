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

    public SquarePieceImpl(SquarePosition pos) {
        this.pos = pos;
    }
    
    @Override
    public boolean isFree() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isFree'");
    }

    @Override
    public SquarePosition getPos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPos'");
    }

    @Override
    public Piece getPiece() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPiece'");
    }

    @Override
    public void setPiece(Piece piece) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPiece'");
    }
}
