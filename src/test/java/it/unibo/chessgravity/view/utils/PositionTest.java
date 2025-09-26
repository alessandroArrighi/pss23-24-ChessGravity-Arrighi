package it.unibo.chessgravity.view.utils;

import org.junit.jupiter.api.BeforeEach;

/**
 * Test class for the {@link Position} class.
 */
public class PositionTest {

    private int xLen;
    private int yLen;
    private int xStart;
    private int yStart;

    @BeforeEach
    public void setup() {
        xLen = 10;
        yLen = 13;
        Position.setup(yLen, xLen, xStart, yStart);
    }
}