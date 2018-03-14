package Others.Chess.model;

public class Square {

	private Piece piece;
	private ChessBoard chessBoard;
	private int x, y;

	public Square(int x, int y, ChessBoard chessBoard) {
		this.x = x;
		this.y = y;
		this.chessBoard = chessBoard;
	}

	public Square(int x, int y, ChessBoard chessBoard, Piece piece) {
		this(x, y, chessBoard);
		this.piece = piece;
	}

	public Square getNeighbour(int nx, int ny) {
		if (this.x + nx >= 0 && this.x + nx <= 7 && this.y + ny >= 0 && this.y + ny <= 7) {
			return this.chessBoard.squareAt(this.x + nx, this.y + ny);
		}
		return null;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public ChessBoard getChessBoard() {
		return chessBoard;
	}

	public void setChessBoard(ChessBoard chessBoard) {
		this.chessBoard = chessBoard;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		String result = "Square [";
		if (piece != null) {
			result += "piece=" + piece.getClass().getSimpleName() + ", ";
		}
		result += "x=" + x + ", y=" + y + "]";
		return result;
	}

}
