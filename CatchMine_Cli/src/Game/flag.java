package Game;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

class flag extends JPanel {
	ImageIcon flagImage = new ImageIcon("image/GameObject/RedFlag.png");
	ImageIcon Q_Image = new ImageIcon("image/GameObject/Q_Mark.png");

	ImageIcon[] flagList = { null, flagImage, Q_Image };

	JLabel flagIcon;
	int flagShape = 0; // 0이면 x 1이면 깃발 2면 ?

	public flag() {
		this.setSize(40, 40);
		this.setLayout(new GridLayout(0, 1));
		this.setOpaque(false);
		this.flagShape = 0; // 기본은 x(없다)
		flagIcon = new JLabel();

		this.add(flagIcon);
	}

//	public flag(int i) {
//
//	}
	public void setFlagShape(int flagShape) {
		this.flagShape = flagShape;
	}

	public int getFlagShape() {
		return flagShape;
	}

	public boolean isFlag(boolean[][] f_bool, int x, int y) {
		return f_bool[x][y];
	}

	public void setFlagImage(int i) {
		if (i == 1)
			flagIcon.setIcon(flagImage);
		else if (i == 2)
			flagIcon.setIcon(Q_Image);
		else
			flagIcon.setIcon(null);

	}

}