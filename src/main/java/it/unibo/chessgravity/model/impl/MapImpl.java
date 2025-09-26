package it.unibo.chessgravity.model.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import it.unibo.chessgravity.model.api.*;
import it.unibo.chessgravity.model.api.exceptions.IllegalSquarePositionException;
import it.unibo.chessgravity.model.api.exceptions.InvalidSettingsException;
import it.unibo.chessgravity.model.api.exceptions.SquareFullException;
import it.unibo.chessgravity.model.api.move.MoveResponse;
import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.utils.PieceSetting;

/**
 * Class that models a map of the game.
 */
public class MapImpl implements Map {

    private final Board board;
    private final GravityObservable notifier;
    private boolean gameOver;

    public MapImpl(final Set<PieceSetting> pieces, final Set<SquarePosition> obstacles,
                    final int xLen, final int yLen, SquarePosition enemy) {
        board = new BoardImpl(xLen, yLen, obstacles, enemy);
        gameOver = false;

        createPieces(pieces);
        
        notifier = new GravityNotifier();
        board.getAllPieces().stream()
        .filter(x -> x instanceof GravityObserver)
        .forEach(x -> notifier.subscribe((GravityObserver) x));
    }
    
    private void createPieces(final Set<PieceSetting> pieces) {
        final PieceFactory factory = new PieceStandardFactory(board);
        try {
            for (PieceSetting piece : pieces) {
                final Piece p = factory.createPiece(piece.getType(), piece.getPos());
                board.setPiece(p);
            }
        } catch (IllegalSquarePositionException e) {
            throw new InvalidSettingsException(e.getMessage());
        } catch (SquareFullException e) {
            throw new InvalidSettingsException(e.getMessage());
        }
    }

    @Override
    public List<PieceSetting> move(SquarePosition start, SquarePosition dest) {
        if (gameOver) {
            return null;
        }

        final Piece piece = board.getPiece(start);

        if (piece == null) {
            return null;
        }

        final MoveResponse res = piece.move(dest);

        if (!res.canMove()) {
            return null;
        }

        // List contains the pieces that will be moved for the gravity by the notifier
        final List<PieceSetting> movedPieces = new ArrayList<>();
        
        /*
         * Call gravity notifier and return the result.
         * Creat a stram of Piece and save each piece info
         */
        notifier.notifyObservers(start).stream()
        .filter(x -> x instanceof Piece)
        .forEachOrdered(
            x -> movedPieces.add(((Piece) x).info())
        );

        this.gameOver = !board.isEnemyAlive();

        movedPieces.add(piece.info());

        return movedPieces;
    }

    @Override
    public boolean isGameOver() {
        return this.gameOver;
    }

    @Override
    public List<PieceSetting> start() {
        final List<GravityObserver> observers = notifier.notifyAllObservers();
        final List<PieceSetting> res = new ArrayList<>();

        observers.stream()
        .filter(x -> x instanceof Piece)
        .forEachOrdered(x -> res.add(((Piece) x).info()));

        gameOver = !board.isEnemyAlive();

        return res;
    }
}
