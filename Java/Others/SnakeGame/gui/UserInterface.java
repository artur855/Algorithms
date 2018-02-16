package Others.SnakeGame.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import Others.SnakeGame.game.SnakeGame;

public class UserInterface extends JFrame implements Runnable {

	private static final long serialVersionUID = 2818362120917884348L;
	private SnakeGame snakeGame;
	private DrawBoard drawBoard;

	public UserInterface(SnakeGame snakeGame) {
		this.snakeGame = snakeGame;
		this.drawBoard = new DrawBoard(snakeGame,20);
	}

	public void createComponents(Container container) {
		container.add(drawBoard);
		container.addKeyListener(new KeyboardListener(snakeGame.getSnake()));
		container.setPreferredSize(new Dimension(this.snakeGame.getWidth(), this.snakeGame.getHeight()));
	}

	public Updatable getUpdatable() {
		return drawBoard;
	}

	@Override
	public void run() {
		super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.createComponents(super.getContentPane());
		super.pack();
		this.addKeyListener(new KeyboardListener(snakeGame.getSnake()));
		super.setTitle("Snake Game");
		super.setBackground(Color.WHITE);
		super.setVisible(true);
		snakeGame.start();
	}

}
