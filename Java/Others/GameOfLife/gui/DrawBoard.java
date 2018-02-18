package Others.GameOfLife.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

import Others.GameOfLife.GameOfLifeBoard;

public class DrawBoard extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1864146218658369713L;
	private GameOfLifeBoard game;
	private Timer timer;
	
	public DrawBoard(GameOfLifeBoard game) {
		this.game = game;
		this.timer = new Timer(100, this);
		super.setBackground(Color.WHITE);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int x = 0;
		int y = 0;
		for (int i = 0; i < game.getBoard().length; i++) {
			for(int j = 0; j < game.getBoard()[i].length; j++) {
				if (game.getBoard()[i][j]) {
					g.setColor(Color.BLACK);
				} else {
					g.setColor(Color.WHITE);
				}
				g.fillRect(x, y, 20, 20);
				y += game.getHeight();
			}
			x+=game.getWidth();
			y = 0;
		}
		timer.start();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.game.playTurn();
		repaint();
	}

}
