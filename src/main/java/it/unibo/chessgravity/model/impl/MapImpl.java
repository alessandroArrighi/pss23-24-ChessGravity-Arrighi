package it.unibo.chessgravity.model.impl;

import java.util.Set;

import it.unibo.chessgravity.model.api.*;
import it.unibo.chessgravity.model.api.exceptions.InvalidSettingsException;
import it.unibo.chessgravity.model.api.move.Gravity;
import it.unibo.chessgravity.model.api.square.SquarePiece;
import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.impl.move.gravity.GravityImpl;
import it.unibo.chessgravity.model.utils.PieceSetting;

/**
 * Class that models a map of the game.
 */
public class MapImpl implements Map {

    private final Board board;
    private final Gravity gravity;

    public MapImpl(final Set<PieceSetting> pieces, final Set<SquarePosition> obstacles,
                    final int xLen, final int yLen) throws InvalidSettingsException {
        board = new BoardImpl(xLen, yLen, obstacles);
        gravity = new GravityImpl();

        createPieces(pieces);
    }
    
    private void createPieces(final Set<PieceSetting> pieces) throws InvalidSettingsException {
        final PieceFactory factory = new PieceStandardFactory(board);
        try {
            for (PieceSetting piece : pieces) {
                final SquarePiece square = (SquarePiece) board.getSquare(piece.getPos());
                square.setPiece(factory.createPiece(piece.getType(), piece.getPos()));
            }
        } catch (ClassCastException e) {
            throw new InvalidSettingsException(
                "Found a position of a sqaure that cannot be SquarePiece type");
        } catch (Exception e) {
            final InvalidSettingsException exception;
            final String message = e.getMessage();
            if (message.isBlank()) {
                exception = new InvalidSettingsException();
            } else {
                exception = new InvalidSettingsException(message);
            }

            throw exception;
        }
    }

    @Override
    public SquarePosition move(SquarePosition start, SquarePosition dest) {
        final SquarePiece square;
        final Piece piece;
        final SquarePosition result;
        
        /*
         * Try to get the sqaure from the board with the given position (start).
         * If the position is not valid, the Square is not a SquarePiece type or
         * the square has no piece placed, return false.
         * This beacause the movement cannot be done.
         */
        try {
            square = (SquarePiece) board.getSquare(start);
            piece = square.getPiece();

            if (piece == null) {
                throw new Exception();
            }
        } catch (Exception e) {
            return null;
        }
        
        if (piece.move(dest)) {
            result = gravity.gravity(piece.getPos(), board);
        } else result = null;

        return result;
    }
}
