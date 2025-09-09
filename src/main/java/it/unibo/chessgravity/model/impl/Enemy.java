package it.unibo.chessgravity.model.impl;

import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Class that models the enemy king piece. Unlike the other pieces, the enemy king
 * cannot be moved. This class can be instantiated only once
 */
public class Enemy {
    private static Enemy instance;

    private final SquarePosition pos;

    private Enemy(SquarePosition pos) {
        this.pos = pos;
    }

    public static Enemy createInstace(final SquarePosition pos) {
        if (instance == null) {
            instance = new Enemy(pos);
        }

        return instance;
    }
}
