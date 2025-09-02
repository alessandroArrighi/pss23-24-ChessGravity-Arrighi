package it.unibo.chessgravity.model.impl.move;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.move.BaseMove;
import it.unibo.chessgravity.model.api.move.MoveStrategy;
import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.impl.move.base.MoveBottom;
import it.unibo.chessgravity.model.impl.move.base.MoveLeft;
import it.unibo.chessgravity.model.impl.move.base.MoveRight;
import it.unibo.chessgravity.model.impl.move.base.MoveTop;

/**
 * Class that models the movement strategy that has to be done by a rook piece.
 */
public class MoveRook implements MoveStrategy {
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