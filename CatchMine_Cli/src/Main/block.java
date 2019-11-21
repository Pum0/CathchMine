package Main;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class block extends JPanel {

	private int blockHP[][];

	private int x; // x Ãà ÁÂÇ¥
	private int y; // y Ãà ÁÂÇ¥
	ImageIcon image;

	public block() {
	}

	public boolean isBlock(int i, int j) {
		if (blockHP[i][j] > 0)
			return true;

		return false;
	}

	public block(ImageIcon image, int x, int y) {
		this.x = x;
		this.y = y;
		this.image = image;

		this.setSize(40, 40);
		this.setLayout(new GridLayout(0, 1));

		super.setLocation(x, y);

		JLabel label = new JLabel();

		label.setIcon(image);
		label.setLocation(0, 0);

		this.add(label);

	}

	public String getImageName() {
		String str = image.getDescription();

		String imageName = str.substring(6, str.length() - 4);
		return imageName;
	}
	
	
	public int[][] getBlockHP() {
		return blockHP;
	}

	public void setBlockHP(int[][] blockHP) {
		this.blockHP = blockHP;
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

}
