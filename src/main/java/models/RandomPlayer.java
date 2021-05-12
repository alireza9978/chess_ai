package models;

import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.Side;
import com.github.bhlangonijr.chesslib.move.Move;

import java.util.List;
import java.util.Random;

public class RandomPlayer extends Player {

    private final Random random = new Random();

    public RandomPlayer(Side side) {
        super(side);
    }

    @Override
    public Move play(Board board) {
        List<Move> moves = board.legalMoves();
        return moves.get(random.nextInt(moves.size()));
    }


}
