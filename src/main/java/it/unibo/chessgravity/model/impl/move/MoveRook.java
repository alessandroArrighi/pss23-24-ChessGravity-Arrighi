package it.unibo.chessgravity.model.impl.move;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.move.BaseMove;
import it.unibo.chessgravity.model.api.move.MoveStrategy;
import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Class that models the movement strategy that has to be done by a rook piece.
 */
public class MoveRook implements MoveStrategy {

    @Override
    public boolean move(SquarePosition start, SquarePosition dest, Board board) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }

    private boolean movePiece(SquarePosition start, SquarePosition dest, 
                                Board board, BaseMove move) {
        if (move == null) {
            return false;
        }

        SquarePosition next = start;
        while (!dest.equals(next) && next != null) {
            next = move.move(next, board);
        }

        return next != null;
    }
}