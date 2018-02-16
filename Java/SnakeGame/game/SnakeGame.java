package SnakeGame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import SnakeGame.Direction;
import SnakeGame.gui.Updatable;
import SnakeGame.models.Apple;
import SnakeGame.models.Point;
import SnakeGame.models.Snake;

public class SnakeGame extends Timer implements ActionListener {

	private static final long serialVersionUID = 6162905588365520672L;
	private Snake snake;
	private Apple apple;
	private boolean ok;
	private Updatable updatable;
	private int width;
	private Random random;
	private int height;

	public SnakeGame(int width, int height) {
		super(1000, null);
		addActionListener(this);
		this.width = width;
		random = new Random();
		this.height = height;
		this.snake = new Snake(this.width / 2, this.height / 2, Direction.DOWN);
		this.apple = createApple();
		ok = true;
	}

	public Apple createApple() {
		Apple apple = null;
		while (true) {
			apple = new Apple(random.nextInt(width), random.nextInt(height));
			if (!snake.colides(apple)) {
				break;
			}
		}
		return apple;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!this.ok) {
			return;
		}
		this.snake.move();
		if (this.snake.colides(apple)) {
			this.snake.grow();
			this.apple = createApple();
		}
		if (this.snake.colidesSelf()) {
			this.ok = false;
		}
		if (hitWall()) {
			this.ok = false;
		}
		this.updatable.update();
		setDelay(1000 / this.snake.getLength());
	}

	public boolean hitWall() {
		for (Point p : snake.getPoints()) {
			if (p.getX() >= this.width || p.getX() <= 0 || p.getY() >= this.height || p.getY() <= 0) {
				return true;
			}
		}
		return false;
	}

	public Snake getSnake() {
		return snake;
	}

	public void setSnake(Snake snake) {
		this.snake = snake;
	}

	public Apple getApple() {
		return apple;
	}

	public void setApple(Apple apple) {
		this.apple = apple;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setUpdatable(Updatable updatable) {
		this.updatable = updatable;
	}

}
