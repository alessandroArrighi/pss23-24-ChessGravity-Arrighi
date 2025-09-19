package it.unibo.chessgravity.view.utils;

import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.view.api.EntityView;

/**
 * Utility class that models the position of a type {@link EntityView}
 * 
 * This also handle the conversion from and to {@link SquarePosition}
 */
public class Position {

    private final double posX;
    private final double posY;

    public Position(final double posX, final double posY) {
        this.posX = posX;
        this.posY = posY;
    }
    
    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }
}
