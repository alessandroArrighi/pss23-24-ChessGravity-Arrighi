package it.unibo.chessgravity.model.api;

import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.utils.PieceType;

/**
 * Interface for implementing the factory method of the pieces.
 */
public interface PieceFactory {
    Piece createPiece(final PieceType type, final SquarePosition pos);
}
