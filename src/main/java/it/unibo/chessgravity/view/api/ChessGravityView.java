package it.unibo.chessgravity.view.api;

import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Interface that map the view of the game
 */
public interface ChessGravityView {
    void move(SquarePosition start, SquarePosition dest);
}
