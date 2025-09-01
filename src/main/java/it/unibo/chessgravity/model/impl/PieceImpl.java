package it.unibo.chessgravity.model.impl;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.Piece;
import it.unibo.chessgravity.model.api.square.Square;

/**
 * Implementazione dell'interfaccia Piece
 */

public class PieceImpl implements Piece {
    protected Square square;
    protected final Board board;
    
    public PieceImpl(final Board board, final Square square) {
        this.board = board;
        this.square = square;
    }

    @Override
    public Square getSquare() {
        return this.square;
    }

    protected void setSquare(final Square square) {
        this.square = square;
    }

    @Override
    public boolean move(Board board, Square destSquare) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }
}
