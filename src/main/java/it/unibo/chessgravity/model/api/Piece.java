package it.unibo.chessgravity.model.api;

import it.unibo.chessgravity.model.api.move.MoveResponse;
import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.utils.PieceSetting;

/**
 * Interfaccia utilizzata per definire il
 * contratto d'uso di un pezzo.
 */

public interface Piece {
    PieceSetting info();

    SquarePosition getPos();

    MoveResponse move(SquarePosition dest) throws Exception;
}
