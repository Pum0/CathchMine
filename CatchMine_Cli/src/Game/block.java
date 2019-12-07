package Game;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class block extends JLayeredPane {

	private boolean blockState; // 블럭이 선택 되었는지 판단 여부
	private int x; // x 축 좌표
	private int y; // y 축 좌표
	ImageIcon image; // 블럭의 이미지

	JLabel blockLabel;
	JLabel tileLabel;
	// ================= 블럭 이미지 ================ //
	ImageIcon teduriImage = new ImageIcon("image/GameObject/teduri.png");
	ImageIcon blockImage = new ImageIcon("image/GameObject/block1.png");
	ImageIcon tileImage = new ImageIcon("image/GameObject/tile.png");
	// ================= 블럭 이미지 ================ //
	// 블럭 자신

//	private int mineCount; // 남은 지뢰에 대한 갯수를 제공

	public block() {
//		bl = new block[18][35];
	}

	// 현재의 블록이 선택되었는지 판단
	public void setBlockState(boolean bool) {
		this.blockState = bool;
	}

	public boolean getBlockState() {
		return blockState;
	}

	// block을 생성할때 사용
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

	// 타일 위에 얹어진 블럭을 지우는 메소드,
	public void removeBlock(block bl) {
		bl.blockLabel.setIcon(null);
	}

	public void setImage() {
//		this.image = image;
		blockLabel.setIcon(tileImage);
	}

}
