package it.unibo.chessgravity.model.impl.move.gravity;

import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.move.Gravity;
import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.impl.BoardImpl;

/**
 * Test class for the {@link GravityImpl} class
 */
public class GravityImplTest {
    
    private int LEN = 10;
    private int defaultPosX = 5;
    private Gravity gravity;
    private Board board;
    private SquarePosition start;
    private SquarePosition dest;

    @BeforeEach
    void setup() {
        gravity = new GravityImpl();
        board = new BoardImpl(LEN, LEN, new HashSet<>());
    }

}
