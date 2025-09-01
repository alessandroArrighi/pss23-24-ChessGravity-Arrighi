package it.unibo.chessgravity.model.api;

import it.unibo.chessgravity.model.api.square.Square;

/**
 * Interfaccia utilizzata per definire il
 * contratto d'uso di un pezzo.
 */

public interface Piece {
    Square getSquare();

    boolean move(Board board, Square destSquare);
}
