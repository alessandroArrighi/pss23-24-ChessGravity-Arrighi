package it.unibo.chessgravity.model.impl.move;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.move.MovePiece;
import it.unibo.chessgravity.model.api.square.SquarePosition;
import static it.unibo.chessgravity.model.utils.SquarePositions.*;

/**
 * Class that models the movement strategy that has to be done by a queen piece.
 */
public class MoveQueen implements MovePiece {
    private final MovePiece moveBishop;
    private final MovePiece moveRook;

    public MoveQueen() {
        moveBishop = new MoveBishop();
        moveRook = new MoveRook();
    }

    @Override
    public boolean move(SquarePosition start, SquarePosition dest, Board board) {
        MovePiece move = null;

        if (onSameColumn(start, dest) || onSameRow(start, dest)) {
            move = moveRook;
        } else if (onSameDiagonal(start, dest)) {
            move = moveBishop;
        }

        if (move == null) {
            return false;
        }

        return move.move(start, dest, board);
    }
}
