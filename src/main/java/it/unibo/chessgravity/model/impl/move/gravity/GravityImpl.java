package it.unibo.chessgravity.model.impl.move.gravity;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.move.BaseMove;
import it.unibo.chessgravity.model.api.move.Gravity;
import it.unibo.chessgravity.model.api.move.MoveResponse;
import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.impl.move.base.MoveBottom;

/**
 * Class that models the gravity movement. This class will calculate the lowest
 * position of the board that a piece has to be palced.
 */
public class GravityImpl implements Gravity {
    private final BaseMove moveBottom;

    public GravityImpl() {
        moveBottom = new MoveBottom();
    }

    @Override
    public MoveResponse gravity(SquarePosition start, Board board) {
        MoveResponse current = new MoveResponse(start, true, false);
        MoveResponse next = current;

        while (next.canMove() && !next.isGameOver()) {
            current = next;
            next = moveBottom.move(current.getPos(), board);
        }

        if (next.isGameOver()) {
            return next;
        }

        return current;
    }
}
