package it.unibo.chessgravity.view.impl;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

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
    private Group menu;

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
    private final Position enemy;
    private final Set<PieceSetting> pieceSettings;
    private final Set<SquarePosition> obs;
    private final Set<EntityView> pieces;
    private final Comparator<SquarePosition> sort;
    
    public ChessGravityViewImpl(final int entitySize, final int xLen, final int yLen,
                                final Set<PieceSetting> pieces, final Set<SquarePosition> obs,
                                final SquarePosition enemy) {
        Position.setup(yLen, entitySize, 0, 0);
        this.entitySize = entitySize;
        this.xLen = xLen;
        this.yLen = yLen;
        this.enemy = Position.toPosition(enemy);
        this.pieceSettings = pieces;
        this.obs = obs;
        this.pieces = new HashSet<>();
        this.sort = (a, b) -> {
            if (a.getPosX() != b.getPosX()) {
                return Integer.compare(a.getPosX(), b.getPosX());
            }

            return Integer.compare(a.getPosY(), b.getPosY());
        };
    }

    @Override
    public void start(final List<PieceSetting> pieces) {
        final List<EntityView> piecesView = this.pieces.stream()
            .sorted((a, b) -> { 
                return sort.compare(a.getPosition().toSquarePosition(), 
                                    b.getPosition().toSquarePosition());
            }).toList();
        

        int i = 0;
        for (EntityView x :  piecesView) {
            x.move(x.getPosition(), Position.toPosition(pieces.get(i).getPos()));
            ++i;
        }
    }

    @Override
    public void move(final List<PieceSetting> gravityPieces) {
        // Get the x position where the moved piece started.
        final SquarePosition pos = move.getPosition().toSquarePosition();

        /*
         * Try to get the only piece != posX and move it with gravity.
         * 
         * If no element is found it's because the piece is moving vertically 
         * (x position will be the same) so the gravity will be called in the 
         * loop with the others pieces.
         */
        final SquarePosition gravityDest = gravityPieces.get(gravityPieces.size() - 1).getPos();
        if (gravityDest.getPosX() != pos.getPosX()) {
            move.move(moveDest, Position.toPosition(gravityDest));
            gravityPieces.remove(gravityPieces.size() - 1);
        } else {
            // simple move with no gravity
            move.move(moveDest, moveDest);
        }

        /*
         * Filter only the pieces that have the same x position 
         * as the x position of the moved piece.
         * After that, sort the list in ascending order
         */
        List<EntityView> start = this.pieces.stream()
        .filter(x -> {
            final SquarePosition currentPos = x.getPosition().toSquarePosition();
            return pos.getPosX() == currentPos.getPosX() && 
                    currentPos.getPosY() > pos.getPosY();
        })
        .sorted((a, b) -> {
            return Double.compare(b.getPosition().getPosY(), a.getPosition().getPosY());
        }).toList();

        // loop to gravity all the pieces
        for(int i = 0; i < gravityPieces.size(); ++i) {
            start.get(i).gravity(Position.toPosition(gravityPieces.get(i).getPos()));
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

    @Override
    public void gameOver() {
        final Rectangle background = new Rectangle(
            squares.getBoundsInLocal().getWidth(),
            squares.getBoundsInLocal().getHeight(),
            Paint.valueOf("#000000aa")
        );
        final int x = xLen / 2 * entitySize;
        final int y = yLen / 2 * entitySize;
        final Label title = new Label("WELL DONE!");
        final Button quit = new Button("Quit");
        final Button restart = new Button("Restart");

        title.setFont(new Font(50));
        title.setTextFill(Color.WHITE);
        quit.setOnMouseClicked(e -> quit());
        restart.setOnMouseClicked(e -> restart());

        menu.getChildren().addAll(background, title, quit, restart);
        
        title.setLayoutX(x - 130);
        title.setLayoutY(y - 100);
        quit.setLayoutX(x - 50);
        quit.setLayoutY(y);
        restart.setLayoutX(x + 10);
        restart.setLayoutY(y);
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
            final FXMLLoader loader = new FXMLLoader(
                ClassLoader.getSystemResource("layouts/PieceGui.fxml")
            );

            loader.setControllerFactory(x -> {
                if (x == PieceViewImpl.class) {
                    return new PieceViewImpl(piece, entitySize, this);
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

    private void createEnemy() throws IOException {
        final FXMLLoader loader = new FXMLLoader(
            ClassLoader.getSystemResource("layouts/EnemyGui.fxml")
        );

        loader.setControllerFactory(x -> {
            if (x == EnemyView.class) {
                return new EnemyView(enemy, entitySize);
            }

            throw new RuntimeException("Cannot create " + EnemyView.class + ". "
                                        + x.getClass() + " cannot be converted to type "
                                        + EnemyView.class);
        });

        piecesGroup.getChildren().add(
            loader.load()
        );
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
        createEnemy();
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
