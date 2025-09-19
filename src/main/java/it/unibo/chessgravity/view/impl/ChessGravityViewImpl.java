package it.unibo.chessgravity.view.impl;

import java.util.Collection;
import java.util.Set;

import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.utils.PieceSetting;
import it.unibo.chessgravity.view.api.BoardView;
import it.unibo.chessgravity.view.api.ChessGravityView;
import it.unibo.chessgravity.view.api.EntityView;
import javafx.fxml.FXML;
import javafx.scene.Group;

/**
 * FXML Controller that handle the ChessGravity view
 */
public class ChessGravityViewImpl implements ChessGravityView, BoardView {

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
}
