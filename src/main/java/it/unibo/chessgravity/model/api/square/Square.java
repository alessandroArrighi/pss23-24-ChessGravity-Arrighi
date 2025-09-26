package it.unibo.chessgravity.model.api.square;

/**
 * Interface that maps a genric sqaure.
 */
public interface Square {
    boolean isFree();

    SquarePosition getPos();
}
