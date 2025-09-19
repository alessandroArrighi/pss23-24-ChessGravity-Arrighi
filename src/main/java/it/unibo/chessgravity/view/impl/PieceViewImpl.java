package it.unibo.chessgravity.view.impl;

import it.unibo.chessgravity.view.api.EntityView;
import it.unibo.chessgravity.view.utils.Position;
import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;

/**
 * Entity class that implements the {@link EntityView} interface.
 * 
 * This class models a piece of the game.
 */
public class PieceViewImpl implements EntityView {

    private Position pos;
    private int size;

    @FXML
    private Rectangle piece;

    public PieceViewImpl(Position pos, int size) {
        this.pos = pos;
        this.size = size;
    }

    @Override
    public Position getPosition() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPosition'");
    }

    @Override
    public void setPosition(Position newPos) {
        piece.setX(newPos.getPosX());
        piece.setY(newPos.getPosY());
    }

    @FXML
    public void initialize() {
        piece.setWidth(size);
        piece.setHeight(size);
        piece.setX(pos.getPosX());
        piece.setY(pos.getPosY());
    }
}
