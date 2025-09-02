package it.unibo.chessgravity.model.impl.move.base;

import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Class that implement the BaseMoveAbstract template method for the left movement.
 */

public class MoveLeft extends BaseMoveAbstract {

    @Override
    protected SquarePosition calculatePos(int posX, int posY) {
        return new SquarePosition(posX - STEP, posY);
    }
}
