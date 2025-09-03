package it.unibo.chessgravity.model.api.square;

import java.util.Objects;

/**
 * Classe che incapsula le informazioni di una posizione nella scacchiera.
 * Ogni istanza è costituita da una posizione sull'asse delle <<x>> e una
 * sull'asse delle <<y>>.
 */

public class SquarePosition {
    private final int posX;
    private final int posY;

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
    public boolean equals(Object obj) {
        if (obj instanceof SquarePosition) {
            SquarePosition pos = (SquarePosition) obj;

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
