package Others.Chess.model;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {

	public King(Player player, Square square) {
		super(player, square);
	}

	@Override
	public List<Square> possibleMoves() {
		List<Square> possibleMoves = new ArrayList<>();
		//Top-Left Square
		Square possibleLocation = square.getNeighbour(-1, 1);
		if (isValidMovement(possibleLocation)) {
			possibleMoves.add(possibleLocation);
		}
		//Left Square
		possibleLocation = square.getNeighbour(-1, 0);
		if (isValidMovement(possibleLocation)) {
			possibleMoves.add(possibleLocation);
		}
		//Bottom-Left Square
		possibleLocation = square.getNeighbour(-1, -1);
		if (isValidMovement(possibleLocation)) {
			possibleMoves.add(possibleLocation);
		}
		//Top Square
		possibleLocation = square.getNeighbour(0, 1);
		if (isValidMovement(possibleLocation)) {
			possibleMoves.add(possibleLocation);
		}
		//Bottom Square
		possibleLocation = square.getNeighbour(0, -1);
		if (isValidMovement(possibleLocation)) {
			possibleMoves.add(possibleLocation);
		}
		//Top-Right Square
		possibleLocation = square.getNeighbour(1, 1);
		if (isValidMovement(possibleLocation)) {
			possibleMoves.add(possibleLocation);
		}
		//Right Square
		possibleLocation = square.getNeighbour(1, 0);
		if (isValidMovement(possibleLocation)) {
			possibleMoves.add(possibleLocation);
		}
		//Bottom-Right Square
		possibleLocation = square.getNeighbour(1, -1);
		if (isValidMovement(possibleLocation)) {
			possibleMoves.add(possibleLocation);
		}
		return possibleMoves;
	}


}
