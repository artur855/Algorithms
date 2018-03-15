package Others.Chess.model;

import java.util.List;

public abstract class Piece {

	protected Player player;
	protected Square square;

	public Piece(Player player, Square square) {
		this.player = player;
		this.square = square;
		square.setPiece(this);
	}

	@Override
	public String toString() {
		return "Piece [player=" + player + ", square" + square + "]";
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Square getSquare() {
		return square;
	}

	public void setSquare(Square square) {
		this.square = square;
	}

	public abstract List<Square> getPossibleMoves();

	public abstract void move(Square newSquare);

	public boolean isValidMovement(Square square) {
		if (square != null && !square.equals(this.square)
				&& ((square.getPiece() == null) || (square.getPiece().player != this.player))) {
			return true;
		}
		return false;
	}
}
