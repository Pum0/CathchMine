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

	// 게임창 바깥으로 못나가게하는 부분
	public void outOfrange() {

		if (getLocationX() < 40) { // 캐릭터의 현재 x 좌표가 벽을 지나려고 하면 벽한칸 크기 만큼 좌표조정
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

	// ======================= 캐릭터 이미지 ============================ //
	// 블럭 공격 모션 더 추가 될 예정
	static ImageIcon BackImage = new ImageIcon("image/gif/Back_Move.gif");
	static ImageIcon FrontImage = new ImageIcon("image/gif/Front_Move.gif");
	static ImageIcon LeftImage = new ImageIcon("image/gif/Left_Move.gif");
	static ImageIcon RightImage = new ImageIcon("image/gif/Right_Move.gif");
	//
	static ImageIcon BackAttack = new ImageIcon("image/gif/Back_AttackMotion.gif");
	static ImageIcon FrontAttack = new ImageIcon("image/gif/Front_AttackMotion.gif");
	static ImageIcon LeftAttack = new ImageIcon("image/gif/Left_AttackMotion.gif");
	static ImageIcon RightAttack = new ImageIcon("image/gif/Right_AttackMotion.gif");

	// ======================= 캐릭터 이미지 ============================ //

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
