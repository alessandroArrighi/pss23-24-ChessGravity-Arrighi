package it.unibo.chessgravity.model.impl.move;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import it.unibo.chessgravity.model.api.Board;
import it.unibo.chessgravity.model.api.move.BaseMove;
import it.unibo.chessgravity.model.api.move.MovePiece;
import it.unibo.chessgravity.model.api.move.MoveResponse;
import it.unibo.chessgravity.model.api.square.SquarePosition;
import it.unibo.chessgravity.model.impl.move.base.BaseMoveAbstract.MoveChecker;
import it.unibo.chessgravity.model.impl.move.base.*;

/**
 * Class that models the movement strategy that has to be done by a knight piece.
 */
public class MoveKnight implements MovePiece {

    private final static int STEP = 2;

    private final BaseMove moveTop;
    private final BaseMove moveLeft;
    private final BaseMove moveRight;
    private final BaseMove moveBottom;

    public MoveKnight() {
        final MoveChecker unCheck = (a, b) -> new MoveResponse(a, true, false);
        
        moveTop = new MoveTop(unCheck);
        moveLeft = new MoveLeft(unCheck);
        moveRight = new MoveRight(unCheck);
        moveBottom = new MoveBottom(unCheck);
    }

    @Override
    public MoveResponse move(SquarePosition start, SquarePosition dest, Board board) {
        final List<List<BaseMove>> moves = prepareMoves();

        if (start.equals(dest)) {
            return new MoveResponse(dest, true, false);
        }

        for (List<BaseMove> move : moves) {
            final SquarePosition pos = move.get(0).move(start, board, STEP).getPos();

            for (int i = 1; i < move.size(); ++i) {
                final SquarePosition finalPos = move.get(i).move(pos, board).getPos();
                if (dest.equals(finalPos)) {
                    return BaseMoveAbstract.checkMove(finalPos, board);
                }
            }
        }

        return new MoveResponse(null, false, false);
    }

    private List<List<BaseMove>> prepareMoves() {
        final List<List<BaseMove>> lst = new ArrayList<>();
        lst.add(Arrays.asList(moveTop, moveLeft, moveRight));
        lst.add(Arrays.asList(moveLeft, moveTop, moveBottom));
        lst.add(Arrays.asList(moveRight, moveTop, moveBottom));
        lst.add(Arrays.asList(moveBottom, moveLeft, moveRight));

        return lst;
    }
    
}
