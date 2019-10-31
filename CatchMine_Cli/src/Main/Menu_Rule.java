package Main;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Menu_Rule extends JPanel {
	
	Design de = new Design();

	public Menu_Rule() {
		setSize(400, 600);
		setLayout(null);

//		icon = new ImageIcon("src/Main/rule_Image/4.png");
//		img = icon.getImage();
//
//		jp = new JPanel() {
//			public void drawGamePanel() {
//				img = Toolkit.getDefaultToolkit().createImage("src/Main/rule_Image/4.png");
//				jp.drawImage(img,0,0,null);
//			}
//		};
//
//		jp.setBounds(0, 0, 100, 100);
//		add(jp);

		add(de.setBackground());
	}
}
