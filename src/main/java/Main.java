import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.Side;
import models.Agent;
import models.Game;
import models.GameVariation;
import models.RandomPlayer;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(new Agent(Side.WHITE), new RandomPlayer(Side.BLACK), GameVariation.normal);
        System.out.println(game.play());
//        Board board = new Board();
//        board.loadFromFen("3k4/8/8/8/8/3q4/2P5/2K5 w KQkq - 0 1");
//        System.out.println(board.legalMoves());
    }

}
