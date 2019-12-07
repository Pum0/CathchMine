package Game;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class mine extends JPanel {

	private boolean[][] minePosition;
	private int mineCount;
	private int x, y; // ������ ��ǥ

	// ���� �̹���
	ImageIcon mineImage = new ImageIcon("image/GameObject/Mine.png");
	JLabel mineLabel;

	public mine() {
	}

	public mine(int x, int y) {
		this.setSize(40, 40);
		this.setLayout(new GridLayout(0, 1));
		this.setLocation(x, y);
		mineLabel = new JLabel();
		mineLabel.setIcon(mineImage);

		add(mineLabel);
	}

	public int getMineCount(boolean[][] mp, int x, int y) { // ������ ������ ��ȯ
		int count = 0;
		int width = x;
		int height = y;

		for (int i = width - 1; i <= width + 1; i++) {
			for (int j = height - 1; j <= height + 1; j++) {
				if (isMine(mp, i, j)) // ���ڰ� ���� �� ������ ������ ������Ŵ
					count++;
			}
		}

		return count;
	}

	public boolean isMine(boolean[][] minePosi, int x, int y) { // ���� ��ǥ�� ���ڰ� �ִ��� �Ǵ�, ������ �׾�� �Ǵϱ񸸵�

		return minePosi[x][y];
	}

}
