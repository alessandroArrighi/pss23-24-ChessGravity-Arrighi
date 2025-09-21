package it.unibo.chessgravity.view.utils;

import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.impl.BoardImpl;
import it.unibo.chessgravity.view.api.EntityView;

/**
 * Utility class that models the position of a type {@link EntityView}
 * 
 * This also handle the conversion from and to {@link SquarePosition}
 */
public class Position {

    private static final int MIN_LEN = BoardImpl.MIN_LEN;

    private static int size;
    private static double startX;
    private static double startY;

    private final double posX;
    private final double posY;

    public Position(final double posX, final double posY) {
        this.posX = posX;
        this.posY = posY;
    }
    
    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public SquarePosition toSquarePosition() {
        final double deltaX = posX - startX;
        final double deltaY = posY - startY;

        return new SquarePosition(
            (int) (deltaX / size) + MIN_LEN,
            (int) (deltaY / size) + MIN_LEN
        );
    }

    /**
     * This method setup the static fields for handle the calculation of the position of each
     * entity of the game. This method it must be called before the start of the game.
     * 
     * @param size the size (width and height) of the entitys of the game
     * @param x the start x position of the board
     * @param y the start y position of the board
     */
    public static void setup(final int size, final double x, final double y) {
        Position.size = size;
        startX = x;
        startY = y;
    }

    public static Position toPosition(SquarePosition pos) {
        return new Position(
            (pos.getPosX() - MIN_LEN) * size,
            (pos.getPosY() - MIN_LEN) * size);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Position)) {
            return false;
        }

        Position pos = (Position) obj;

        return Double.compare(pos.getPosX(), this.posX) == 0 &&
                Double.compare(pos.getPosY(), this.posY) == 0;
    }
}
