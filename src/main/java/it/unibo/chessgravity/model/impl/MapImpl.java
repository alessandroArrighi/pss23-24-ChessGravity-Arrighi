package it.unibo.chessgravity.model.impl;

import java.util.HashSet;
import java.util.Set;

import it.unibo.chessgravity.model.api.*;
import it.unibo.chessgravity.model.api.exceptions.IllegalSquarePositionException;
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
    private Set<PieceSetting> pieces;

    public MapImpl(final Set<PieceSetting> pieces, final Set<SquarePosition> obstacles,
                    final int xLen, final int yLen, SquarePosition enemy)
                                                        throws InvalidSettingsException {
        board = new BoardImpl(xLen, yLen, obstacles);
        gravity = new GravityImpl();

        createPieces(pieces);

        createEnemy(enemy);
    }

    private void createEnemy(final SquarePosition enemy) throws InvalidSettingsException {
        try {
            if (board.isSquareFree(enemy)) {
                throw new IllegalSquarePositionException(enemy);
            }

            if (Enemy.getIstance() != null) {
                throw new InvalidSettingsException("Enemy king has been alredy instantiated");
            }

            Enemy.createInstace(enemy);
        } catch (IllegalSquarePositionException e) {
            throw new InvalidSettingsException(e.getMessage());
        }
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }

    // private void pieceGravity(Piece piece, SquarePiece startSquare) throws Exception {
    //     final SquarePosition result;
    //     final SquarePiece destSquare;

    //     startSquare.setPiece(null);
        
    //     result = gravity.gravity(piece.getPos(), board);

    //     destSquare = (SquarePiece) board.getSquare(result);
    //     destSquare.setPiece(piece);

    //     piece.setPos(result);

    //     this.pieces.add(piece.info());
    // }

    // private void gravityChain(SquarePosition start) throws Exception {
    //     boolean flag = true;

    //     for(int i = start.getPosY() + 1; flag; ++i) {
    //         final SquarePosition pos = new SquarePosition(start.getPosX(), i);
    //         SquarePiece square = null;
    //         Piece piece = null;

    //         try {
    //             square = (SquarePiece) board.getSquare(pos);
    //             piece = square.getPiece();

    //             if (piece == null) {
    //                 flag = false;
    //             }
    //         } catch (Exception e) {
    //             flag = false;
    //         }

    //         if (flag) {
    //             pieceGravity(piece, square);
    //         }
    //     }
    // }

    // private boolean movePiece(Piece piece, SquarePiece square) throws Exception {
    //     final SquarePiece startSquare = (SquarePiece) board.getSquare(piece.getPos());
        
    //     if (!piece.move(square.getPos())) {
    //         return false;
    //     }

    //     startSquare.setPiece(null);
    //     square.setPiece(piece);

    //     return true;
    // }

    // @Override
    // public Set<PieceSetting> move(SquarePosition start, SquarePosition dest) throws Exception {
    //     final SquarePiece startSquare;
    //     final SquarePiece destSquare;
    //     final Piece piece;

    //     this.pieces = new HashSet<>();


        
        /*
         * Try to get the sqaure from the board with the given position (start).
         * If the position is not valid, the Square is not a SquarePiece type or
         * the square has no piece placed, return null.
         * This beacause the movement cannot be done.
         */
        // try {
        //     startSquare = (SquarePiece) board.getSquare(start);
        //     piece = startSquare.getPiece();

        //     if (piece == null) {
        //         throw new Exception();
        //     }

        //     destSquare = (SquarePiece) board.getSquare(dest);
        // } catch (Exception e) {
        //     return null;
        // }

        // if (movePiece(piece, destSquare)) {
        //     pieceGravity(piece, destSquare);
        //     gravityChain(start);
        // } else this.pieces = null;

        // return this.pieces;
    // }
}
