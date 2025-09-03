package it.unibo.chessgravity.model.impl;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.Piece;
import it.unibo.chessgravity.model.api.PieceFactory;
import it.unibo.chessgravity.model.utils.PieceType;

/**
 * Implementazione standard dell'interfaccia PieceFactory.
 * Questa classe si occupa di creare tutti i pezzi standard del gioco.
 */

public class PieceStandardFactory implements PieceFactory {
    private final Board board;

    public PieceStandardFactory(Board board) {
        this.board = board;
    }

    @Override
    public Piece createPiece(final PieceType type) {
        final Piece res;

        switch (type) {
            case KING:
                res = this.createKing();
                break;
            
            case QUEEN:
                res = this.createQueen();
                break;

            case ROOK:
                res = this.createRook();
                break;
            
            case BISHOP:
                res = this.createBishop();
                break;
            
            case KNIGHT:
                res = this.createKnight();
                break;
        
            default:
                res = null;
                break;
        }

        throw new UnsupportedOperationException("Unimplemented method 'createPiece'");
    }

    private Piece createKing() {
        throw new UnsupportedOperationException("Unimplemented method 'createKing'");
    }

    private Piece createQueen() {
        throw new UnsupportedOperationException("Unimplemented method 'createQueen'");
    }

    private Piece createRook() {
        throw new UnsupportedOperationException("Unimplemented method 'createRook'");
    }

    private Piece createBishop() {
        throw new UnsupportedOperationException("Unimplemented method 'createBishop'");
    }

    private Piece createKnight() {
        throw new UnsupportedOperationException("Unimplemented method 'createKnight'");
    }
}
