package it.unibo.chessgravity.model.api;

/**
 * Interfaccia utilizzata per definire il
 * contratto d'uso di un pezzo.
 */

public interface Piece {
    boolean move(Board board, Square destSquare);

    Square getSquare();

    void setSquare(Square square);
}
