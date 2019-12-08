package Game;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class flag extends JPanel {
	ImageIcon flagImage = new ImageIcon("image/GameObject/RedFlag.png");
	ImageIcon Q_Image = new ImageIcon("image/GameObject/Q_Mark.png");

	ImageIcon[] flagList = { flagImage, Q_Image };

	JLabel flagIcon;

	private boolean flagState;

	public flag() {
		this.setSize(40, 40);
		this.setLayout(new GridLayout(0, 1));
		this.setOpaque(false);
		this.flagState = false; // 기본은 꽂혀있지않음
		flagIcon = new JLabel();
		flagIcon.setIcon(flagImage);

		this.add(flagIcon);
	}

//	public flag(int i) {
//
//	}

	public boolean isFlag(boolean[][] f_bool, int x, int y) {
		return f_bool[x][y];
	}

	public void setFlagState(boolean bool) {
		this.flagState = bool;
	}

	public boolean getFlagState() {
		return this.flagState;
	}

	public void setFlagImage() {
		this.flagIcon.setIcon(null);
	}

	public void setFlagImage(int i) {
		this.flagIcon.setIcon(flagList[i]);
	}

}