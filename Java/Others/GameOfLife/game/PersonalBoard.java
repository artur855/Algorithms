package Others.GameOfLife.game;

import java.util.Random;

import Others.GameOfLife.GameOfLifeBoard;

public class PersonalBoard extends GameOfLifeBoard {

	public PersonalBoard(int width, int height) {
		super(width, height);
	}

	@Override
	public void turnToLiving(int x, int y) {
		if (!this.outOfBounds(x, y)) {
			this.getBoard()[x][y] = true;
		}
	}

	@Override
	public void turnToDead(int x, int y) {
		if (!this.outOfBounds(x, y)) {
			this.getBoard()[x][y] = false;
		}
	}

	@Override
	public boolean isAlive(int x, int y) {
		return (this.outOfBounds(x, y)) ? false : this.getBoard()[x][y];
	}

	private boolean outOfBounds(int x, int y) {
		return x < this.getWidth() && x > 0 && y < this.getHeight() && y > 0;
	}

	@Override
	public void initiateRandomCells(double probabilityForEachCell) {
		Random rn = new Random();
		boolean[] newCells = new boolean[100];
		for (int i = 0; i < probabilityForEachCell; i++) {
			newCells[i] = true;
		}
		for (boolean[] line : this.getBoard()) {
			for(int i = 0; i < line.length; i++) {
				line[i] = newCells[rn.nextInt(100)];
			}
		}
	}

	@Override
	public int getNumberOfLivingNeightbours(int x, int y) {
		boolean[][] board = this.getBoard();
		int count = 0;
		boolean[] cells = null;
		if (x == 0 && y == 0) {
			cells = new boolean[] { board[x + 1][y], board[x][y + 1], board[x + 1][y + 1] };
		} else if (x == 0 && y == this.getHeight()) {
			cells = new boolean[] { board[x + 1][y], board[x][y - 1], board[x + 1][y - 1] };
		} else if (x == this.getWidth() && y == 0) {
			cells = new boolean[] { board[x - 1][y], board[x][y + 1], board[x - 1][y + 1] };
		} else if (x == this.getWidth() && y == this.getHeight()) {
			cells = new boolean[] { board[x - 1][y], board[x][y - 1], board[x - 1][y - 1] };
		} else if (x == 0 && y > 0 && y < this.getHeight()) {
			cells = new boolean[] { board[x][y + 1], board[x][y - 1], board[x + 1][y + 1], board[x + 1][y],
					board[x + 1][y - 1] };
		} else if (x == this.getWidth() && y > 0 && y < this.getHeight()) {
			cells = new boolean[] { board[x][y + 1], board[x][y - 1], board[x - 1][y], board[x - 1][y + 1],
					board[x - 1][y - 1] };
		} else if (y == 0 && x > 0 && x < this.getWidth()) {
			cells = new boolean[] { board[x + 1][y], board[x - 1][y], board[x][y + 1], board[x + 1][y + 1],
					board[x - 1][y + 1] };
		} else if (y == this.getHeight() && x > 0 && x < this.getWidth()) {
			cells = new boolean[] { board[x + 1][y], board[x - 1][y], board[x][y - 1], board[x + 1][y - 1],
					board[x - 1][y - 1] };
		} else {
			cells = new boolean[] { board[x - 1][y + 1], board[x][y + 1], board[x + 1][y + 1], board[x - 1][y - 1],
					board[x][y - 1], board[x + 1][y - 1], board[x + 1][y], board[x - 1][y] };
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
		int neighbours = this.getNumberOfLivingNeightbours(x,y);
		if (neighbours < 2 || neighbours > 3) {
			this.getBoard()[x][y]= false;
		} else if (!this.getBoard()[x][y] && neighbours == 3) {
			this.getBoard()[x][y]= true;
		} 
	}

}
