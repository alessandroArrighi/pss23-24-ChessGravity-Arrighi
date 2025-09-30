package it.unibo.chessgravity.model.impl.move.base;

import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Class that implement the BaseMoveAbstract template method for the top left movement.
 */
public class MoveTopLeft extends BaseMoveAbstract {

    public MoveTopLeft () {
        super();
    }
    
    public MoveTopLeft(final MoveChecker cheker) {
        super(cheker);
    }

    @Override
    protected SquarePosition calculatePos(final int posX, final int posY) {
        return new SquarePosition(posX - STEP, posY + STEP);
    }
}
