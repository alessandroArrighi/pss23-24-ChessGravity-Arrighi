package it.unibo.chessgravity.model.api.move;

import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Class that model a response after a movement.
 */
public class MoveResponse {

    private SquarePosition dest;
    private boolean canMove;
    private boolean gameOver;

    /**
     * Class constructor.
     * 
     * @param dest destination position of a movement
     * @param canMove indicate whether the movement can be made
     * @param gameOver indicate if the game is over (i.e., the enemy king is captured).
     */
    public MoveResponse(final SquarePosition dest, final boolean canMove,
            final boolean gameOver) {
        this.dest = dest;
        this.canMove = canMove;
        this.gameOver = gameOver;
    }
}
