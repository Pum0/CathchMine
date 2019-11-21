package Main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class player extends JPanel {

	private int locationX;
	private int locationY;

	public player() {
		this.setSize(40, 40);

	}

	public void LocationSet(int x, int y) {
		setLocationX(x);
		setLocationY(y);

		this.setLocation(x, y);

	}

	// 게임창 바깥으로 못나가게하는 부분
	public void outOfrange() {

		if (getLocationX() < 40) {
			LocationSet(40, getLocationY());
			repaint();
		}
		if (getLocationX() + getWidth() > singleGame.GAMEXSIZE - 40) {
			LocationSet(singleGame.GAMEXSIZE - 80, getLocationY());
			repaint();
		}
		if (getLocationY() < 40) {
			LocationSet(getLocationX(), 40);
			repaint();
		}
		if (getLocationY() + getHeight() > singleGame.GAMEYSIZE - 40) {
			LocationSet(getLocationX(), singleGame.GAMEYSIZE - 80);
			repaint();
		}

	}

	public void paintComponent(Graphics g) {
		g.setColor(new Color(180, 55, 200));
		g.fillOval(0, 0, 40, 40);

	}

	public int getLocationX() {
		return locationX;
	}

	public void setLocationX(int locationX) {
		this.locationX = locationX;
	}

	public int getLocationY() {
		return locationY;
	}

	public void setLocationY(int locationY) {
		this.locationY = locationY;
	}

}
