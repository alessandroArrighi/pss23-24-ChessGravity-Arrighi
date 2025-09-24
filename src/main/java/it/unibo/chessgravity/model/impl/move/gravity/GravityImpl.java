package it.unibo.chessgravity.model.impl.move.gravity;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.move.BaseMove;
import it.unibo.chessgravity.model.api.move.Gravity;
import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.impl.move.base.MoveBottom;

/**
 * class that models the gravity movement. This class will calculate the lowest
 * position of the board that a piece has to be palced.
 */

public class GravityImpl implements Gravity {
    private final BaseMove moveBottom;

    public GravityImpl() {
        moveBottom = new MoveBottom();
    }

    @Override
    public SquarePosition gravity(SquarePosition start, Board board) {
        SquarePosition current = start;
        SquarePosition next = start;

        throw new UnsupportedOperationException();

        // while (next != null) {
        //     current = next;
        //     next = moveBottom.move(current, board);
        // }

        // return current;
    }
}
