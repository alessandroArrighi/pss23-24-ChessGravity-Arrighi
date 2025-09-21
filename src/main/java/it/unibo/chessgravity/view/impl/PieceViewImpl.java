package it.unibo.chessgravity.view.impl;

import it.unibo.chessgravity.view.api.BoardView;
import it.unibo.chessgravity.view.api.EntityView;
import it.unibo.chessgravity.view.utils.Position;
import javafx.fxml.FXML;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 * Entity class that implements the {@link EntityView} interface.
 * 
 * This class models a piece of the game.
 */
public class PieceViewImpl implements EntityView {

    private Position pos;
    private int size;
    private final BoardView board;

    @FXML
    private Rectangle piece;

    public PieceViewImpl(Position pos, int size, BoardView board) {
        this.pos = pos;
        this.size = size;
        this.board = board;
    }

    @Override
    public Position getPosition() {
        return pos;
    }

    @Override
    public void setPosition(Position newPos) {
        this.pos = newPos;
        piece.setX(newPos.getPosX());
        piece.setY(newPos.getPosY());
    }

    @FXML
    public void initialize() {
        piece.setWidth(size);
        piece.setHeight(size);
        piece.setX(pos.getPosX());
        piece.setY(pos.getPosY());

        piece.setFill(Paint.valueOf("#dd9b00"));
    }

    @FXML
    public void onMousePressed() {
        board.setMove(this);
    }
}
