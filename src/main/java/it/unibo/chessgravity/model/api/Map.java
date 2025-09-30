package it.unibo.chessgravity.model.api;

import java.util.List;

import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.utils.PieceSetting;

/**
 * Interface mapping the map of the game.
 */
public interface Map {
    /**
     * Method used to get a move request by the view and return the moved pieces.
     * 
     * @param start The starting position of the piece.
     * @param dest The destination position.
     * @return A list of {@link PieceSetting} objects. These are all the moved pieces by
     * the gravity after the movement of the piece. This Method returns null if the game is
     * over or if the movement is not possible to be done.
     */
    List<PieceSetting> move(SquarePosition start, SquarePosition dest);

    /**
     * Method used to start the game.
     * 
     * @return A list of {@link PieceSetting} objects. These are the pieces sorted after the
     * gravity calls.
     */
    List<PieceSetting> start();

    boolean isGameOver();
}
