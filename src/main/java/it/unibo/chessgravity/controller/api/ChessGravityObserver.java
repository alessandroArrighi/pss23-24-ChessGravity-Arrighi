package it.unibo.chessgravity.controller.api;

import it.unibo.chessgravity.view.utils.Position;

/**
 * Interface that maps the controller for binding the view with the model
 */
public interface ChessGravityObserver {
    void move(Position start, Position dest);

    void restart();

    void quit();
}