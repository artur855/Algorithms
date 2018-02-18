package Others.GameOfLife.gui;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import Others.GameOfLife.GameOfLifeBoard;

public class UserInterface extends JFrame implements Runnable {

	private static final long serialVersionUID = -5596405280978712783L;
	private GameOfLifeBoard game;
	public UserInterface(GameOfLifeBoard game) {
		this.game = game;
		this.game.initiateRandomCells(60);
	}
	public UserInterface(GameOfLifeBoard game, int probability) {
		this.game = game;
		this.game.initiateRandomCells(probability);
	}
	@Override
	public void run() {
		super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		createComponents(super.getContentPane());
		super.pack();
		super.setVisible(true);
	}

	public void createComponents(Container container) {
		DrawBoard board = new DrawBoard(this.game);
		container.add(board);
		container.setPreferredSize(new Dimension(game.getWidth()*20, game.getHeight()*20));
	}
	
}
