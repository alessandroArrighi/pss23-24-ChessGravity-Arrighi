package it.unibo.chessgravity.model.impl.move;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.move.BaseMove;
import it.unibo.chessgravity.model.api.move.MovePiece;
import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.impl.move.base.*;
import static it.unibo.chessgravity.model.utils.SquarePositions.*;

/**
 * Class that models the movement strategy that has to be done by a king piece.
 */
public class MoveKing implements MovePiece {
    private final BaseMove moveTopLeft;
    private final BaseMove moveTop;
    private final BaseMove moveTopRight;
    private final BaseMove moveLeft;
    private final BaseMove moveRight;
    private final BaseMove moveBottomLeft;
    private final BaseMove moveBottom;
    private final BaseMove moveBottomRight;

    public MoveKing() {
        moveTopLeft = new MoveTopLeft();
        moveTop = new MoveTop();
        moveTopRight = new MoveTopRight();
        moveLeft = new MoveLeft();
        moveRight = new MoveRight();
        moveBottomLeft = new MoveBottomLeft();
        moveBottom = new MoveBottom();
        moveBottomRight = new MoveBottomRight();
    }

    @Override
    public boolean move(SquarePosition start, SquarePosition dest, Board board) {
        BaseMove move = null;

        if (onTopLeftDiagonal(dest, start)) {
            move = moveTopLeft;
        } else if (onTopColumn(dest, start)) {
            move = moveTop;
        } else if (onTopRightDiagonal(dest, start)) {
            move = moveTopRight;
        } else if (onLeftRow(dest, start)) {
            move = moveLeft;
        } else if (onRightRow(dest, start)) {
            move = moveRight;
        } else if (onBottomLeftDiagonal(dest, start)) {
            move = moveBottomLeft;
        } else if (onBottomColumn(dest, start)) {
            move = moveBottom;
        } else if (onBottomRightDiagonal(dest, start)) {
            move = moveBottomRight;
        }

        if (move == null) {
            return false;
        }

        return move.move(start, board) != null;
    }
}
