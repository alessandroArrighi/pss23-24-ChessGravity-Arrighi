package it.unibo.chessgravity.model.api.square;

/**
 * Interfaccia per il contratto di una casa generica.
 */

public interface Square {
    boolean isFree();

    SquarePosition getPos();
}
