package it.unibo.chessgravity.model.api;

import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Interface mapping the map of the game.
 */
public interface Map {
    boolean move(SquarePosition start, SquarePosition dest);
}
