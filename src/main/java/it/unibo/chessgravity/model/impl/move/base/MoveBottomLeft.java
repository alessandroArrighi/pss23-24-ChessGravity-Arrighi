package it.unibo.chessgravity.model.impl.move.base;

import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Class that implement the BaseMoveAbstract template method for the bottom left movement.
 */
public class MoveBottomLeft extends BaseMoveAbstract {
    
    public MoveBottomLeft() {
        super();
    }

    public MoveBottomLeft(MoveChecker cheker) {
        super(cheker);
    }

    @Override
    protected SquarePosition calculatePos(int posX, int posY) {
        return new SquarePosition(posX - STEP, posY - STEP);
    }
}
