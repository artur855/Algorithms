package SnakeGame.gui;

import java.awt.Graphics;
import java.awt.Color;

import javax.swing.JPanel;

import SnakeGame.game.SnakeGame;
import SnakeGame.models.Apple;
import SnakeGame.models.Point;
import SnakeGame.models.Snake;

public class DrawBoard extends JPanel implements Updatable {

	private static final long serialVersionUID = -1653802086601642901L;
	private int pieceLenght;
	private SnakeGame game;

	public DrawBoard(SnakeGame game, int pieceLenght) {
		this.pieceLenght = pieceLenght;
		this.game = game;
	}

	@Override
	protected void paintComponent(Graphics g) {
		Snake snake = game.getSnake();
		Apple apple = game.getApple();
		for (Point p : snake.getPoints()) {
			g.setColor(Color.BLACK);
			g.drawString("VAI SE FUDER", 200, 200);
			g.fill3DRect(p.getX(), p.getY(), pieceLenght, pieceLenght, true);
		}
		g.setColor(Color.RED);
		g.fillOval(apple.getX(), apple.getY(), pieceLenght, pieceLenght);
		super.paintComponent(g);
	}

	@Override
	public void update() {
		super.repaint();
	}

}
