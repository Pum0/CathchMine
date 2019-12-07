package Game;

import java.awt.Image;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class player extends JPanel {
	private int charState;
	game_item item;
	private int x;
	private int y;
	Queue<String> itemPocket;

	Image playerImage;

	// ======================= ĳ���� �̹��� ============================ //
	static ImageIcon BackImage = new ImageIcon("image/gif/Back_Move.gif");
	static ImageIcon FrontImage = new ImageIcon("image/gif/Front_Move.gif");
	static ImageIcon LeftImage = new ImageIcon("image/gif/Left_Move.gif");
	static ImageIcon RightImage = new ImageIcon("image/gif/Right_Move.gif");

	// �� �νñ�
	static ImageIcon Check = new ImageIcon("image/gif/Front_AttackMotion.gif");

	static ImageIcon F_StandBy = new ImageIcon("image/testGif/1P_Front_Standby.gif");
	static ImageIcon B_StandBy = new ImageIcon("image/testGif/1P_Back_Standby.gif");
	static ImageIcon L_StandBy = new ImageIcon("image/testGif/1P_Left_Standby.gif");
	static ImageIcon R_StandBy = new ImageIcon("image/testGif/1P_Right_Standby.gif");

	JLabel playerlabel;

	public player() {
		playerlabel = new JLabel();
		playerlabel.setIcon(F_StandBy);
		this.x = 40;
		this.y = 40;
		this.setSize(40, 40);
		this.charState = 3;

		this.setOpaque(false);
		this.add(playerlabel);

		this.itemPocket = new LinkedList<>();
	}

//	public void paintComponent(Graphics g) {
//		gifImg = FrontImage;
//
//		if (charState == 1)
//			gifImg = BackImage;
//		if (charState == 2)
//			gifImg = LeftImage;
//		if (charState == 3)
//			gifImg = FrontImage;
//		if (charState == 4)
//			gifImg = RightImage;
//		if (charState == 5)
//			gifImg = Check;
//
//		img = gifImg.getImage();
//		g.drawImage(img, 0, 0, 40, 40, null);
//
//	}

	public void LocationSet(int x, int y) {
		setX(x);
		setY(y);

		this.setLocation(x, y);

	}

	// ����â �ٱ����� ���������ϴ� �κ�
	public void outOfrange() {

		if (getX() < 40) { // ĳ������ ���� x ��ǥ�� ���� �������� �ϸ� ����ĭ ũ�� ��ŭ ��ǥ����
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

	public void setImage(int State) {
		if (State == 1)
			playerlabel.setIcon(BackImage);
		if (State == 2)
			playerlabel.setIcon(LeftImage);
		if (State == 3)
			playerlabel.setIcon(FrontImage);
		if (State == 4)
			playerlabel.setIcon(RightImage);

		if (State == 5)
			playerlabel.setIcon(B_StandBy);
		if (State == 6)
			playerlabel.setIcon(L_StandBy);
		if (State == 7)
			playerlabel.setIcon(F_StandBy);
		if (State == 8)
			playerlabel.setIcon(R_StandBy);
		if (State == 10)
			playerlabel.setIcon(Check);

	}

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
