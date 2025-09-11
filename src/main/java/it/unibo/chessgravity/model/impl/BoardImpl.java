package it.unibo.chessgravity.model.impl;

import java.util.*;

import it.unibo.chessgravity.model.api.*;
import it.unibo.chessgravity.model.api.exceptions.IllegalSquarePositionException;
import it.unibo.chessgravity.model.api.exceptions.SquareFullException;
import it.unibo.chessgravity.model.api.square.Square;
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

    private boolean isValidPos(SquarePosition pos) {
        return (pos.getPosX() >= MIN_LEN && pos.getPosY() >= MIN_LEN &&
            pos.getPosX() <= xLen && pos.getPosY() <= yLen);
    }

    @Override
    public Piece getPiece(SquarePosition pos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPiece'");
    }

    @Override
    public void setPiece(Piece piece) throws IllegalSquarePositionException, SquareFullException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPiece'");
    }

    @Override
    public void move(SquarePosition start, SquarePosition dest) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }

    @Override
    public boolean isSquareFree(SquarePosition pos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isSquareFree'");
    }
}
