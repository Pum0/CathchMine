package Game;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class block extends JPanel {
//	// ================= �� �̹��� ================ //
//	ImageIcon teduriImage = new ImageIcon("image/GameObject/teduri.png");
//	ImageIcon blockImage = new ImageIcon("image/GameObject/block1.png");
//	ImageIcon blockImage2 = new ImageIcon("image/GameObject/block2.png");
//	ImageIcon blockImage3 = new ImageIcon("image/GameObject/block3.png");
//	ImageIcon tileImage = new ImageIcon("image/GameObject/tile.png");
//	// ================= �� �̹��� ================ //

	private boolean blockState; // ���� ���� �Ǿ����� �Ǵ� ����
	private int x; // x �� ��ǥ
	private int y; // y �� ��ǥ
	ImageIcon image; // ���� �̹���
	JLabel label;

	private int mineCount;

	public block() {
	}

	public block(ImageIcon image, int x, int y) {
		this.x = x;
		this.y = y;
		this.image = image;
		this.blockState = true;

		this.setSize(40, 40);
		this.setLayout(new GridLayout(0, 1));

		super.setLocation(x, y);

		label = new JLabel();

		label.setIcon(image);
		label.setLocation(0, 0);

		this.add(label);

	}

	public boolean isBlockState() {
		return blockState;
	}

	// �� ���� ���� �Ǵ�
	public boolean isBlock() {
		return isBlockState();

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setImage(ImageIcon image) {
		this.image = image;

		label.setIcon(image);
//		this.repaint();
	}

}
