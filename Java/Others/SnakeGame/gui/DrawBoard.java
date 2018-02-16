package Others.SnakeGame.gui;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import Others.SnakeGame.game.SnakeGame;
import Others.SnakeGame.models.Apple;
import Others.SnakeGame.models.Point;
import Others.SnakeGame.models.Snake;

public class DrawBoard extends JPanel implements Updatable {

	private static final long serialVersionUID = -1653802086601642901L;
	private int pieceLenght;
	private SnakeGame game;

	public DrawBoard(SnakeGame game, int pieceLenght) {
		this.pieceLenght = pieceLenght;
		this.game = game;
		super.setBackground(Color.WHITE);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Snake snake = game.getSnake();
		Apple apple = game.getApple();
		
		for (Point p : snake.getPoints()) {
			g.setColor(Color.BLACK);
			g.fillRect(p.getX(), p.getY(), pieceLenght, pieceLenght);
			
		}
		g.setColor(Color.RED);
		g.fillOval(apple.getX(), apple.getY(), pieceLenght, pieceLenght);
	}

	@Override
	public void update() {
		super.repaint();
	}

}
