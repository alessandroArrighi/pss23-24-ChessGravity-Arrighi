package it.unibo.chessgravity.controller.impl;

import it.unibo.chessgravity.controller.api.ChessGravityObserver;
import it.unibo.chessgravity.model.api.Map;
import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.view.api.ChessGravityView;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Controller class that handle the interaction between the view and the model
 */
public class ChessGravityObserverImpl extends Application implements ChessGravityObserver {

    private Map model;
    private ChessGravityView view;

    @Override
    public void init() throws Exception {
        // TODO Auto-generated method stub
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'start'");
    }

    @Override
    public void move(SquarePosition start, SquarePosition dest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }
}
