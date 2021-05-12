package models;

import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.Side;
import com.github.bhlangonijr.chesslib.move.Move;

import java.util.List;
import java.util.Random;

public class Agent extends Player {

    private final static int maxDepth = 3;

    public Agent(Side side) {
        super(side);
    }

    public int eval(Board board) {
        return 0;
    }

    @Override
    public Move play(Board board) {
        List<Move> moves = board.legalMoves();
        Move bestMove = null;
        int bestMoveValue = Integer.MIN_VALUE;
        for (Move move : moves) {
            if (board.doMove(move)) {
                int temp = min(board.clone(), 1);
                if (temp > bestMoveValue) {
                    bestMove = move;
                    bestMoveValue = temp;
                }
                board.undoMove();
            }
        }
        if (bestMove == null) {
            Random random = new Random();
            return moves.get(random.nextInt(moves.size()));
        }
        return bestMove;
    }

    public int max(Board board, int depth) {
        if (depth == maxDepth) {
            return eval(board);
        }
        List<Move> moves = board.legalMoves();
        int bestValue = Integer.MIN_VALUE;
        for (Move move : moves) {
            if (board.doMove(move)) {
                if (board.isMated()) {
                    return Integer.MAX_VALUE;
                }
                bestValue = Integer.max(min(board.clone(), depth + 1), bestValue);
                board.undoMove();
            }
        }
        return bestValue;
    }

    public int min(Board board, int depth) {
        if (depth == maxDepth) {
            return eval(board);
        }
        List<Move> moves = board.legalMoves();
        int bestValue = Integer.MAX_VALUE;
        for (Move move : moves) {
            if (board.doMove(move)) {
                if (board.isMated()) {
                    return Integer.MIN_VALUE;
                }
                bestValue = Integer.min(max(board.clone(), depth + 1), bestValue);
                board.undoMove();
            }
        }
        return bestValue;
    }


}
