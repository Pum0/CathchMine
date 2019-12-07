package Game;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class block extends JPanel {

	private boolean blockState; // 블럭이 선택 되었는지 판단 여부
	private int x; // x 축 좌표
	private int y; // y 축 좌표
	ImageIcon image; // 블럭의 이미지
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

	// 블럭 존재 여부 판단
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
