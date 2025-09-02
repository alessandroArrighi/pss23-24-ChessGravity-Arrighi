package it.unibo.chessgravity.model.impl.move.base;

import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Class that implement the BaseMoveAbstract template method for the bottom movement.
 */
public class MoveBottom extends BaseMoveAbstract {
    @Override
    protected SquarePosition calculatePos(int posX, int posY) {
        return new SquarePosition(posX, posY - STEP);
    }
}
