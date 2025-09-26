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
    private int xOffset;
    private int yOffset;
    private Position viewPos;
    private SquarePosition modelPos;

    @BeforeEach
    public void setup() {
        yLen = 13;
        size = 50;
        xStart = 0;
        yStart = 0;
        Position.setup(yLen, size, xStart, yStart);

        xOffset = 4;
        yOffset = 3;
        viewPos = new Position((xOffset * size) + xStart, (yOffset * size) + yStart);
        modelPos = new SquarePosition(xOffset + 1, yLen - yOffset);
    }

    /**
     * Checks if the convertion into {@link SquarePosition} works correctly
     */
    @Test
    public void testToSquarePosition() {
        assertEquals(modelPos, viewPos.toSquarePosition());
    }

    /**
     * Checks if the convertion works correclty with starting position != 0
     */
    @Test
    public void testViewStart() {
        this.xStart = 20;
        this.yStart = 30;
        Position.setup(yLen, size, xStart, yLen);
        viewPos = new Position((xOffset * size) + xStart, (yOffset * size) + yStart);

        assertEquals(modelPos, viewPos.toSquarePosition());
    }

    /**
     * Checks if the covertion works correctly with a double value position
     */
    @Test
    public void testDoubleValues() {
        final double add = 13.29;
        viewPos = new Position(viewPos.getPosX() + add, viewPos.getPosY() + add);

        assertEquals(modelPos, viewPos.toSquarePosition());
    }
}