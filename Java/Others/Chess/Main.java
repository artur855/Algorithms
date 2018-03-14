package Others.Chess;

import java.awt.Color;

import Others.Chess.model.ChessBoard;
import Others.Chess.model.King;
import Others.Chess.model.Pawn;
import Others.Chess.model.Player;
import Others.Chess.model.Square;

public class Main {

	public static void main(String[] args) {
		ChessBoard chessBoard = new ChessBoard();
		Player p1 = new Player(Color.WHITE);
		Player p2 = new Player(Color.BLACK);
		Square square = new Square(4,3, chessBoard);
		square.setPiece(new Pawn(p2, square));
		chessBoard.getBoard()[4][3] = square;
		square = new Square(5,4, chessBoard);
		square.setPiece(new King(p1, square));
		chessBoard.getBoard()[5][4] = square;
		System.out.println(square.getChessBoard().getBoard()[4][3].getPiece());
		for (Square x : chessBoard.getBoard()[4][3].getPiece().possibleMoves()) {
			System.out.println(x);
		}
	}
}
