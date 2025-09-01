package it.unibo.chessgravity.model.api.square;

import it.unibo.chessgravity.model.api.Piece;

/**
 * Interfaccia che definisce il contratto d'uso
 * di una casa che può contenere pezzi
 */

public interface SquarePiece {
    Piece getPiece();

    void setPiece(Piece piece);
}
