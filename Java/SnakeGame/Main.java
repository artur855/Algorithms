package SnakeGame;

import javax.swing.JOptionPane;

import SnakeGame.game.SnakeGame;
import SnakeGame.gui.UserInterface;

public class Main {

	public static void main(String[] args) {
		SnakeGame game = new SnakeGame(500, 500);
		UserInterface ui = new UserInterface(game);
		while (ui.getUpdatable() == null){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				JOptionPane.showMessageDialog(null, "The board hasn't been created yet.");
			}
		}
		game.setUpdatable(ui.getUpdatable());
		ui.run();
		
	}

}
