package it.unibo.chessgravity.model.api;

import it.unibo.chessgravity.model.api.exceptions.IllegalSquarePositionException;
import it.unibo.chessgravity.model.api.exceptions.SquareFullException;
import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Interfaccia per rappresentare una scacchiera
 */

public interface Board {
    Piece getPiece(SquarePosition pos);

    void setPiece(Piece piece) throws IllegalSquarePositionException, SquareFullException;

    void move(SquarePosition start, SquarePosition dest) throws Exception;

    boolean isSquareFree(SquarePosition pos);
}
