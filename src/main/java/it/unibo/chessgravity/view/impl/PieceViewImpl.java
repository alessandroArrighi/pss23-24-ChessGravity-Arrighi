package it.unibo.chessgravity.view.impl;

import it.unibo.chessgravity.view.api.BoardView;
import it.unibo.chessgravity.view.api.EntityView;
import it.unibo.chessgravity.view.utils.Position;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

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
    public void gravity(Position newPos) {        
        final Timeline timeline = new Timeline();
        final KeyValue kvX = new KeyValue(piece.xProperty(), newPos.getPosX());
        final KeyValue kvY = new KeyValue(piece.yProperty(), newPos.getPosY());
        final KeyFrame kf = new KeyFrame(Duration.millis(400), kvX, kvY);
        timeline.getKeyFrames().add(kf);

        final PauseTransition dealy = new PauseTransition(Duration.millis(200));
        dealy.setOnFinished(x -> timeline.play());
        
        dealy.play();
        this.pos = newPos;
    }

    @Override
    public void move(Position pos, Position gravityPosition) {
        this.pos = pos;
        this.piece.setX(pos.getPosX());
        this.piece.setY(pos.getPosY());
        this.gravity(gravityPosition);
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
