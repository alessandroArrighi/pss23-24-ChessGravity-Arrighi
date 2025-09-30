package it.unibo.chessgravity.view.impl;

import it.unibo.chessgravity.view.utils.Position;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 * View class that models the enemy king.
 */
public class EnemyView {
    
    @FXML
    private Rectangle piece;

    private final Position pos;
    private final int size;

    public EnemyView(final Position pos, final int size) {
        this.pos = pos;
        this.size = size;
    }

    @FXML
    public void initialize() {
        piece.setWidth(size);
        piece.setHeight(size);
        piece.setX(pos.getPosX());
        piece.setY(pos.getPosY());

        piece.setFill(new ImagePattern(new Image("/image/enemy.png")));
    }
}
