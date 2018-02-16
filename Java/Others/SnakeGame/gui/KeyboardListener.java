package Others.SnakeGame.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Others.SnakeGame.Direction;
import Others.SnakeGame.models.Snake;

public class KeyboardListener implements KeyListener {

	private Snake snake;

	public KeyboardListener(Snake snake) {
		this.snake = snake;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_DOWN:
			if(!this.snake.getDirection().name().equalsIgnoreCase("UP")) {				
				this.snake.setDirection(Direction.DOWN);
			}
			break;
		case KeyEvent.VK_UP:			
			if(!this.snake.getDirection().name().equalsIgnoreCase("DOWN")) {				
				this.snake.setDirection(Direction.UP);
			}
			break;
		case KeyEvent.VK_RIGHT:			
			if(!this.snake.getDirection().name().equalsIgnoreCase("LEFT")) {				
				this.snake.setDirection(Direction.RIGHT);
			}
			break;
		case KeyEvent.VK_LEFT:			
			if(!this.snake.getDirection().name().equalsIgnoreCase("RIGHT")) {				
				this.snake.setDirection(Direction.LEFT);
			}
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
