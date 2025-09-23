package it.unibo.chessgravity.view.api;

import java.util.Set;

import it.unibo.chessgravity.model.utils.PieceSetting;

/**
 * Interface that map the view of the game
 */
public interface ChessGravityView {
    void move(Set<PieceSetting> pieces);
}
