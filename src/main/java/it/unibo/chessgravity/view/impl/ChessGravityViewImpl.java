package it.unibo.chessgravity.view.impl;

import java.util.Set;

import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.utils.PieceSetting;
import it.unibo.chessgravity.view.api.BoardView;
import it.unibo.chessgravity.view.api.ChessGravityView;
import it.unibo.chessgravity.view.api.EntityView;
import it.unibo.chessgravity.view.utils.Position;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller that handle the ChessGravity view
 */
public class ChessGravityViewImpl implements ChessGravityView, BoardView {

    private static final String obsColor = "#00d000";
    private static final String dark = "#000000";
    private static final String light = "#aaaaaa";

    @FXML
    private Group squares;
    
    @FXML
    private Group pieces;

    private EntityView move;
    private final int entitySize;
    private final int xLen;
    private final int yLen;
    private final Set<PieceSetting> pieceSettings;
    private final Set<SquarePosition> obs;

    public ChessGravityViewImpl(final int entitySize, final int xLen, final int yLen,
                                final Set<PieceSetting> pieces, final Set<SquarePosition> obs) {
        Position.setup(entitySize, xLen, yLen);
        this.entitySize = entitySize;
        this.xLen = xLen;
        this.yLen = yLen;
        pieceSettings = pieces;
        this.obs = obs;
    }

    @Override
    public void move(SquarePosition start, SquarePosition dest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }

    @Override
    public void setMove(EntityView piece) {
        this.move = piece;
    }

    private void createBoard() {
        for (int col = 0; col < yLen; ++col) {
            final String odd = col % 2 != 0 ? light : dark;
            final String even = col % 2 == 0 ? light : dark;

            for (int row = 0; row < xLen; ++row) {
                Position pos = new Position(row * entitySize, col * entitySize);
                Rectangle r = new Rectangle(entitySize, entitySize);
                r.setX(pos.getPosX());
                r.setY(pos.getPosY());

                String color = row % 2 == 0 ? even : odd;

                if (obs.contains(pos.toSquarePosition())) {
                    color = obsColor;
                }

                r.setFill(Paint.valueOf(color));
                squares.getChildren().add(r);
            }
        }
    }

    @FXML
    public void initialize() {
        createBoard();
    }
}
