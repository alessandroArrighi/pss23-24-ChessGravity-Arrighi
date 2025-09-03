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

    // true if a and b has thee same posX value
    public static boolean onSameColumn(SquarePosition a, SquarePosition b) {
        return Integer.compare(a.getPosX(), b.getPosX()) == 0;
    }

    // true if a and b has the same posY value
    public static boolean onSameRow(SquarePosition a, SquarePosition b) {
        return Integer.compare(a.getPosY(), b.getPosY()) == 0;
    }

    // true if a and b has same posX value and posY a >= posY b
    public static boolean onTopColumn(SquarePosition a, SquarePosition b) {
        return onSameColumn(a, b) && gratherOrEqualY(a, b);
    }

    // true if a and b has same posX value and posY a <= posY b
    public static boolean onBottomColumn(SquarePosition a, SquarePosition b) {
        return onSameColumn(a, b) && gratherOrEqualY(b, a);
    }

    // true if a and b has same posY and a posX >= b posX
    public static boolean onLeftRow(SquarePosition a, SquarePosition b) {
        return onSameRow(a, b) && gratherOrEqualX(a, b);
    }

    // true if a and b has same posY and a posX <= b posX
    public static boolean onRightRow(SquarePosition a, SquarePosition b) {
        return onSameRow(a, b) && gratherOrEqualX(b, a);
    }

    // true if a and b are on the same diagonal (not speficated which one)
    public static boolean onSameDiagonal(SquarePosition a, SquarePosition b) {
        final int xDelta = Math.abs(a.getPosX() - b.getPosX());
        final int yDelta = Math.abs(a.getPosY() - b.getPosY());

        return xDelta == yDelta;
    }

    // true if a is on top left b diagonal
    public static boolean onTopLeftDiagonal(SquarePosition a, SquarePosition b) {
        return onSameDiagonal(a, b) && gratherOrEqualX(b, a) && 
                gratherOrEqualY(a, b);
    }

    // true if a is on top right b diagonal
    public static boolean onTopRightDiagonal(SquarePosition a, SquarePosition b) {
        return onSameDiagonal(a, b) && gratherOrEqualX(a, b) && gratherOrEqualY(a, b);
    }

    // true if a is on bottom left diagonal
    public static boolean onBottomLeftDiagonal(SquarePosition a, SquarePosition b) {
        return onSameDiagonal(a, b) && gratherOrEqualX(b, a) &&
                gratherOrEqualY(b, a);
    }

    // true if a is on bottom right diagonal
    public static boolean onBottomRightDiagonal(SquarePosition a, SquarePosition b) {
        return onSameDiagonal(a, b) && gratherOrEqualX(a, b) &&
                gratherOrEqualY(b, a);
    }
}
