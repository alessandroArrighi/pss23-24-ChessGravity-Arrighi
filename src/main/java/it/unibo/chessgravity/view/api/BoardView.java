package it.unibo.chessgravity.view.api;

import javafx.scene.Node;

/**
 * Interface that maps the interaction between the board and one piece
 */
public interface BoardView {
    void setMove(Node piece);
}
