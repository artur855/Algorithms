package Others.Chess.model;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece{

	public Bishop(Player player, Square square) {
		super(player, square);
	}

	@Override
	public List<Square> getPossibleMoves() {
		List<Square> possibleMoves = new ArrayList<>();
		//TODO Diagonal Movement
		return possibleMoves;
	}

	@Override
	public void move(Square newSquare) {
		// TODO Auto-generated method stub
		
	}

}
