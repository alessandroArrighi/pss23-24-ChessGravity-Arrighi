package it.unibo.chessgravity.model.impl;

import it.unibo.chessgravity.model.api.Piece;
import it.unibo.chessgravity.model.api.exceptions.SquareFullException;
import it.unibo.chessgravity.model.api.square.*;

/**
 * Class that implements the {@link SquarePiece} interface.
 * This class represents all board squares where a piece can be placed.
 */
public class SquarePieceImpl implements SquarePiece {
    private final SquarePosition pos;
    
    private Piece piece;
    private boolean free;

    /**
     * Class constructor. The square it's automatically set as a free square.
     * 
     * @param pos The position of the square. This cannot be change after
     * the constructor call.
     */
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
    public void setPiece(final Piece piece) throws SquareFullException {
        /*
         * if there's already another piece on this sqaure
         * and it has to be set a piece that is not the current piece
         */
        if (!isFree() && piece != null && !this.piece.equals(piece)) {
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
