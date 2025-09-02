package it.unibo.chessgravity.model.api.move;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Interface mapping the whole base move that one piece can do. 
 * All the pieces makes a move that is composed with a 
 * combination of these types of moves.
 */

public interface BaseMove {
    SquarePosition move(SquarePosition start, Board board);
}
