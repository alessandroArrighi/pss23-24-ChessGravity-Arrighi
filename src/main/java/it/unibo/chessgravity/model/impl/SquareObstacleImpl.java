package it.unibo.chessgravity.model.impl;

import it.unibo.chessgravity.model.api.square.SquareObstacle;
import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Class that implements the {@link SquareObstacle} interface.
 * The state of each instances and cannot be modified.
 * It effectively serves as a placeholder to mark squares 
 * that should behave as obstacles.
 */
public class SquareObstacleImpl implements SquareObstacle {
    private final boolean free;
    private final SquarePosition pos;

    /**
     * Class constructor.
     * 
     * @param pos The position of the obstacle.
     */
    public SquareObstacleImpl(final SquarePosition pos) {
        this.free = false;
        this.pos = pos;
    }

    @Override
    public boolean isFree() {
        return this.free;
    }

    @Override
    public SquarePosition getPos() {
        return this.pos;
    }

    @Override
    public void setObstacle() {
        return;
    }
}
