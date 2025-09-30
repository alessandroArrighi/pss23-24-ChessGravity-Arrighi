package it.unibo.chessgravity.model.api;

import it.unibo.chessgravity.model.api.move.BaseMove;
import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.utils.PieceType;

/**
 * Interface for implementing the factory method of the pieces.
 */
public interface PieceFactory {
    /**
     * Creational method that maps the Factory pattern for the pieces.
     * Each type of piece must be defined by the {@link PieceType} class.
     * The method uses this to create a piece 
     * and assign its specific {@link BaseMove}.
     * 
     * @param type The type of the new piece that has to be created.
     * @param pos The position of the new piece.
     * @return The new piece created.
     */
    Piece createPiece(final PieceType type, final SquarePosition pos);
}
