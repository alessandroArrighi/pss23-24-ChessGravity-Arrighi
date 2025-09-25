package it.unibo.chessgravity.view.api;

import java.util.List;

import it.unibo.chessgravity.controller.api.ChessGravityObserver;
import it.unibo.chessgravity.model.utils.PieceSetting;

/**
 * Interface that map the view of the game
 */
public interface ChessGravityView {
    void move(List<PieceSetting> pieces);

    void setObserver(ChessGravityObserver observer);

    void start(List<PieceSetting> pieces);

    void gameOver();
}
