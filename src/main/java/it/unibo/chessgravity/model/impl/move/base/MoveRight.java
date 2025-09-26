package it.unibo.chessgravity.model.impl.move.base;

import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Class that implement the BaseMoveAbstract template method for the right movement.
 */

public class MoveRight extends BaseMoveAbstract {

    public MoveRight () {
        super();
    }

    public MoveRight(final MoveChecker cheker) {
        super(cheker);
    }

    @Override
    protected SquarePosition calculatePos(final int posX, final int posY) {
        return new SquarePosition(posX + STEP, posY);
    }
    
}
