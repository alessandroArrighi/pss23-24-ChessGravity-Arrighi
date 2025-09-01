package it.unibo.chessgravity.model.api;

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
}
