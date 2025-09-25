package it.unibo.chessgravity.model.api;

import java.util.List;

import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.utils.PieceSetting;

/**
 * Interface mapping the map of the game.
 */
public interface Map {
    List<PieceSetting> move(SquarePosition start, SquarePosition dest) throws Exception;

    List<PieceSetting> start();

    boolean isGameOver();
}
