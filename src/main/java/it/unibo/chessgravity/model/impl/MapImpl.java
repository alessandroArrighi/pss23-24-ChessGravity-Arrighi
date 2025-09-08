package it.unibo.chessgravity.model.impl;

import java.util.Set;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.Map;
import it.unibo.chessgravity.model.api.PieceFactory;
import it.unibo.chessgravity.model.api.square.SquarePiece;
import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.utils.PieceSetting;

/**
 * Class that models a map of the game.
 */
public class MapImpl implements Map {

    private final Board board;

    public MapImpl(final Set<PieceSetting> pieces, final Set<SquarePosition> obstacles,
                    final int xLen, final int yLen) {
        board = new BoardImpl(xLen, yLen, obstacles);
        final PieceFactory factory = new PieceStandardFactory(board);

        for (PieceSetting piece : pieces) {
            try {
                final SquarePiece square = (SquarePiece) board.getSquare(piece.getPos());
            
                square.setPiece(factory.createPiece(piece.getType()));
            } catch (Exception e) {}
        }
    }

    @Override
    public boolean move(SquarePosition start, SquarePosition dest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }
}
