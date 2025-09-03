package it.unibo.chessgravity.model.impl;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.Piece;
import it.unibo.chessgravity.model.api.move.MoveStrategy;
import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Implementazione dell'interfaccia Piece
 */
public class PieceImpl implements Piece {
    private SquarePosition pos;
    private final Board board;
    private final MoveStrategy move;
    
    public PieceImpl(final Board board, final SquarePosition pos,
                    final MoveStrategy move) {
        this.board = board;
        this.pos = pos;
        this.move = move;
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
    public boolean move(SquarePosition dest) {
        final boolean canMove = move.move(pos, dest, board);

        if (canMove) {
            pos = dest;
        }

        return canMove;
    }
}
