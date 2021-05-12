package models;

import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.move.Move;

public class Game {

    private final Player whitePlayer;
    private final Player blackPlayer;
    private final Board board;

    public Game(Player whitePlayer, Player blackPlayer, GameVariation variation) {
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        this.board = new Board();
        this.board.loadFromFen(variation.toString());
    }


    public Player play() {
        System.out.println(board);
        Move whiteMove, blackMove;
        while (true) {
            whiteMove = whitePlayer.play(board.clone());
            if (whiteMove == null || !board.doMove(whiteMove)) {
                return blackPlayer;
            }else{
                System.out.println("white move = " + whiteMove);
            }
            System.out.println(board);
            if (board.isMated()) {
                return whitePlayer;
            }
            if (board.isDraw()){
                System.out.println("black stale mate :" + board.isStaleMate());
                return null;
            }
            blackMove = blackPlayer.play(board.clone());
            if (blackMove == null || !board.doMove(blackMove)) {
                return whitePlayer;
            }else{
                System.out.println("black move = " + blackMove);
            }
            System.out.println(board);
            if (board.isMated()) {
                return blackPlayer;
            }
            if (board.isDraw()){
                System.out.println("white stale mate :" + board.isStaleMate());
                return null;
            }
        }
    }

}
