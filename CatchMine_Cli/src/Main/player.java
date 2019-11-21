package Main;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class player extends JPanel {

	block b;
	Graphics g;
	int charState;

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

	public void painting(int state) {
		charState = state;
	}

	static ImageIcon BackImage = new ImageIcon("image/gif/Back_Move.gif");
	static ImageIcon FrontImage = new ImageIcon("image/gif/Front_Move.gif");
	static ImageIcon LeftImage = new ImageIcon("image/gif/Left_Move.gif");
	static ImageIcon RightImage = new ImageIcon("image/gif/Right_Move.gif");
	Image img;
	ImageIcon gifImg;
	public void paintComponent(Graphics g) {
		gifImg = FrontImage;

		if (charState == 1)
			gifImg = BackImage;
		if (charState == 2)
			gifImg = LeftImage;
		if (charState == 3)
			gifImg = FrontImage;
		if (charState == 4)
			gifImg = RightImage;

		img = gifImg.getImage();
		g.drawImage(img, 0, 0, 40, 40, null);
		

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
