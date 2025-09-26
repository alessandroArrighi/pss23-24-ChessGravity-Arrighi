package it.unibo.chessgravity.controller.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.unibo.chessgravity.controller.api.ChessGravityObserver;
import it.unibo.chessgravity.model.api.Map;
import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.impl.MapImpl;
import it.unibo.chessgravity.model.utils.PieceSetting;
import it.unibo.chessgravity.model.utils.PieceType;
import it.unibo.chessgravity.view.api.ChessGravityView;
import it.unibo.chessgravity.view.impl.ChessGravityViewImpl;
import it.unibo.chessgravity.view.utils.Position;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Controller class that handle the interaction between the view and the model
 */
public class ChessGravityObserverImpl extends Application implements ChessGravityObserver {

    private static final String title = "Chess Gravity";
    private static final boolean resizableWindow = false;

    private Map model;
    private ChessGravityView view;
    private Stage stage;

    @Override
    public void start(final Stage primaryStage) throws IOException {
        final Set<PieceSetting> pieces = new HashSet<>();
        final Set<SquarePosition> obs = new HashSet<>();
        final int len = 10;
        final int size = 50;
        final SquarePosition enemy = new SquarePosition(2, 5);
        stage = primaryStage;

        pieces.addAll(Arrays.asList(
                new PieceSetting(new SquarePosition(1, 1), PieceType.ROOK),
                new PieceSetting(new SquarePosition(2, 2), PieceType.KNIGHT),
                new PieceSetting(new SquarePosition(3, 3), PieceType.BISHOP)
            ));

        obs.addAll(Arrays.asList(
            new SquarePosition(2, 4),
            new SquarePosition(3, 4),
            new SquarePosition(4, 4),
            new SquarePosition(7, 4),
            new SquarePosition(8, 4),
            new SquarePosition(9, 4)
        ));

        model = new MapImpl(pieces, obs, len, len, enemy);

        final FXMLLoader loader = new FXMLLoader(
            ClassLoader.getSystemResource("layouts/MainGui.fxml"));
        
        loader.setControllerFactory((cls) -> {
            if (cls == ChessGravityViewImpl.class) {
                return new ChessGravityViewImpl(size, len, len, pieces, obs, enemy);
            }

            throw new RuntimeException("Cannot find " + ChessGravityView.class);
        });

        primaryStage.setScene(new Scene(loader.load()));
        primaryStage.setTitle(title);
        primaryStage.setResizable(resizableWindow);
        primaryStage.show();

        view = loader.getController();
        view.setObserver(this);

        view.start(model.start());

        if (model.isGameOver()) {
            System.out.println("Game is over");
            view.gameOver();
        }
    }

    @Override
    public void move(Position start, Position dest) {
        final List<PieceSetting> res = model.move(
            start.toSquarePosition(), dest.toSquarePosition()
        );
        if (res != null) {
            view.move(res);
        }

        if (model.isGameOver()) {
            // send to view that the game is over
            System.out.println("Game is over");
            view.gameOver();
        }
    }

    @Override
    public void restart() {
        System.out.println("Restarting...");
        try {
            this.start(this.stage);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public void quit() {
        System.out.println("Exiting...");
        Platform.exit();
    }
}
