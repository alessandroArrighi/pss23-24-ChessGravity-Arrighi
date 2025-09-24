package it.unibo.chessgravity.model.api;

import java.util.Set;

import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.utils.PieceSetting;

/**
 * Interface mapping the map of the game.
 */
public interface Map {
    Set<PieceSetting> move(SquarePosition start, SquarePosition dest) throws Exception;

    boolean isGameOver();
}
