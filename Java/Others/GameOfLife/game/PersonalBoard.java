package Others.GameOfLife.game;

import java.util.Random;

import Others.GameOfLife.GameOfLifeBoard;

public class PersonalBoard extends GameOfLifeBoard {

	private boolean[][] tempBoard;

	public PersonalBoard(int width, int height) {
		super(width, height);
		tempBoard = new boolean[width][height];
	}

	@Override
	public void playTurn() {
		for (int i = 0; i < this.tempBoard.length; i++) {
			for (int j = 0; j < this.tempBoard[i].length; j++) {
				this.manageCell(i, j);
			}
		}
		for (int i = 0; i < this.tempBoard.length; i++) {
			for (int j = 0; j < this.tempBoard[i].length; j++) {
				super.getBoard()[i][j] = this.tempBoard[i][j];
			}
		}
	}

	@Override
	public void turnToLiving(int x, int y) {
		if (!this.outOfBounds(x, y)) {
			super.getBoard()[x][y] = true;
		}
	}

	@Override
	public void turnToDead(int x, int y) {
		if (!this.outOfBounds(x, y)) {
			super.getBoard()[x][y] = false;
		}
	}

	@Override
	public boolean isAlive(int x, int y) {
		return (this.outOfBounds(x, y)) ? false : super.getBoard()[x][y];
	}

	private boolean outOfBounds(int x, int y) {
		return x > super.getWidth() && x < 0 && y > super.getHeight() && y < 0;
	}

	@Override
	public void initiateRandomCells(double probabilityForEachCell) {
		Random rn = new Random();
		boolean[] newCells = new boolean[100];
		for (int i = 0; i < probabilityForEachCell; i++) {
			newCells[i] = true;
		}
		for (boolean[] line : super.getBoard()) {
			for (int i = 0; i < line.length; i++) {
				line[i] = newCells[rn.nextInt(100)];
			}
		}
	}

	@Override
	public int getNumberOfLivingNeightbours(int x, int y) {
		boolean[][] board = super.getBoard();
		int count = 0;
		boolean[] cells = null;
		if (x == 0 && y == 0) {
			cells = new boolean[] { board[x + 1][y], board[x][y + 1], board[x + 1][y + 1] };
		} else if (x == 0 && y == super.getHeight() - 1) {
			cells = new boolean[] { board[x + 1][y], board[x][y - 1], board[x + 1][y - 1] };
		} else if (x == super.getWidth() - 1 && y == 0) {
			cells = new boolean[] { board[x - 1][y], board[x][y + 1], board[x - 1][y + 1] };
		} else if (x == super.getWidth() - 1 && y == super.getHeight() - 1) {
			cells = new boolean[] { board[x - 1][y], board[x][y - 1], board[x - 1][y - 1] };
		} else if (x == 0 && y > 0 && y < super.getHeight() - 1) {
			cells = new boolean[] { board[x][y - 1], board[x][y + 1], board[x + 1][y - 1], board[x + 1][y],
					board[x + 1][y + 1] };
		} else if (x == super.getWidth() - 1 && y > 0 && y < super.getHeight() - 1) {
			cells = new boolean[] { board[x][y - 1], board[x][y + 1], board[x - 1][y - 1], board[x - 1][y],
					board[x - 1][y + 1] };
		} else if (y == 0 && x > 0 && x < super.getWidth()) {
			cells = new boolean[] { board[x - 1][y], board[x + 1][y], board[x - 1][y + 1], board[x][y + 1],
					board[x + 1][y + 1] };
		} else if (y == super.getHeight() - 1 && x > 0 && x < super.getWidth() - 1) {
			cells = new boolean[] { board[x - 1][y], board[x + 1][y], board[x - 1][y - 1], board[x][y - 1],
					board[x + 1][y - 1] };
		} else {
			cells = new boolean[] { board[x - 1][y - 1], board[x][y - 1], board[x + 1][y - 1], board[x - 1][y],
					board[x + 1][y], board[x - 1][y + 1], board[x][y + 1], board[x + 1][y + 1] };
		}

		for (boolean cell : cells) {
			if (cell) {
				count++;
			}
		}
		return count;
	}

	@Override
	public void manageCell(int x, int y) {
		int neighbours = this.getNumberOfLivingNeightbours(x, y);
		if (super.getBoard()[x][y]) {
			if (neighbours < 2) {
				this.tempBoard[x][y] = false;
			} else if (neighbours > 3) {
				this.tempBoard[x][y] = false;
			} else {
				this.tempBoard[x][y] = true;
			}
		} else {
			if (neighbours == 3) {
				this.tempBoard[x][y] = true;
			} 
		}
	}

}
