package it.unibo.chessgravity.model.api;

import it.unibo.chessgravity.model.api.exceptions.IllegalSquarePositionException;
import it.unibo.chessgravity.model.api.square.Square;
import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Interfaccia per rappresentare una scacchiera
 */

public interface Board {
    Square getSquare(SquarePosition pos) throws IllegalSquarePositionException;
}
