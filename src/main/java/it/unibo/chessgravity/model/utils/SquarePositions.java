package it.unibo.chessgravity.model.utils;

import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Utility class that handle all the position comparation between two
 * istances of the SquarePosition class.
 */
public final class SquarePositions {
    private SquarePositions() { }

    // return true if a is >= b
    private static boolean gratherOrEqual(int a, int b) {
        return Integer.compare(a, b) >= 0;
    }

    // check if posX a is >= posX b
    private static boolean gratherOrEqualX(SquarePosition a, SquarePosition b) {
        return gratherOrEqual(a.getPosX(), b.getPosX());
    }

    // check if posY a is >= posY b
    private static boolean gratherOrEqualY(SquarePosition a, SquarePosition b) {
        return gratherOrEqual(a.getPosY(), b.getPosY());
    }
}
