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

    /**
     * Default class constructor
     */
    public BaseMoveAbstract() {
        this.checker = (a, b) -> checkMove(a, b);
    }

    /**
     * Class constructor for init an instance with different implementation of the chekcer.
     * 
     * @param cheker The {@link MoveChecker} Object that models the check implementation
     * used in the movement algorithm.
     */
    public BaseMoveAbstract(final MoveChecker cheker) {
        this.checker = cheker;
    }

    // template method
    @Override
    public MoveResponse move(final SquarePosition start, final Board board) {
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
    public MoveResponse move(final SquarePosition start, final Board board, final int step) {
        STEP = step;
        
        final MoveResponse pos = move(start, board);

        STEP = DEFAULT_STEP;

        return pos;
    }

    public static MoveResponse checkMove(final SquarePosition pos, final Board board) {
        return board.canMove(pos);
    }

    /**
     * The implementation method used for the template method patter 
     * of the {@link BaseMoveAbstract#move(SquarePosition, Board)}.
     * This method is implemented for each specific type of piece movement.
     * 
     * @param posX The position of the 'x' axis.
     * @param posY The position of the 'y' axis.
     * @return The calculated position.
     */
    abstract protected SquarePosition calculatePos(int posX, int posY);

    /**
     * Inner interface that maps the movement cheker used with a lambda function.
     */
    public interface MoveChecker {
        /**
         * Method that check if is possible to move at the five position.
         * 
         * @param pos The position that has to be checked.
         * @param board The board used to handle the checking execution.
         * @return {@link MoveResponse} object with all calculated results.
         */
        MoveResponse checkMove(SquarePosition pos, Board board);
    }
}
