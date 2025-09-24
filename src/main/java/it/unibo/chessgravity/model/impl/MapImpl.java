package it.unibo.chessgravity.model.impl;

import java.util.HashSet;
import java.util.Set;

import it.unibo.chessgravity.model.api.*;
import it.unibo.chessgravity.model.api.exceptions.InvalidSettingsException;
import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.utils.PieceSetting;

/**
 * Class that models a map of the game.
 */
public class MapImpl implements Map {

    private final Board board;
    private final GravityObservable notifier;

    public MapImpl(final Set<PieceSetting> pieces, final Set<SquarePosition> obstacles,
                    final int xLen, final int yLen, SquarePosition enemy)
                                                        throws InvalidSettingsException {
        board = new BoardImpl(xLen, yLen, obstacles);

        createPieces(pieces);
        
        notifier = new GravityNotifier();
        board.getAllPieces().stream()
        .filter(x -> x instanceof GravityObserver)
        .forEach(x -> notifier.subscribe((GravityObserver) x));
    }
    
    private void createPieces(final Set<PieceSetting> pieces) throws InvalidSettingsException {
        final PieceFactory factory = new PieceStandardFactory(board);
        try {
            for (PieceSetting piece : pieces) {
                final Piece p = factory.createPiece(piece.getType(), piece.getPos());
                board.setPiece(p);
            }
        } catch (Exception e) {
            throw new InvalidSettingsException(e.getMessage());
        }
    }

    @Override
    public Set<PieceSetting> move(SquarePosition start, SquarePosition dest) throws Exception {
        final Piece piece = board.getPiece(start);

        if (piece == null) {
            return null;
        }

        if (!piece.move(dest)) {
            return null;
        }

        // Set contains the pieces that will be moved for the gravity by the notifier
        final Set<PieceSetting> movedPieces = new HashSet<>();
        
        /*
         * Call gravity notifier and return the result.
         * Creat a stram of Piece and save each piece info
         */
        notifier.notifyObservers(start).stream()
        .filter(x -> x instanceof Piece)
        .forEach(
            x -> movedPieces.add(((Piece) x).info())
        );

        movedPieces.add(piece.info());

        return movedPieces;
    }
}
