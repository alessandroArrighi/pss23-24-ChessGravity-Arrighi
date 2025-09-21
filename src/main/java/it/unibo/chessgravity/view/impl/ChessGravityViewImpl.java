package it.unibo.chessgravity.view.impl;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.utils.PieceSetting;
import it.unibo.chessgravity.view.api.BoardView;
import it.unibo.chessgravity.view.api.ChessGravityView;
import it.unibo.chessgravity.view.api.EntityView;
import it.unibo.chessgravity.view.utils.Position;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
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
    private Group piecesGroup;

    private EntityView move;
    private final int entitySize;
    private final int xLen;
    private final int yLen;
    private final Set<PieceSetting> pieceSettings;
    private final Set<SquarePosition> obs;
    private final Set<EntityView> pieces;

    public ChessGravityViewImpl(final int entitySize, final int xLen, final int yLen,
                                final Set<PieceSetting> pieces, final Set<SquarePosition> obs) {
        Position.setup(entitySize, xLen, yLen);
        this.entitySize = entitySize;
        this.xLen = xLen;
        this.yLen = yLen;
        this.pieceSettings = pieces;
        this.obs = obs;
        this.pieces = new HashSet<>();
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

    private void createPieces() throws IOException {
        for (PieceSetting piece : pieceSettings) {
            FXMLLoader loader = new FXMLLoader(
                ClassLoader.getSystemResource("layouts/PieceGui.fxml")
            );

            loader.setControllerFactory(x -> {
                if (x == PieceViewImpl.class) {
                    return new PieceViewImpl(Position.toPosition(piece.getPos()), entitySize, this);
                }

                throw new RuntimeException("Cannot create " + PieceViewImpl.class + ". "
                                            + x.getClass() + " cannot be converted to type "
                                            + PieceViewImpl.class);
            });

            pieces.add(loader.getController());
            
            piecesGroup.getChildren().add(
                loader.load()
            );
        }
    }

    @FXML
    public void initialize() throws IOException {
        createBoard();
        createPieces();
    }


    @FXML
    public void onMousePressed(MouseEvent e) {
        if (move == null) {
            return;
        }

        final Position pos = new Position(
                                ((int) e.getX() / entitySize) * entitySize,
                                ((int) e.getY() / entitySize) * entitySize
                            );

                            
        if (!pos.equals(move.getPosition())) {
            move.setPosition(pos);
        }
    }
}
