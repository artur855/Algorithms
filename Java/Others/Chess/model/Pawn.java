package Others.Chess.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

	private boolean hasMoved;
	private int direction;
	public Pawn(Player player, Square square) {
		super(player, square);
		this.hasMoved = false;
		this.direction = player.getColor()== Color.WHITE ? 1 : -1;
	}

	@Override
	public List<Square> possibleMoves() {
		List<Square> possibleMoves = new ArrayList<>();
		//Top Square
		Square possibleLocation = square.getNeighbour(0, direction);
		if (super.isValidMovement(possibleLocation)) {
			possibleMoves.add(possibleLocation);
		}
		//First Movement
		if (!hasMoved) {
			hasMoved = true;
			possibleLocation = square.getNeighbour(0, 2*direction);
			if (super.isValidMovement(possibleLocation)) {
				possibleMoves.add(possibleLocation);
			}
		}
		//Top-Right Square
		possibleLocation = square.getNeighbour(1, direction);
		if (this.isValidMovement(possibleLocation)) {
			possibleMoves.add(possibleLocation);
		}
		//Top-Left Square
		possibleLocation = square.getNeighbour(-1, direction);
		if (this.isValidMovement(possibleLocation)) {
			possibleMoves.add(possibleLocation);
		}
		return possibleMoves;
	}

	@Override
	public boolean isValidMovement(Square square) {
		if (square != null && square.getPiece() != null && square.getPiece().getPlayer() != this.player) {
			return true;
		}
		return false;
	}

}
