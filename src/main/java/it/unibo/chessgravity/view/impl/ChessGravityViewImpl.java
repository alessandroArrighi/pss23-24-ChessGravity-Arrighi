package it.unibo.chessgravity.view.impl;

import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.view.api.ChessGravityView;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller that handle the ChessGravity view
 */
public class ChessGravityViewImpl implements ChessGravityView {

    @FXML
    private Group squares;
    
    @FXML
    private Group pieces;

    private Rectangle move;

    @Override
    public void move(SquarePosition start, SquarePosition dest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }
}
