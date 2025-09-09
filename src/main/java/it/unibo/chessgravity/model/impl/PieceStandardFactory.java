package it.unibo.chessgravity.model.impl;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.Piece;
import it.unibo.chessgravity.model.api.PieceFactory;
import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.impl.move.*;
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
    public Piece createPiece(final PieceType type, final SquarePosition pos) {
        final Piece res;

        switch (type) {
            case KING:
                res = this.createKing(type);
                break;
            
            case QUEEN:
                res = this.createQueen(type);
                break;

            case ROOK:
                res = this.createRook(type);
                break;
            
            case BISHOP:
                res = this.createBishop(type);
                break;
            
            case KNIGHT:
                res = this.createKnight(type);
                break;
        
            default:
                res = null;
                throw new IllegalArgumentException("Not a standrd piece type: " + type);
        }

        res.setPos(pos);
        return res;
    }

    private Piece createKing(final PieceType type) {
        return new PieceImpl(board, null, new MoveKing(), type);
    }

    private Piece createQueen(final PieceType type) {
        return new PieceImpl(board, null, new MoveQueen(), type);
    }

    private Piece createRook(final PieceType type) {
        return new PieceImpl(board, null, new MoveRook(), type);
    }

    private Piece createBishop(final PieceType type) {
        return new PieceImpl(board, null, new MoveBishop(), type);
    }

    private Piece createKnight(final PieceType type) {
        return new PieceImpl(board, null, new MoveKnight(), type);
    }
}
