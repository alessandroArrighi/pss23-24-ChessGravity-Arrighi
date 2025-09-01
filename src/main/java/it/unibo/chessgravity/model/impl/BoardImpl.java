package it.unibo.chessgravity.model.impl;

import java.util.*;

import it.unibo.chessgravity.model.api.*;
import it.unibo.chessgravity.model.api.square.Square;
import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Implementazione dell'interfaccia Board.
 * La classe funge da contenitore logico per la raccolta di tutte
 * le istanze di Square che comporrano la scacchiera. Qui ne
 * avviene la creazione e tutta la loro gestione.
 */

public class BoardImpl implements Board {
    /*
     * squareList is a List that contains a List<Square>. All the Squares in
     * the List<Square> are the whole squares that will compose one board's row
     */
    private final List<List<Square>> squareList;

    public BoardImpl(final int xLen, final int yLen, final Set<Piece> pieces, final Set<SquarePosition> obstacles) {
        if (xLen < 0 || yLen < 0) {
            throw new IllegalArgumentException("the board length argument must be greater then 0");
        }

        this.squareList = new ArrayList<>();

        /*
         * double for loop to cicle evry row and column and create the
         * appropriate square.
         */
        for(int y = 1; y <= yLen; ++y) {
            final List<Square> xLst = new ArrayList<>();

            for(int x = 1; x <= xLen; ++x) {
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

    @Override
    public Square getSquare(SquarePosition pos) {
        List<Square> lst = squareList.get(pos.getPosY());
        return lst.get(pos.getPosX());
    }
    
}
