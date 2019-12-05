package Game;

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

	// ����â �ٱ����� ���������ϴ� �κ�
	public void outOfrange() {

		if (getLocationX() < 40) { // ĳ������ ���� x ��ǥ�� ���� �������� �ϸ� ����ĭ ũ�� ��ŭ ��ǥ����
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

	// ======================= ĳ���� �̹��� ============================ //
	// �� ���� ��� �� �߰� �� ����
	static ImageIcon BackImage = new ImageIcon("image/gif/Back_Move.gif");
	static ImageIcon FrontImage = new ImageIcon("image/gif/Front_Move.gif");
	static ImageIcon LeftImage = new ImageIcon("image/gif/Left_Move.gif");
	static ImageIcon RightImage = new ImageIcon("image/gif/Right_Move.gif");
	//
	static ImageIcon BackAttack = new ImageIcon("image/gif/Back_AttackMotion.gif");
	static ImageIcon FrontAttack = new ImageIcon("image/gif/Front_AttackMotion.gif");
	static ImageIcon LeftAttack = new ImageIcon("image/gif/Left_AttackMotion.gif");
	static ImageIcon RightAttack = new ImageIcon("image/gif/Right_AttackMotion.gif");

	// ======================= ĳ���� �̹��� ============================ //

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
		if (charState == 5)
			gifImg = BackAttack;
		if (charState == 6)
			gifImg = LeftAttack;
		if (charState == 7)
			gifImg = FrontAttack;
		if (charState == 8)
			gifImg = RightAttack;

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
