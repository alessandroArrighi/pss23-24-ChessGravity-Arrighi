package it.unibo.chessgravity.model.impl;

import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Class that models the enemy king piece. Unlike the other pieces, the enemy king
 * cannot be moved.
 * When this class is created, it automatically sets the state of the king to 'alive'. 
 * This state can only be changed once.
 */
public class Enemy {

    private final SquarePosition pos;
    private boolean alive;

    /**
     * Class constructor
     * 
     * @param pos The position of the enemy. This cannot be changed.
     */
    public Enemy(final SquarePosition pos) {
        this.pos = pos;
        alive = true;
    }

    public boolean isAlive() {
        return alive;
    }

    /**
     * Method to 'kill' the enemy king. This method permanently changes
     * the state of this instance.
     */
    public void kill() {
        this.alive = false;
    }

    public SquarePosition getPos() {
        return this.pos;
    }
}
