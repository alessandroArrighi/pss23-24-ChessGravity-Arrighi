package it.unibo.chessgravity.model.impl.move.base;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.move.BaseMove;
import it.unibo.chessgravity.model.api.move.MoveResponse;
import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Abstract class that implement the base movement of a piece.
 * 
 * This class provide a template method, to be implemented by each specific
 * move subclass.
 */

public abstract class BaseMoveAbstract implements BaseMove {
    private final int DEFAULT_STEP = 1;
    protected int STEP = DEFAULT_STEP;

    private final MoveChecker checker;

    public BaseMoveAbstract() {
        this.checker = (a, b) -> checkMove(a, b);
    }

    public BaseMoveAbstract(MoveChecker cheker) {
        this.checker = cheker;
    }

    @Override
    public MoveResponse move(SquarePosition start, Board board) {
        // calculate new position
        final SquarePosition pos = calculatePos(start.getPosX(), start.getPosY());

        return checker.checkMove(pos, board);
    }

    /*
     * takes the step value to be used for a different movement caluclation.
     * After the movement is completed, the stap variable will be restored at its
     * default value.
     */
    @Override
    public MoveResponse move(SquarePosition start, Board board, int step) {
        STEP = step;
        
        final MoveResponse pos = move(start, board);

        STEP = DEFAULT_STEP;

        return pos;
    }

    public static MoveResponse checkMove(SquarePosition pos, Board board) {
        return board.canMove(pos);
    }

    /*
     * The template method that calculate a specific type of movement for a piece.
     */
    abstract protected SquarePosition calculatePos(int posX, int posY);

    public interface MoveChecker {
        MoveResponse checkMove(SquarePosition pos, Board board);
    }
}
