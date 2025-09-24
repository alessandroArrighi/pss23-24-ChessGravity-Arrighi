package it.unibo.chessgravity.view.impl;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import it.unibo.chessgravity.controller.api.ChessGravityObserver;
import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.utils.PieceSetting;
import it.unibo.chessgravity.view.api.BoardView;
import it.unibo.chessgravity.view.api.ChessGravityView;
import it.unibo.chessgravity.view.api.EntityView;
import it.unibo.chessgravity.view.utils.Position;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.control.Button;
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

    @FXML
    private Button restart;

    @FXML
    private Button quit;

    private EntityView move;
    private Position moveDest;
    private ChessGravityObserver observer;
    private final int entitySize;
    private final int xLen;
    private final int yLen;
    private final Set<PieceSetting> pieceSettings;
    private final Set<SquarePosition> obs;
    private final Set<EntityView> pieces;
    
    public ChessGravityViewImpl(final int entitySize, final int xLen, final int yLen,
                                final Set<PieceSetting> pieces, final Set<SquarePosition> obs) {
        Position.setup(yLen, entitySize, 0, 0);
        this.entitySize = entitySize;
        this.xLen = xLen;
        this.yLen = yLen;
        this.pieceSettings = pieces;
        this.obs = obs;
        this.pieces = new HashSet<>();
    }

    @Override
    public void move(final Set<PieceSetting> gravityPieces) {
        // Get the x position where the moved piece started.
        final int posX = move.getPosition()
                        .toSquarePosition()
                        .getPosX();

        /*
         * Try to get the only piece != posX and move it with gravity.
         * 
         * If no element is found it's because the piece is moving vertically 
         * (x position will be the same) so the gravity will be called in the 
         * loop with the others pieces.
         */
        try {
            final PieceSetting gravityDest = gravityPieces.stream()
                .filter(x -> x.getPos().getPosX() != posX).findFirst().get();
            
            move.move(moveDest, Position.toPosition(gravityDest.getPos()));
            gravityPieces.remove(gravityDest);
        } catch (NoSuchElementException e) {
            move.move(moveDest, moveDest);
        }

        /*
         * Take the pieces and filter only the pieces that in x position equal to
         * the x position of the moved piece.
         * After that sort the list in ascending order
         */
        List<EntityView> start = this.pieces.stream()
        .filter(
            x -> posX == 
                x.getPosition()
                    .toSquarePosition()
                    .getPosX())
        .sorted((a, b) -> {
            return Double.compare(b.getPosition().getPosY(), a.getPosition().getPosY());
        }).toList();

        // Sort the list in ascending order
        List<PieceSetting> dest = gravityPieces.stream()
        .sorted((a, b) -> {
            return Integer.compare(a.getPos().getPosY(), b.getPos().getPosY());
        }).toList();

        // loop to gravity all the pieces
        for(int i = 0; i < dest.size(); ++i) {
            start.get(i).gravity(Position.toPosition(dest.get(i).getPos()));
        }
    }

    @Override
    public void setMove(EntityView piece) {
        this.move = piece;
    }

    @Override
    public void setObserver(final ChessGravityObserver observer) {
        this.observer = observer;
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

            piecesGroup.getChildren().add(
                loader.load()
            );
            
            pieces.add(loader.getController());
        }
    }

    public void createButtons() {
        final int yPos = (entitySize * yLen) + 3;

        restart.setLayoutX(10);
        restart.setLayoutY(yPos);

        quit.setLayoutX(80);
        quit.setLayoutY(yPos);
    }

    @FXML
    public void initialize() throws IOException {
        createBoard();
        createPieces();
        createButtons();
    }


    @FXML
    public void onMousePressed(MouseEvent e) {
        if (move == null) {
            return;
        }

        final Position pos = new Position(e.getX(), e.getY());

        if (!pos.equals(move.getPosition())) {
            moveDest = pos;
            observer.move(move.getPosition(), pos);
        }
    }

    @FXML
    public void restart() {
        observer.restart();
    }

    @FXML
    public void quit() {
        observer.quit();
    }
}
