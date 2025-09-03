package it.unibo.chessgravity.model.api;

import it.unibo.chessgravity.model.api.square.Square;
import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Interfaccia utilizzata per definire il
 * contratto d'uso di un pezzo.
 */

public interface Piece {
    SquarePosition getPos();

    void setPos(SquarePosition pos);

    boolean move(Board board, SquarePosition dest);
}
