package it.unibo.chessgravity.model.impl.move;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.move.BaseMove;
import it.unibo.chessgravity.model.api.move.MovePiece;
import it.unibo.chessgravity.model.api.move.MoveResponse;
import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.impl.move.base.*;
import static it.unibo.chessgravity.model.utils.SquarePositions.*;

/**
 * Class that models the movement strategy that has to be done by a bishop piece.
 */
public class MoveBishop implements MovePiece {
    private final BaseMove moveTopLeft;
    private final BaseMove moveTopRight;
    private final BaseMove moveBottomLeft;
    private final BaseMove moveBottomRight;

    public MoveBishop() {
        moveTopLeft = new MoveTopLeft();
        moveTopRight = new MoveTopRight();
        moveBottomLeft = new MoveBottomLeft();
        moveBottomRight = new MoveBottomRight();
    }
    
    @Override
    public MoveResponse move(SquarePosition start, SquarePosition dest, Board board) {
        BaseMove move = null;

        if (onTopLeftDiagonal(dest, start)) {
            move = moveTopLeft;
        } else if (onTopRightDiagonal(dest, start)) {
            move = moveTopRight;
        } else if (onBottomLeftDiagonal(dest, start)) {
            move = moveBottomLeft;
        } else if (onBottomRightDiagonal(dest, start)) {
            move = moveBottomRight;
        }

        return movePiece(start, dest, board, move);
    }

    private MoveResponse movePiece(SquarePosition start, SquarePosition dest, 
                                Board board, BaseMove move) {
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
