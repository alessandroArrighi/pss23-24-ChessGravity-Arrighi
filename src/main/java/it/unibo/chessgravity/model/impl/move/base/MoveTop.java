package it.unibo.chessgravity.model.impl.move.base;

import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Class that implement the BaseMoveAbstract template method for the top movement.
 */
public class MoveTop extends BaseMoveAbstract {

    public MoveTop () {
        super();
    }

    public MoveTop(final MoveChecker checker) {
        super(checker);
    }

    @Override
    protected SquarePosition calculatePos(final int posX, final int posY) {
        return new SquarePosition(posX, posY + STEP);
    }
}
