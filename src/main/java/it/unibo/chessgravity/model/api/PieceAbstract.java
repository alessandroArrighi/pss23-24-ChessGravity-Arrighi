package it.unibo.chessgravity.model.api;

/**
 * Classe astratta utilizzata per raggruppare le implementazioni
 * comuni dei 
 */

public abstract class PieceAbstract implements Piece {
    private Board board;
    private Square square;

    public PieceAbstract(Board board, Square square) {
        this.board = board;
        this.square = square;
    }

    @Override
    public Square getSquare() {
        return this.square;
    }
}
