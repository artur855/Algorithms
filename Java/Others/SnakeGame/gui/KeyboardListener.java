package Others.SnakeGame.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Others.SnakeGame.Direction;
import Others.SnakeGame.GameState;
import Others.SnakeGame.game.SnakeGame;

public class KeyboardListener implements KeyListener {

	private SnakeGame game;

	public KeyboardListener(SnakeGame game) {
		this.game = game;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_DOWN:
			if(!this.game.getSnake().getDirection().name().equalsIgnoreCase("UP")) {				
				this.game.getSnake().setDirection(Direction.DOWN);
			}
			break;
		case KeyEvent.VK_UP:			
			if(!this.game.getSnake().getDirection().name().equalsIgnoreCase("DOWN")) {				
				this.game.getSnake().setDirection(Direction.UP);
			}
			break;
		case KeyEvent.VK_RIGHT:			
			if(!this.game.getSnake().getDirection().name().equalsIgnoreCase("LEFT")) {				
				this.game.getSnake().setDirection(Direction.RIGHT);
			}
			break;
		case KeyEvent.VK_LEFT:			
			if(!this.game.getSnake().getDirection().name().equalsIgnoreCase("RIGHT")) {				
				this.game.getSnake().setDirection(Direction.LEFT);
			}
			break;
		case KeyEvent.VK_P:
			if (this.game.getGameState().name().equals("PLAY")) {
				this.game.setGameState(GameState.PAUSE);
			} else if (this.game.getGameState().name().equals("PAUSE")) {
				this.game.setGameState(GameState.PLAY);
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
