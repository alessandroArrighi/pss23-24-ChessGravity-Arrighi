package it.unibo.chessgravity.model.impl;

import it.unibo.chessgravity.model.api.GravityObserver;
import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Class that models the enemy king piece. Unlike the other pieces, the enemy king
 * cannot be moved.
 */
public class Enemy implements GravityObserver {

    private final SquarePosition pos;
    private boolean alive;

    public Enemy(final SquarePosition pos) {
        this.pos = pos;
        alive = true;
    }

    public boolean isAlive() {
        return alive;
    }

    public void kill() {
        this.alive = false;
    }

    @Override
    public void gravity() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'gravity'");
    }

    @Override
    public SquarePosition getPos() {
        return this.pos;
    }
}
