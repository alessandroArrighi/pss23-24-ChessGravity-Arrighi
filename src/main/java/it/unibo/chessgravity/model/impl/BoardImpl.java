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
        for(int row = 1; row <= yLen; ++row) {
            final List<Square> rowLst = new ArrayList<>();

            for(int col = 1; col <= xLen; ++col) {
                final SquarePosition pos = new SquarePosition(row, col);
                
                if (obstacles.contains(pos)) {
                    rowLst.add(new SquareObstacleImpl(pos));
                } else {
                    rowLst.add(new SquarePieceImpl(pos));
                }
            }

            this.squareList.add(rowLst);
        }
    }

    @Override
    public Square getSquare(SquarePosition pos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSquare'");
    }
    
}
