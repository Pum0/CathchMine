package Main;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class player extends JPanel {

	public void paintComponent(Graphics g) {
		g.setColor(new Color(180,55,200));
		g.fillOval(0, 0, 40, 40);

	}

	public player() {

		this.setSize(40, 40);

	}

}
