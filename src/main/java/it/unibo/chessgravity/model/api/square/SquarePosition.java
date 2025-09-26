package it.unibo.chessgravity.model.api.square;

import java.util.Objects;

/**
 * Class that encapsulates the information of a position on the chessboard. 
 * Each instance consists of a position on the 'x' axis and one on the 'y' axis.
 */
public class SquarePosition {
    private final int posX;
    private final int posY;

    /**
     * Class constructor.
     * 
     * @param posX The position on the 'x' axis.
     * @param posY The position on the 'y' axis.
     */
    public SquarePosition(final int posX, final int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public int getPosX() {
        return this.posX;
    }

    public int getPosY() {
        return this.posY;
    }

    @Override
    public String toString() {
        return "Position: (" + Integer.toString(posX) + 
                ", " + Integer.toString(posY) + ")";
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof SquarePosition) {
            final SquarePosition pos = (SquarePosition) obj;

            return Objects.equals(posX, pos.getPosX()) && 
                    Objects.equals(posY, pos.getPosY());
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(posX, posY);
    }
}
