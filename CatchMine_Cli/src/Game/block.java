package Game;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class block extends JPanel {

	private boolean blockState; // ���� ���� �Ǿ����� �Ǵ� ����
	private int x; // x �� ��ǥ
	private int y; // y �� ��ǥ
	ImageIcon image; // ���� �̹���
	JLabel label;

	private boolean[][] MinePosition; //

	private int mineCount;

	public block() {
	}

	public void setBlockState(boolean bool) {
		this.blockState = bool;
	}

	public boolean getBlockState() {
		return blockState;
	}

	public block(ImageIcon image, int x, int y) {
		this.x = x;
		this.y = y;
		this.image = image;
		this.blockState = false;

		this.setSize(40, 40);
		this.setLayout(new GridLayout(0, 1));

		super.setLocation(x, y);

		label = new JLabel();

		label.setIcon(image);
		label.setLocation(0, 0);

		this.add(label);

	}

	public block(ImageIcon image, int x, int y, boolean state) {
		this.x = x;
		this.y = y;
		this.image = image;
		this.blockState = state;

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
