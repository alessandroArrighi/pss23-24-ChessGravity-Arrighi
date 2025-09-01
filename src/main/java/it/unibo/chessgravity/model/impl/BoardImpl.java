package it.unibo.chessgravity.model.impl;

import java.util.*;

import it.unibo.chessgravity.model.api.*;
import it.unibo.chessgravity.model.api.exceptions.IllegalSquarePositionException;
import it.unibo.chessgravity.model.api.square.Square;
import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Implementazione dell'interfaccia Board.
 * La classe funge da contenitore logico per la raccolta di tutte
 * le istanze di Square che comporrano la scacchiera. Qui ne
 * avviene la creazione e tutta la loro gestione.
 */

public class BoardImpl implements Board {
    public static final int MIN_LEN = 1;

    /*
     * squareList is a List that contains a List<Square>. All the Squares in
     * the List<Square> are the whole squares that will compose one board's row
     */
    private final List<List<Square>> squareList;
    private final int xLen;
    private final int yLen;

    public BoardImpl(final int xLen, final int yLen, final Set<SquarePosition> obstacles) {
        if (xLen < MIN_LEN || yLen < MIN_LEN) {
            throw new IllegalArgumentException("the board length argument must be greater then 0");
        }

        this.squareList = new ArrayList<>();
        this.xLen = xLen;
        this.yLen = yLen;

        /*
         * double for loop to cicle evry row and column and create the
         * appropriate square.
         */
        for(int y = MIN_LEN; y <= yLen; ++y) {
            final List<Square> xLst = new ArrayList<>();

            for(int x = MIN_LEN; x <= xLen; ++x) {
                final SquarePosition pos = new SquarePosition(x, y);
                
                if (obstacles.contains(pos)) {
                    xLst.add(new SquareObstacleImpl(pos));
                } else {
                    xLst.add(new SquarePieceImpl(pos));
                }
            }

            this.squareList.add(xLst);
        }
    }

    private boolean isValidPos(SquarePosition pos) {
        return (pos.getPosX() >= MIN_LEN && pos.getPosY() >= MIN_LEN &&
            pos.getPosX() <= xLen && pos.getPosY() <= yLen);
    }

    @Override
    public Square getSquare(SquarePosition pos) throws IllegalSquarePositionException {
        if (isValidPos(pos)) {
            List<Square> lst = squareList.get(pos.getPosY() - MIN_LEN);
            return lst.get(pos.getPosX() - MIN_LEN);
        }

        throw new IllegalSquarePositionException(pos);
    }
}
