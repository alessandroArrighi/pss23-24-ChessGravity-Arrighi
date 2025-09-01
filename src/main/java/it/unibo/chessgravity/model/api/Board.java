package it.unibo.chessgravity.model.api;

/**
 * Interfaccia per rappresentare una scacchiera
 */

public interface Board {
    Square getSquare(SquarePosition pos);
}
