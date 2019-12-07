package Game;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class block extends JLayeredPane {

	private boolean blockState; // ���� ���� �Ǿ����� �Ǵ� ����
	private int x; // x �� ��ǥ
	private int y; // y �� ��ǥ
	ImageIcon image; // ���� �̹���

	JLabel blockLabel;
	JLabel tileLabel;
	// ================= �� �̹��� ================ //
	ImageIcon teduriImage = new ImageIcon("image/GameObject/teduri.png");
	ImageIcon blockImage = new ImageIcon("image/GameObject/block1.png");
	ImageIcon tileImage = new ImageIcon("image/GameObject/tile.png");
	// ================= �� �̹��� ================ //
	// �� �ڽ�

//	private int mineCount; // ���� ���ڿ� ���� ������ ����

	public block() {
//		bl = new block[18][35];
	}

	// ������ ����� ���õǾ����� �Ǵ�
	public void setBlockState(boolean bool) {
		this.blockState = bool;
	}

	public boolean getBlockState() {
		return blockState;
	}

	// block�� �����Ҷ� ���
	public block(ImageIcon image, int x, int y) {
		this.x = x;
		this.y = y;
		this.image = image;
		this.blockState = false;

		this.setSize(40, 40);
		this.setLayout(new GridLayout(0, 1));

		super.setLocation(x, y);

		blockLabel = new JLabel();

		blockLabel.setIcon(image);
		blockLabel.setLocation(0, 0);

		this.add(blockLabel);

	}

	public block(ImageIcon image, int x, int y, boolean state) {
		this.x = x;
		this.y = y;
		this.image = image;
		this.blockState = state;
		blockLabel = new JLabel();
		tileLabel = new JLabel();
//		this.setLayout(new GridLayout(0, 1));

//		this.setLayout(null);

		this.setSize(40, 40);

		super.setLocation(x, y);

		blockLabel.setIcon(image);
		blockLabel.setBounds(x, y, 40, 40);
		blockLabel.setLocation(0, 0);

//		tileLabel.setIcon(tileImage);
//		tileLabel.setLocation(0, 0);

//		this.add(tileLabel, new Integer(0));
		this.add(blockLabel, new Integer(0));

	}

	public void initBlock(JPanel panel, block[][] bl) {
		int x = 0;
		int y = 0;

		for (int i = 0; i < bl.length; i++) {
			for (int j = 0; j < bl[i].length; j++) {

				if ((i == 0 || j == 0) || (i == 17 || j == 34)) {
					bl[i][j] = new block(teduriImage, x, y);

				}

				else {
					bl[i][j] = new block(blockImage, x, y, false);

				}
				x += 40;

			}
			x = 0;
			y += 40;

		}

		for (int i = 0; i < bl.length; i++)
			for (int j = 0; j < bl[i].length; j++)
				panel.add(bl[i][j]);

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

	// Ÿ�� ���� ����� ���� ����� �޼ҵ�,
	public void removeBlock(block bl) {
		bl.blockLabel.setIcon(null);
	}

	public void setImage() {
//		this.image = image;
		blockLabel.setIcon(tileImage);
	}

}
