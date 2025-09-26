package it.unibo.chessgravity.model.api.move;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Interface mapping the whole base move that one piece can do. 
 * All the pieces makes a move that is composed with a 
 * combination of these types of moves.
 */
public interface BaseMove {
    /**
     * Method that handles the base movement calculation.
     * 
     * @param start The starting position.
     * @param board The board used to checks the collisions.
     * @return {@link MoveResponse} object with all calculated results.
     */
    MoveResponse move(SquarePosition start, Board board);

    /**
     * Same method as {@link BaseMove#move(SquarePosition, Board)} but with
     * a different step.
     * 
     * @param start The starting position.
     * @param step The step used for the calculations. If a collision entity 
     * is between two steps, it will be ignored.
     * @return {@link MoveResponse} object with all calculated results.
     */
    MoveResponse move(SquarePosition start, Board board, int step);
}
