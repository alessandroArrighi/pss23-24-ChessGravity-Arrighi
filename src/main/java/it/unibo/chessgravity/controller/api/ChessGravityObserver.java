package it.unibo.chessgravity.controller.api;

import it.unibo.chessgravity.view.utils.Position;

/**
 * Interface that maps the controller for binding the view with the model
 */
public interface ChessGravityObserver {
    /**
     * Method used by the view to ask the model to handle
     * a movement selected by the user.
     * 
     * @param start The start (current) position of the piece
     * @param dest The destination position of the piece.
     */
    void move(Position start, Position dest);

    void restart();

    void quit();
}