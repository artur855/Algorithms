package Others.GameOfLife;

import javax.swing.SwingUtilities;

import Others.GameOfLife.game.PersonalBoard;
import Others.GameOfLife.gui.UserInterface;

public class Main {
	public static void main(String[] args) {
		UserInterface ui = new UserInterface(new PersonalBoard(50,50));
		
		SwingUtilities.invokeLater(ui);
	}
}
