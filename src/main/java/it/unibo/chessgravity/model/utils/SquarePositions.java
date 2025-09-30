package it.unibo.chessgravity.model.utils;

import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Utility class that handle all the position comparation between two
 * istances of the SquarePosition class.
 */
public final class SquarePositions {
    private SquarePositions() { }

    // return true if a is >= b
    private static boolean gratherOrEqual(final int a, final int b) {
        return Integer.compare(a, b) >= 0;
    }

    // check if posX a is >= posX b
    private static boolean gratherOrEqualX(final SquarePosition a, final SquarePosition b) {
        return gratherOrEqual(a.getPosX(), b.getPosX());
    }

    // check if posY a is >= posY b
    private static boolean gratherOrEqualY(final SquarePosition a, final SquarePosition b) {
        return gratherOrEqual(a.getPosY(), b.getPosY());
    }

    /**
     * Utility method that checks whether two elements are on the same column.
     * 
     * @param a The position of the first element.
     * @param b The position of the second element.
     * @return {@code true} if {@code a} and {@code b} has the same {@code posX} value
     */
    public static boolean onSameColumn(final SquarePosition a, final SquarePosition b) {
        return Integer.compare(a.getPosX(), b.getPosX()) == 0;
    }

    /**
     * Utility method that checks whether two elements are on the same row.
     * 
     * @param a The position of the first element.
     * @param b The position of the second element.
     * @return {@code true} if {@code a} and {@code b} has the same {@code posY} value
     */
    public static boolean onSameRow(final SquarePosition a, final SquarePosition b) {
        return Integer.compare(a.getPosY(), b.getPosY()) == 0;
    }

    /**
     * Utility method that checks whether {@code a} is on top of {@code b} column.
     * 
     * @param a The position of the first element.
     * @param b The position of the second element.
     * @return {@code true} if {@code a} and {@code b} has the same {@code posX} value
     * and {@code a.posY >= b.posY}
     */
    public static boolean onTopColumn(final SquarePosition a, final SquarePosition b) {
        return onSameColumn(a, b) && gratherOrEqualY(a, b);
    }

    /**
     * Utility method that checks whether {@code a} is on bottom of {@code b} column.
     * 
     * @param a The position of the first element.
     * @param b The position of the second element.
     * @return {@code true} if {@code a} and {@code b} has the same {@code posX} value
     * and {@code a.posY <= b.posY}
     */
    public static boolean onBottomColumn(final SquarePosition a, final SquarePosition b) {
        return onSameColumn(a, b) && gratherOrEqualY(b, a);
    }

    /**
     * Utility method that checks whether {@code a} is on left of {@code b} row.
     * 
     * @param a The position of the first element.
     * @param b The position of the second element.
     * @return {@code true} if {@code a} and {@code b} has the same {@code posY} value
     * and {@code a.posX <= b.posX}
     */
    public static boolean onLeftRow(final SquarePosition a, final SquarePosition b) {
        return onSameRow(a, b) && gratherOrEqualX(b, a);
    }

    /**
     * Utility method that checks whether {@code a} is on right of {@code b} row.
     * 
     * @param a The position of the first element.
     * @param b The position of the second element.
     * @return {@code true} if {@code a} and {@code b} has the same {@code posY} value
     * and {@code a.posX >= b.posX}
     */
    public static boolean onRightRow(final SquarePosition a, final SquarePosition b) {
        return onSameRow(a, b) && gratherOrEqualX(a, b);
    }

    /**
     * Utility method that checks whether {@code a} and {@code b} 
     * are on the same diagonal.
     * 
     * @param a The position of the first element.
     * @param b The position of the second element.
     * @return {@code true} if {@code a} and {@code b} 
     * are on the same diagonal (not speficated which one)
     */
    public static boolean onSameDiagonal(final SquarePosition a, final SquarePosition b) {
        final int xDelta = Math.abs(a.getPosX() - b.getPosX());
        final int yDelta = Math.abs(a.getPosY() - b.getPosY());

        return xDelta == yDelta;
    }

    /**
     * Utility method that checks whether {@code a} is on top left of {@code b} diagonal.
     * 
     * @param a The position of the first element.
     * @param b The position of the second element.
     * @return {@code true} if {@code a} is on top left {@code b} diagonal
     */
    public static boolean onTopLeftDiagonal(final SquarePosition a, final SquarePosition b) {
        return onSameDiagonal(a, b) && gratherOrEqualX(b, a) && 
                gratherOrEqualY(a, b);
    }

    /**
     * Utility method that checks whether {@code a} is on top right of {@code b} diagonal.
     * 
     * @param a The position of the first element.
     * @param b The position of the second element.
     * @return {@code true} if {@code a} is on top right {@code b} diagonal
     */
    public static boolean onTopRightDiagonal(final SquarePosition a, final SquarePosition b) {
        return onSameDiagonal(a, b) && gratherOrEqualX(a, b) && gratherOrEqualY(a, b);
    }

    /**
     * Utility method that checks whether {@code a} is on bottom left of {@code b} diagonal.
     * 
     * @param a The position of the first element.
     * @param b The position of the second element.
     * @return {@code true} if {@code a} is on bottom left {@code b} diagonal
     */
    public static boolean onBottomLeftDiagonal(final SquarePosition a, final SquarePosition b) {
        return onSameDiagonal(a, b) && gratherOrEqualX(b, a) &&
                gratherOrEqualY(b, a);
    }

    /**
     * UUtility method that checks whether {@code a} is on bottom right of {@code b} diagonal.
     * 
     * @param a The position of the first element.
     * @param b The position of the second element.
     * @return {@code true} if {@code a} is on bottom right {@code b} diagonal
     */
    public static boolean onBottomRightDiagonal(final SquarePosition a, final SquarePosition b) {
        return onSameDiagonal(a, b) && gratherOrEqualX(a, b) &&
                gratherOrEqualY(b, a);
    }
}
