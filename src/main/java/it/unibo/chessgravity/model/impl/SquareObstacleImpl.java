package it.unibo.chessgravity.model.impl;

import it.unibo.chessgravity.model.api.square.SquareObstacle;
import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Implementazione dell'interfaccia SquareObstacle.
 * Lo stato della classe sarà analogo per tutte le
 * sue istanze. Non vi è possibilità di applicare
 * modifiche
 * La classe quindi funge da "place holder" per indicare
 * quale casa deve prendere le sembianze di un'ostacolo.
 */

public class SquareObstacleImpl implements SquareObstacle {
    private final boolean free;
    private final SquarePosition pos;

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
