package it.unibo.chessgravity.view.api;

import it.unibo.chessgravity.view.utils.Position;

/**
 * Interface that maps a generic entity view of the game
 */
public interface EntityView {
    void setSize(int size);

    Position getPosition();
    
    void setPosition(Position pos);
}
