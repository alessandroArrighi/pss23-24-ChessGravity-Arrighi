package it.unibo.chessgravity.view.impl;

import it.unibo.chessgravity.model.utils.PieceSetting;
import it.unibo.chessgravity.model.utils.PieceType;
import it.unibo.chessgravity.view.api.BoardView;
import it.unibo.chessgravity.view.api.EntityView;
import it.unibo.chessgravity.view.utils.Position;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * Entity class that implements the {@link EntityView} interface.
 * 
 * This class models a piece of the game.
 */
public class PieceViewImpl implements EntityView {

    private Position pos;
    private PieceType type;
    private int size;
    private final BoardView board;

    @FXML
    private Rectangle piece;

    public PieceViewImpl(PieceSetting setting, int size, BoardView board) {
        this.pos = Position.toPosition(setting.getPos());
        this.type = setting.getType();
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

        Image image = null;
        
        switch (type) {
            case KING:
                image = new Image("/image/king.png");
                break;
            case QUEEN:
                image = new Image("/image/queen.png");
                break;
            case ROOK:
                image = new Image("/image/rook.png");
                break;
            case BISHOP:
                image = new Image("/image/bishop.png");
                break;
            case KNIGHT:
                image = new Image("/image/knight.png");
                break;
            default:
                piece.setFill(Color.BLUE);
                break;
        }

        if (image != null) {
            final ImagePattern image_pattern = new ImagePattern(image);
            piece.setFill(image_pattern);
        }
    }

    @FXML
    public void onMousePressed() {
        board.setMove(this);
    }
}
