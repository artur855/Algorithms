package Others.Chess.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class King extends Piece {

	private boolean inCheck;

	public King(Player player, Square square) {
		super(player, square);
	}

	@Override
	public List<Square> getPossibleMoves() {
		List<Square> possibleMoves = new ArrayList<>();
		// Top-Left Square
		Square possibleLocation = square.getNeighbour(-1, 1);
		if (isValidMovement(possibleLocation)) {
			possibleMoves.add(possibleLocation);
		}
		// Left Square
		possibleLocation = square.getNeighbour(-1, 0);
		if (isValidMovement(possibleLocation)) {
			possibleMoves.add(possibleLocation);
		}
		// Bottom-Left Square
		possibleLocation = square.getNeighbour(-1, -1);
		if (isValidMovement(possibleLocation)) {
			possibleMoves.add(possibleLocation);
		}
		// Top Square
		possibleLocation = square.getNeighbour(0, 1);
		if (isValidMovement(possibleLocation)) {
			possibleMoves.add(possibleLocation);
		}
		// Bottom Square
		possibleLocation = square.getNeighbour(0, -1);
		if (isValidMovement(possibleLocation)) {
			possibleMoves.add(possibleLocation);
		}
		// Top-Right Square
		possibleLocation = square.getNeighbour(1, 1);
		if (isValidMovement(possibleLocation)) {
			possibleMoves.add(possibleLocation);
		}
		// Right Square
		possibleLocation = square.getNeighbour(1, 0);
		if (isValidMovement(possibleLocation)) {
			possibleMoves.add(possibleLocation);
		}
		// Bottom-Right Square
		possibleLocation = square.getNeighbour(1, -1);
		if (isValidMovement(possibleLocation)) {
			possibleMoves.add(possibleLocation);
		}
		return possibleMoves;
	}

	public void castling(int direction) {
		if (!inCheck && hasSpace(direction)) {
			//Move King and Rook
		}
	}

	public boolean hasSpace(int direction) {
		if (player.getColor() == Color.WHITE) {
			if (direction == 1) {
				// White Right Castling
				Square rigthNext = square.getNeighbour(square.getX() + 1, square.getY());
				Square rigthNextNext = square.getNeighbour(square.getX() + 2, square.getY());
				return rigthNext.getPiece() == null && rigthNextNext.getPiece() == null;
			} else {
				// Black Right Castling
				Square leftNext = square.getNeighbour(square.getX() - 1, square.getY());
				Square leftNextNext = square.getNeighbour(square.getX() - 2, square.getY());
				Square leftNextNextNext = square.getNeighbour(square.getX() - 3, square.getY());
				return leftNext.getPiece() == null && leftNextNext.getPiece() == null
						&& leftNextNextNext.getPiece() == null;
			}
		} else {
			if (direction == 1) {
				// White Right Castling
				Square rigthNext = square.getNeighbour(square.getX() - 1, square.getY());
				Square rigthNextNext = square.getNeighbour(square.getX() - 2, square.getY());
				Square rigthNextNextNext = square.getNeighbour(square.getX() - 3, square.getY());
				return rigthNext.getPiece() == null && rigthNextNext.getPiece() == null
						&& rigthNextNextNext.getPiece() == null;
			} else {
				// Black Right Castling
				Square leftNext = square.getNeighbour(square.getX() + 1, square.getY());
				Square leftNextNext = square.getNeighbour(square.getX() + 2, square.getY());
				return leftNext.getPiece() == null && leftNextNext.getPiece() == null;
			}
		}
	}

	@Override
	public void move(Square newSquare) {
	}

}
