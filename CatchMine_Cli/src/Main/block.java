package Main;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class block extends JPanel {

	private int hp; // �� �� Hp
	private int x; // x �� ��ǥ
	private int y; // y �� ��ǥ
	ImageIcon image; // ���� �̹���
	JLabel label;

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

		label = new JLabel();

		label.setIcon(image);
		label.setLocation(0, 0);

		this.add(label);

	}
	
	
	// Ư�� ��ǥ�� �� �̹����� �ҽ������� ������ִ� �޼ҵ�           
	// Ư�� ������ ���������� �Ϸ��� ������� ������ �ʿ� ���� ���� ���� ����
	public String getImageName() {
		String str = image.getDescription();

		String imageName = str.substring(6, str.length() - 4);
		return imageName;
	}
	
	// �� ���� ���� �Ǵ�
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



	public void setImage(ImageIcon image) {
		this.image = image;

		label.setIcon(image);
//		this.repaint();
	}
	
	

}
