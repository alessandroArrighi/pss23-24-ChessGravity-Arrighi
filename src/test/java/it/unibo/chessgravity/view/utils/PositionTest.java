package it.unibo.chessgravity.view.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Test class for the {@link Position} class.
 */
public class PositionTest {

    private int yLen;
    private int size;
    private int xStart;
    private int yStart;

    @BeforeEach
    public void setup() {
        yLen = 13;
        size = 50;
        xStart = 0;
        yStart = 0;
        Position.setup(yLen, size, xStart, yStart);
    }

    /**
     * Checks if the convertion into {@link SquarePosition} works correctly
     */
    @Test
    public void testToSquarePosition() {
        final int xOffset = 3;
        final int yOffset = 4;
        final Position pos = new Position((xOffset * size) + xStart, (yOffset * size) + yStart);
        final SquarePosition res = new SquarePosition(xOffset + 1, yLen - yOffset);

        assertEquals(res, pos.toSquarePosition());
    }
}