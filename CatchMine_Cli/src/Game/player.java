package Game;

import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class player extends JPanel {
	private int charState;
	game_item item;
	private int x;
	private int y;

	Queue<String> itemPocket;

	// ======================= 캐릭터 이미지 ============================ //
	static ImageIcon BackImage = new ImageIcon("image/gif/Back_Move.gif");
	static ImageIcon FrontImage = new ImageIcon("image/gif/Front_Move.gif");
	static ImageIcon LeftImage = new ImageIcon("image/gif/Left_Move.gif");
	static ImageIcon RightImage = new ImageIcon("image/gif/Right_Move.gif");
	
	// 블럭 부시기
	static ImageIcon Check = new ImageIcon("image/gif/Front_AttackMotion.gif");

	public player() {
		this.x = 40;
		this.y = 40;
		this.setSize(40, 40);
		this.charState = 3;

		this.itemPocket = new LinkedList<>();
	}

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
			gifImg = Check;

		img = gifImg.getImage();
		g.drawImage(img, 0, 0, 40, 40, null);

	}

	public void LocationSet(int x, int y) {
		setX(x);
		setY(y);

		this.setLocation(x, y);

	}

	// 게임창 바깥으로 못나가게하는 부분
	public void outOfrange() {

		if (getX() < 40) { // 캐릭터의 현재 x 좌표가 벽을 지나려고 하면 벽한칸 크기 만큼 좌표조정
			LocationSet(40, getY());
			repaint();
		}
		if (getX() + getWidth() > singleGame.GAMEXSIZE - 40) {
			LocationSet(singleGame.GAMEXSIZE - 80, getY());
			repaint();
		}
		if (getY() < 40) {
			LocationSet(getX(), 40);
			repaint();
		}
		if (getY() + getHeight() > singleGame.GAMEYSIZE - 40) {
			LocationSet(getX(), singleGame.GAMEYSIZE - 80);
			repaint();
		}

	}

	public void setState(int state) {
		charState = state;

	}
//	public void painting(int state) {
//		charState = state;
//	}

	Image img;
	ImageIcon gifImg;

	public int getX() {
		return x;
	}

	public void setX(int locationX) {
		this.x = locationX;
	}

	public int getY() {
		return y;
	}

	public void setY(int locationY) {
		this.y = locationY;
	}

}
