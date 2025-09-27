package it.unibo.chessgravity.model.impl;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.Piece;
import it.unibo.chessgravity.model.api.PieceFactory;
import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.impl.move.*;
import it.unibo.chessgravity.model.utils.PieceType;

/**
 * Class that implements the {@link PieceFactory} interface.
 * This class creates all the standard pieces ({@link PieceImpl}) used in the game.
 */
public class PieceStandardFactory implements PieceFactory {
    
    private final Board board;

    /**
     * Constructor class.
     * 
     * @param board The board injected to the new {@link Piece}.
     */
    public PieceStandardFactory(Board board) {
        this.board = board;
    }

    @Override
    public Piece createPiece(final PieceType type, final SquarePosition pos) {
        final Piece res;

        switch (type) {
            case KING:
                res = this.createKing(type, pos);
                break;
            
            case QUEEN:
                res = this.createQueen(type, pos);
                break;

            case ROOK:
                res = this.createRook(type, pos);
                break;
            
            case BISHOP:
                res = this.createBishop(type, pos);
                break;
            
            case KNIGHT:
                res = this.createKnight(type, pos);
                break;
        
            default:
                res = null;
                throw new IllegalArgumentException("Not a standrd piece type: " + type);
        }

        return res;
    }

    private Piece createKing(final PieceType type, final SquarePosition pos) {
        return new PieceImpl(board, pos, new MoveKing(), type);
    }

    private Piece createQueen(final PieceType type, final SquarePosition pos) {
        return new PieceImpl(board, pos, new MoveQueen(), type);
    }

    private Piece createRook(final PieceType type, final SquarePosition pos) {
        return new PieceImpl(board, pos, new MoveRook(), type);
    }

    private Piece createBishop(final PieceType type, final SquarePosition pos) {
        return new PieceImpl(board, pos, new MoveBishop(), type);
    }

    private Piece createKnight(final PieceType type, final SquarePosition pos) {
        return new PieceImpl(board, pos, new MoveKnight(), type);
    }
}
