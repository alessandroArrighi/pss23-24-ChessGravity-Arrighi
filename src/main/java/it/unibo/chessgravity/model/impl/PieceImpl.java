package it.unibo.chessgravity.model.impl;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.GravityObserver;
import it.unibo.chessgravity.model.api.Piece;
import it.unibo.chessgravity.model.api.move.Gravity;
import it.unibo.chessgravity.model.api.move.MoveResponse;
import it.unibo.chessgravity.model.api.move.MoveStrategy;
import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.impl.move.gravity.GravityImpl;
import it.unibo.chessgravity.model.utils.PieceSetting;
import it.unibo.chessgravity.model.utils.PieceType;

/**
 * Implementazione dell'interfaccia Piece
 */
public class PieceImpl implements Piece, GravityObserver {
    private SquarePosition pos;
    private final Board board;
    private final MoveStrategy move;
    private final PieceType type;
    private final Gravity gravity;
    
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

    private void setPos(final SquarePosition pos) throws Exception {
        board.move(this.pos, pos);
        this.pos = pos;
    }

    @Override
    public MoveResponse move(SquarePosition dest) throws Exception {
        final MoveResponse res = move.move(pos, dest, board);

        if (res.canMove() || res.isGameOver()) {
            setPos(dest);
            this.gravity();
        }

        return res;
    }

    @Override
    public void gravity() {
        try {
            setPos(gravity.gravity(pos, board).getPos());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
