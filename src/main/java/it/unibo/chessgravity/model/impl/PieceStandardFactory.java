package it.unibo.chessgravity.model.impl;

import it.unibo.chessgravity.model.api.Piece;
import it.unibo.chessgravity.model.api.PieceFactory;
import it.unibo.chessgravity.model.utils.PieceType;

/**
 * Implementazione standard dell'interfaccia PieceFactory.
 * Questa classe si occupa di creare tutti i pezzi standard del gioco.
 */

public class PieceStandardFactory implements PieceFactory {
    @Override
    public Piece createPiece(final PieceType type) {
        final Piece res;

        switch (type) {
            case KING:
                break;
            
            case QUEEN:
                break;

            case ROOK:
                break;
            
            case BISHOP:
                break;
            
            case KNIGHT:
                break;
        
            default:
                break;
        }

        throw new UnsupportedOperationException("Unimplemented method 'createPiece'");
    }
}
