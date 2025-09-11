package it.unibo.chessgravity.model.impl;

import it.unibo.chessgravity.model.api.Piece;
import it.unibo.chessgravity.model.api.exceptions.SquareFullException;
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

    private void setFree(final boolean newState) {
        this.free = newState;
    }

    @Override
    public void setPiece(Piece piece) throws SquareFullException {
        /*
         * if there's already another piece on this sqaure
         * and it has to be set a new piece
         */
        if (!isFree() && piece != null) {
            throw new SquareFullException(this.pos);
        }

        /*
         * there's a real piece --> set the Square to not free (false)
         * there's not a real piece --> set the Square to free (true)
         */
        setFree(piece == null);

        this.piece = piece;
    }
}
