package Others.Chess.model;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {

	public Queen(Player player, Square square) {
		super(player, square);
	}

	@Override
	public List<Square> getPossibleMoves() {
		List<Square> possibleMoves = new ArrayList<>();
		// TODO Diagonal Left-Right
		// TODO Diagonal Right-Left
		// Horizontal
		for (int i = 0; i < 8; i++) {
			if (isValidMovement(square.getChessBoard().squareAt(i, square.getY()))) {
				possibleMoves.add(square.getChessBoard().squareAt(i, square.getY()));
			}
		}
		// Vertical
		for (int i = 0; i < 8; i++) {
			if (isValidMovement(square.getChessBoard().squareAt(square.getX(), i))) {
				possibleMoves.add(square.getChessBoard().squareAt(square.getX(), i));
			}

		}
		return possibleMoves;
	}

	@Override
	public void move(Square newSquare) {
		// TODO Auto-generated method stub

	}

}
