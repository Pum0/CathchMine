package Main;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class block extends JPanel {

	private int x; // x Ãà ÁÂÇ¥
	private int y; // y Ãà ÁÂÇ¥
	
	public block(ImageIcon image, int x, int y) {
		this.x = x;
		this.y = y;
		
		this.setSize(40, 40);
		this.setLayout(new GridLayout(0,1));
		
		super.setLocation(x,y);
		
		JLabel label = new JLabel();
		
		label.setIcon(image);
		label.setLocation(0, 0);
		
	
		this.add(label);

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
