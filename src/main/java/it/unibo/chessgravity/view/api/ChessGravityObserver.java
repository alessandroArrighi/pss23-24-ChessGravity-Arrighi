package it.unibo.chessgravity.view.api;

import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Interface that maps the controller for binding the view with the model
 */
public interface ChessGravityObserver {
    void move(SquarePosition start, SquarePosition dest);
}