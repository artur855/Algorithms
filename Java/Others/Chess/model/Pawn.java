package Others.Chess.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

	private int direction;
	private boolean canEnPassant;

	public Pawn(Player player, Square square) {
		super(player, square);
		this.direction = player.getColor() == Color.WHITE ? 1 : -1;
	}

	@Override
	public List<Square> getPossibleMoves() {
		List<Square> possibleMoves = new ArrayList<>();
		// Top Square
		Square possibleLocation = square.getNeighbour(0, direction);
		if (super.isValidMovement(possibleLocation)) {
			possibleMoves.add(possibleLocation);
		}
		// First Movement
		if (inInitialPosition()) {
			possibleLocation = square.getNeighbour(0, 2 * direction);
			if (super.isValidMovement(possibleLocation)) {
				possibleMoves.add(possibleLocation);
			}
		}
		// Top-Right Square
		if (this.isValidMovement(possibleLocation)) {
			possibleLocation = square.getNeighbour(1, direction);
			possibleMoves.add(possibleLocation);
		}
		// Top-Left Square
		if (this.isValidMovement(possibleLocation)) {
			possibleLocation = square.getNeighbour(-1, direction);
			possibleMoves.add(possibleLocation);
		}

		if (this.canEnPassant()) {
			// En Passant Left
			possibleLocation = square.getNeighbour(-1, direction);
			if (isValidMovement(possibleLocation) && possibleLocation.getPiece() instanceof Pawn) {
				possibleMoves.add(possibleLocation);
			}
			// En Passant Rigth
			possibleLocation = square.getNeighbour(1, direction);
			if (isValidMovement(possibleLocation) && possibleLocation.getPiece() instanceof Pawn) {
				possibleMoves.add(possibleLocation);
			}
		}
		return possibleMoves;
	}

	public boolean inInitialPosition() {
		if ((this.direction == 1 && this.square.getY() == 1) || (this.direction == -1 && this.square.getY() == 6)) {
			return true;
		}
		return false;
	}

	public boolean canEnPassant() {
		return this.canEnPassant;
	}

	public void setCanEnPassant(boolean canEnPassant) {
		this.canEnPassant = canEnPassant;
	}

	@Override
	public boolean isValidMovement(Square square) {
		if (square != null && square.getPiece() != null && square.getPiece().getPlayer() != this.player) {
			return true;
		}
		return false;
	}

	@Override
	public void move(Square newSquare) {
	}

}
