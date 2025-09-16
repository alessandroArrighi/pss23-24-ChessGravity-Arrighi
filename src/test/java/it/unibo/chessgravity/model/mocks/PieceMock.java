package it.unibo.chessgravity.model.mocks;

import it.unibo.chessgravity.model.api.Piece;
import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.utils.PieceSetting;

/**
 * Mock class for mock {@link Piece} reference
 */
public class PieceMock implements Piece {

    private final SquarePosition pos;

    public PieceMock(SquarePosition pos) {
        this.pos = pos;
    }

    @Override
    public PieceSetting info() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
            "Unimplemented method 'info'"
        );
    }

    @Override
    public SquarePosition getPos() {
        return this.pos;
    }

    @Override
    public boolean move(SquarePosition dest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
            "Unimplemented method 'move'"
        );
    }        
}