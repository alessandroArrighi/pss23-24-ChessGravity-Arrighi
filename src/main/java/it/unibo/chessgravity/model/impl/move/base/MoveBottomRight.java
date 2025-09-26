package it.unibo.chessgravity.model.impl.move.base;

import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Class that implement the BaseMoveAbstract template method for the bottom right movement.
 */
public class MoveBottomRight extends BaseMoveAbstract {

    public MoveBottomRight() {
        super();
    }

    public MoveBottomRight(final MoveChecker cheker) {
        super(cheker);
    }

    @Override
    protected SquarePosition calculatePos(final int posX, final int posY) {
        return new SquarePosition(posX + STEP, posY - STEP);
    }    
}
