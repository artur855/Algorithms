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
		this.drawBoard = new DrawBoard(snakeGame, 10);
	}

	public void createComponents(Container container) {
		container.add(drawBoard);
		container.setPreferredSize(new Dimension(this.snakeGame.getWidth(), this.snakeGame.getHeight()));
	}

	public Updatable getUpdatable() {
		return drawBoard;
	}

	@Override
	public void run() {
		super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.createComponents(super.getContentPane());
		super.setTitle("Snake Game");
		super.addKeyListener(new KeyboardListener(snakeGame));
		super.pack();
		super.setBackground(Color.WHITE);
		super.setVisible(true);
		while (!snakeGame.getGameState().name().equals("OVER")) {
			switch (snakeGame.getGameState()) {
			case PLAY:
				if (!snakeGame.isRunning()) {
					snakeGame.start();
				}
				break;
			case PAUSE:
				if (snakeGame.isRunning()) {
					snakeGame.stop();
				}
				if (!snakeGame.isRunning()) {
					snakeGame.restart();
				}
				break;
			default:
			}
		}
		snakeGame.stop();
	}
}
