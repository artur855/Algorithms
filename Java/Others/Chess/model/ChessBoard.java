package Others.Chess.model;

public class ChessBoard {

	private Square[][] board;

	public ChessBoard() {
		board = new Square[8][8];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = new Square(i, j, this);
			}
		}
	}

	public Square[][] getBoard() {
		return board;
	}

	public void setBoard(Square[][] board) {
		this.board = board;
	}

	public Square squareAt(int x, int y) {
		return this.board[x][y];
	}

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < 8; i++) {
			result += "|";
			for (int j = 0; j < 8; j++) {
				result += (board[i][j].getPiece() == null) ? "Square|"
						: board[i][j].getPiece().getClass().getSimpleName() + "|";
			}
			result += "\n---------------------------------------------------------\n";
		}
		return result;
	}

}
