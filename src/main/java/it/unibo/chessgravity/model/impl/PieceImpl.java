package it.unibo.chessgravity.model.impl;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.GravityObserver;
import it.unibo.chessgravity.model.api.Piece;
import it.unibo.chessgravity.model.api.exceptions.IllegalSquarePositionException;
import it.unibo.chessgravity.model.api.exceptions.SquareFullException;
import it.unibo.chessgravity.model.api.move.Gravity;
import it.unibo.chessgravity.model.api.move.MoveResponse;
import it.unibo.chessgravity.model.api.move.MoveStrategy;
import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.impl.move.gravity.GravityImpl;
import it.unibo.chessgravity.model.utils.PieceSetting;
import it.unibo.chessgravity.model.utils.PieceType;

/**
 * Class that implements the {@link Piece} and {@link GravityObserver} interfaces.
 * This class models a standard piece that handle the movement with the gravity.
 */
public class PieceImpl implements Piece, GravityObserver {
    private SquarePosition pos;
    private final Board board;
    private final MoveStrategy move;
    private final PieceType type;
    private final Gravity gravity;
    
    /**
     * Class constructor.
     * 
     * @param board The {@link Board} instance where the piece should be placed.
     * @param pos The {@link SquarePosition} where the piece is placed.
     * @param move The {@link MoveStrategy} for handling the movemnts.
     * @param type The {@link PieceType} that specifies the type of the piece.
     */
    public PieceImpl(final Board board, final SquarePosition pos,
                    final MoveStrategy move, final PieceType type) {
        this.board = board;
        this.pos = pos;
        this.move = move;
        this.type = type;
        this.gravity = new GravityImpl();
    }

    @Override
    public PieceSetting info() {
        return new PieceSetting(pos, type);
    }

    @Override
    public SquarePosition getPos() {
        return this.pos;
    }

    private void setPos(final SquarePosition pos) 
        throws IllegalSquarePositionException, SquareFullException {
        board.move(this.pos, pos);
        this.pos = pos;
    }

    @Override
    public MoveResponse move(final SquarePosition dest) {
        final MoveResponse res = move.move(pos, dest, board);

        if (res.canMove() || res.isGameOver()) {
            try {
                setPos(dest);
            } catch (IllegalSquarePositionException e) {
                throw new RuntimeException(e.getMessage());
            } catch (SquareFullException e) {
                throw new RuntimeException(e.getMessage());
            }
            this.gravity();
        }

        return res;
    }

    @Override
    public void gravity() {
        try {
            setPos(gravity.gravity(pos, board).getPos());
        } catch (IllegalSquarePositionException e) {
            throw new RuntimeException(e.getMessage());
        } catch (SquareFullException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
