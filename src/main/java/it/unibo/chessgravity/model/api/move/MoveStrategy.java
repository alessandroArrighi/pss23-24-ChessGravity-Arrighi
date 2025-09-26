package it.unibo.chessgravity.model.api.move;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Strategy interface for the movements algorithms of the pieces.
 */
public interface MoveStrategy {
    /**
     * Strategy method that handle a movement.
     *  
     * @param start The starting position.
     * @param dest The destination position calculated.
     * @param board The board used to checks the collisions.
     * @return {@link MoveResponse} object with all calculated results.
     */
    MoveResponse move(SquarePosition start, SquarePosition dest, Board board);
}
