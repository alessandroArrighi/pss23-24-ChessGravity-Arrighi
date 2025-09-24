package it.unibo.chessgravity.model.api.move;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Strategy interface for the Moves algorithms of the pieces.
 */

public interface MoveStrategy {
    MoveResponse move(SquarePosition start, SquarePosition dest, Board board);
}
