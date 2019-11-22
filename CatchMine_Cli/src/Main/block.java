package Main;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class block extends JPanel {

	private int hp; // 블럭 당 Hp
	private int x; // x 축 좌표
	private int y; // y 축 좌표
	ImageIcon image; // 블럭의 이미지

	public block() {
	}


	public block(ImageIcon image,int hp ,int x, int y) {
		this.x = x;
		this.y = y;
		this.image = image;
		this.hp = hp;

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
	
	// 블럭 존재 여부 판단
	public boolean isBlock() {
		if(this.getHp() > 0)
			return true;
		
		return false;
	}
	

	public int getHp() {
		return hp;
	}


	public void setHp(int hp) {
		this.hp = hp;
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
