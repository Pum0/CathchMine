package Game;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class mine extends JPanel {

//	private boolean[][] minePosition;
	private int mineCount;
	private int x, y; // Áö·ÚÀÇ ÁÂÇ¥

	// Áö·Ú ÀÌ¹ÌÁö
	ImageIcon mineImage = new ImageIcon("image/GameObject/Mine.png");
	ImageIcon bomeImage = new ImageIcon("image/GameObject/Explosion.png");
	JLabel mineLabel;

	public mine() {
	}

	public mine(int i) {
		this.setSize(40, 40);
		this.setLayout(new GridLayout(0, 1));
		this.setOpaque(false);
		mineLabel = new JLabel();
		if (i == 0)
			mineLabel.setIcon(mineImage);
		else
			mineLabel.setIcon(bomeImage);

		add(mineLabel);
	}

	public int getMineCount(boolean[][] mp, int x, int y) { // Áö·ÚÀÇ °¹¼ö¸¦ ¹ÝÈ¯
		int count = 0;
		int width = x;
		int height = y;

		for (int i = width - 1; i <= width + 1; i++) {
			for (int j = height - 1; j <= height + 1; j++) {

				if (isMine(mp, i, j)) // Áö·Ú°¡ ÀÖÀ» ½Ã Áö·ÚÀÇ °¹¼ö¸¦ Áõ°¡½ÃÅ´
					count++;
			}
		}

		return count;
	}

	public boolean isMine(boolean[][] minePosi, int x, int y) { // ÇöÀç ÁÂÇ¥¿¡ Áö·Ú°¡ ÀÖ´ÂÁö ÆÇ´Ü, ÀÖÀ¸¸é Á×¾î¾ß µÇ´Ï±ñ¸¸µë

		return minePosi[x][y];
	}

}
