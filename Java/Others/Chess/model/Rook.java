package Others.Chess.model;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {

	public Rook(Player player, Square square) {
		super(player, square);
	}

	@Override
	public List<Square> getPossibleMoves() {
		List<Square> possibleMoves = new ArrayList<>();
		// Horizontal
		for (int i = 0; i < 8; i++) {
			if (isValidMovement(square.getChessBoard().squareAt(square.getX(), i))) {
				possibleMoves.add(square.getChessBoard().squareAt(square.getX(), i));
			}
		}
		// Vertical
		for (int i = 0; i < 8; i++) {
			if (isValidMovement(square.getChessBoard().squareAt(i, square.getY()))) {
				possibleMoves.add(square.getChessBoard().squareAt(i, square.getY()));
			}
		}
		return possibleMoves;
	}

	@Override
	public void move(Square newSquare) {
		// TODO Auto-generated method stub

	}

}
