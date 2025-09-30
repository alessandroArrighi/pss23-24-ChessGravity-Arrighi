package it.unibo.chessgravity.model.api;

import java.util.Set;

import it.unibo.chessgravity.model.api.exceptions.IllegalSquarePositionException;
import it.unibo.chessgravity.model.api.exceptions.SquareFullException;
import it.unibo.chessgravity.model.api.move.MoveResponse;
import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Interface that maps a chess board.
 */
public interface Board {
    /**
     * Method used to get the a {@link Piece} object placed at the given position.
     * 
     * @param pos The position where the piece is placed.
     * @return The {@link Piece} object found at the given position. If the position 
     * is not valid or there's no piece, null will be returned.
     */
    Piece getPiece(SquarePosition pos);

    /**
     * Set a new piece on the board. If the piece is alredy set, the method will
     * return with no exceptions.
     * 
     * @param piece The new piece to be set.
     * @throws IllegalSquarePositionException
     * @throws SquareFullException
     */
    void setPiece(Piece piece) throws IllegalSquarePositionException, SquareFullException;

    /**
     * Methods used to move a piece to another position. This method will not checks
     * any logical condition about the requested movement. It's only purpose is to
     * set the destination position the piece placed at the start position.
     * 
     * @param start The starting position.
     * @param dest The destination position.
     * @throws IllegalSquarePositionException If one of the given position is not valid.
     * @throws SquareFullException If the given destination has already another entity placed.
     */
    void move(SquarePosition start, SquarePosition dest) throws 
        IllegalSquarePositionException, SquareFullException;

    /**
     * Method used to handle all the possible collision on the board at the given position.
     * 
     * @param pos The position to be checked.
     * @return {@link MoveResponse} object with all calculated results.
     */
    MoveResponse canMove(SquarePosition pos);

    Set<Piece> getAllPieces();

    boolean isEnemyAlive();
}
