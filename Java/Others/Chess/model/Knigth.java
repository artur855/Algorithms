package Others.Chess.model;

import java.util.ArrayList;
import java.util.List;

public class Knigth extends Piece {

	public Knigth(Player player, Square square) {
		super(player, square);
	}

	@Override
	public List<Square> getPossibleMoves() {
		List<Square> possibleMoves = new ArrayList<>();
		Square possibleLocation = square.getNeighbour(-2, -1);
		// L movements
		if (isValidMovement(possibleLocation)) {
			possibleMoves.add(possibleLocation);
		}
		possibleLocation = square.getNeighbour(-2, 1);
		if (isValidMovement(possibleLocation)) {
			possibleMoves.add(possibleLocation);
		}
		possibleLocation = square.getNeighbour(2, -1);
		if (isValidMovement(possibleLocation)) {
			possibleMoves.add(possibleLocation);
		}
		possibleLocation = square.getNeighbour(2, 1);
		if (isValidMovement(possibleLocation)) {
			possibleMoves.add(possibleLocation);
		}
		possibleLocation = square.getNeighbour(-1, -2);
		if (isValidMovement(possibleLocation)) {
			possibleMoves.add(possibleLocation);
		}
		possibleLocation = square.getNeighbour(1, -2);
		if (isValidMovement(possibleLocation)) {
			possibleMoves.add(possibleLocation);
		}
		possibleLocation = square.getNeighbour(-1, 2);
		if (isValidMovement(possibleLocation)) {
			possibleMoves.add(possibleLocation);
		}
		possibleLocation = square.getNeighbour(1, 2);
		if (isValidMovement(possibleLocation)) {
			possibleMoves.add(possibleLocation);
		}

		return possibleMoves;
	}

	@Override
	public void move(Square newSquare) {
		// TODO Auto-generated method stub
	}

}
