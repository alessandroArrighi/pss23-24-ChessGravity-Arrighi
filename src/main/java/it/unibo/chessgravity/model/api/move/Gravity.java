package it.unibo.chessgravity.model.api.move;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * interface that maps a gravity movement
 */

public interface Gravity {
    SquarePosition gravity(SquarePosition start, Board board);
}
