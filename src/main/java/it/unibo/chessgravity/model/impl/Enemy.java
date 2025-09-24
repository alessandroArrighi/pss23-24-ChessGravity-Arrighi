package it.unibo.chessgravity.model.impl;

import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Class that models the enemy king piece. Unlike the other pieces, the enemy king
 * cannot be moved.
 */
public class Enemy {

    private final SquarePosition pos;

    public Enemy(final SquarePosition pos) {
        this.pos = pos;
    }

    public SquarePosition getPosition() {
        return this.pos;
    }
}
