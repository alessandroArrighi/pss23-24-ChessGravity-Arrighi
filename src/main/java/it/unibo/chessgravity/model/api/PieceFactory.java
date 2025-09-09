package it.unibo.chessgravity.model.api;

import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.utils.PieceType;

/**
 * Interfaccaia per applicare il factory method dei pezzi.
 */

public interface PieceFactory {
    Piece createPiece(final PieceType type, final SquarePosition pos);
}
