package it.unibo.chessgravity.model.impl.move.base;

import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Class that implement the BaseMoveAbstract template method for the left movement.
 */

public class MoveLeft extends BaseMoveAbstract {

    public MoveLeft () {
        super();
    }

    public MoveLeft(final MoveChecker cheker) {
        super(cheker);
    }

    @Override
    protected SquarePosition calculatePos(final int posX, final int posY) {
        return new SquarePosition(posX - STEP, posY);
    }
}
