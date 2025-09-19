package it.unibo.chessgravity.view.impl;

import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.view.api.BoardView;
import it.unibo.chessgravity.view.api.ChessGravityView;
import it.unibo.chessgravity.view.api.EntityView;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller that handle the ChessGravity view
 */
public class ChessGravityViewImpl implements ChessGravityView, BoardView {

    @FXML
    private Group squares;
    
    @FXML
    private Group pieces;

    private EntityView move;

    @Override
    public void move(SquarePosition start, SquarePosition dest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }

    @Override
    public void setMove(EntityView piece) {
        this.move = piece;
    }
}
