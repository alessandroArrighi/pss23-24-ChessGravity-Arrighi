package it.unibo.chessgravity.model.impl.move;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.move.BaseMove;
import it.unibo.chessgravity.model.api.move.MovePiece;
import it.unibo.chessgravity.model.api.move.MoveResponse;
import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.impl.move.base.*;

import static it.unibo.chessgravity.model.utils.SquarePositions.*;

/**
 * Class that models the movement strategy that has to be done by a rook piece.
 */
public class MoveRook implements MovePiece {
    private final BaseMove moveTop;
    private final BaseMove moveBottom;
    private final BaseMove moveRight;
    private final BaseMove moveLeft;

    public MoveRook() {
        moveTop = new MoveTop();
        moveBottom = new MoveBottom();
        moveRight = new MoveRight();
        moveLeft = new MoveLeft();
    }

    @Override
    public MoveResponse move(final SquarePosition start, final SquarePosition dest,
                                final Board board) {
        BaseMove move = null;

        if (onTopColumn(dest, start)) {
            move = moveTop;
        } else if (onBottomColumn(dest, start)) {
            move = moveBottom;
        } else if (onLeftRow(dest, start)) {
            move = moveLeft;
        } else if (onRightRow(dest, start)) {
            move = moveRight;
        }

        return movePiece(start, dest, board, move);
    }

    private MoveResponse movePiece(final SquarePosition start, final SquarePosition dest, 
                                    final Board board, final BaseMove move) {
        if (move == null) {
            return new MoveResponse(null, false, false);
        }

        MoveResponse next = new MoveResponse(start, true, false);
        while (!dest.equals(next.getPos()) && next.canMove() && !next.isGameOver()) {
            next = move.move(next.getPos(), board);
        }

        return next;
    }
}