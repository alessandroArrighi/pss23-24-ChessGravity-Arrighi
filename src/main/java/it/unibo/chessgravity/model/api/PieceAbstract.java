package it.unibo.chessgravity.model.api;

/**
 * Classe astratta utilizzata per raggruppare le implementazioni
 * comuni dei 
 */

public abstract class PieceAbstract implements Piece {
    private Square square;
    private final Board board;
    
    public PieceAbstract(final Board board, final Square square) {
        this.board = board;
        this.square = square;
    }

    @Override
    public Square getSquare() {
        return this.square;
    }

    protected void setSquare(final Square square) {
        this.square = square;
    }
}
