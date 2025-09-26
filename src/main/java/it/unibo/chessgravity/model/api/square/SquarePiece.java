package it.unibo.chessgravity.model.api.square;

import it.unibo.chessgravity.model.api.Piece;
import it.unibo.chessgravity.model.api.exceptions.SquareFullException;

/**
 * Interface that defines the usage of a square that can contain a piece.
 */
public interface SquarePiece extends Square {
    Piece getPiece();

    void setPiece(Piece piece) throws SquareFullException;
}
