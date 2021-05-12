package models;

import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.Side;
import com.github.bhlangonijr.chesslib.move.Move;

public abstract class Player {

    public final Side side;

    protected Player(Side side) {
        this.side = side;
    }

    public abstract Move play(Board board);

    @Override
    public String toString() {
        return "Player{" +
                "color=" + side +
                '}';
    }
}
