package it.unibo.chessgravity.model.impl;

import java.util.*;

import it.unibo.chessgravity.model.api.*;
import it.unibo.chessgravity.model.api.exceptions.IllegalSquarePositionException;
import it.unibo.chessgravity.model.api.exceptions.SquareFullException;
import it.unibo.chessgravity.model.api.square.SquarePiece;
import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Implementazione dell'interfaccia Board.
 * La classe funge da contenitore logico per la raccolta di tutte
 * le istanze di Square che comporrano la scacchiera. Qui ne
 * avviene la creazione e tutta la loro gestione.
 */
public class BoardImpl implements Board {
    
    public static final int MIN_LEN = 1;

    private final Set<SquarePiece> squareList;
    private final Set<Piece> pieces;
    private final int xLen;
    private final int yLen;

    public BoardImpl(final int xLen, final int yLen, final Set<SquarePosition> obstacles) {
        if (xLen < MIN_LEN || yLen < MIN_LEN) {
            throw new IllegalArgumentException("the board length argument must be greater then 0");
        }

        this.pieces = new HashSet<>();
        this.squareList = new HashSet<>();
        this.xLen = xLen;
        this.yLen = yLen;


        // double for loop to cicle evry row and column and create the square.
        for(int x = MIN_LEN; x <= xLen; ++x) {
            for(int y = MIN_LEN; y <= yLen; ++y) {
                final SquarePosition pos = new SquarePosition(x, y);
                
                if (!obstacles.contains(pos)) {
                    this.squareList.add(new SquarePieceImpl(pos));
                }
            }
        }
    }

    @Override
    public Set<Piece> getAllPieces() {
        return this.pieces;
    }

    @Override
    public Piece getPiece(SquarePosition pos) {
        Piece piece;

        try {
            piece = getSquare(pos).getPiece();
        } catch (Exception e) {
            piece = null;
        }
        
        return piece;
    }

    @Override
    public void setPiece(Piece piece) throws IllegalSquarePositionException, SquareFullException {
        final SquarePosition pos = piece.getPos();
        SquarePiece square;
        
        // if piece is alredy on the board
        if (pieces.contains(piece)) {
            return;
        }

        square = getSquare(pos);

        // if there's an obstacle
        if (square == null) {
            throw new SquareFullException(pos);
        }

        square.setPiece(piece);

        pieces.add(piece);
    }

    @Override
    public void move(SquarePosition start, SquarePosition dest) throws Exception {
        final SquarePiece startSquare;
        final SquarePiece destSquare;
        final Piece piece;

        startSquare = getSquare(start);
        destSquare = getSquare(dest);

        piece = startSquare.getPiece();

        if (piece == null) {
            throw new Exception("Piece not found at " + start);
        }

        // This check prevents accidentally removing the piece from the board
        if (start.equals(dest)) {
            return;
        }

        destSquare.setPiece(piece);
        startSquare.setPiece(null);
    }

    @Override
    public boolean isSquareFree(SquarePosition pos) {
        final SquarePiece square;
        try {
            square = getSquare(pos);

            return square.isFree();
        } catch (IllegalSquarePositionException e) {
            return false;
        } catch (SquareFullException e) {
            return false;
        }
    }

    private boolean isValidPos(SquarePosition pos) {
        return (pos.getPosX() >= MIN_LEN && pos.getPosY() >= MIN_LEN &&
            pos.getPosX() <= xLen && pos.getPosY() <= yLen);
    }

    private SquarePiece getSquare(SquarePosition pos) throws IllegalSquarePositionException, SquareFullException {
        if (!isValidPos(pos)) {
            throw new IllegalSquarePositionException(pos);
        }

        try {
            return this.squareList.stream()
            .filter(x -> x.getPos().equals(pos))
            .findFirst()
            .get();
        } catch (NoSuchElementException e) {
            throw new SquareFullException(pos);
        }
    }
}
