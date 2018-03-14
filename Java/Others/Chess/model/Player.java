package Others.Chess.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Player {

	private List<Piece> pieces;
	private Color color;

	public Player(Color color) {
		this.color = color;
		pieces = new ArrayList<>();
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public List<Piece> getPieces() {
		return pieces;
	}

	public void setPieces(List<Piece> pieces) {
		this.pieces = pieces;
	}

}
