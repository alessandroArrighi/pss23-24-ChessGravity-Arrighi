package it.unibo.chessgravity.model.impl;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.Piece;
import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Implementazione dell'interfaccia Piece
 */
public class PieceImpl implements Piece {
    private SquarePosition pos;
    private final Board board;
    
    public PieceImpl(final Board board, final SquarePosition pos) {
        this.board = board;
        this.pos = pos;
    }

    @Override
    public SquarePosition getPos() {
        return this.pos;
    }

    @Override
    public void setPos(final SquarePosition pos) {
        this.pos = pos;
    }

    @Override
    public boolean move(Board board, SquarePosition dest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }
}
