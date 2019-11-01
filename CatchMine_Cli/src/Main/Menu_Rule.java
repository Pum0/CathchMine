package Main;


import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Menu_Rule extends JPanel {
	JPanel mainPanel;
	JLabel backMoveimg;
	ImageIcon icon;
	Image img;
	JButton backButton;
	Design de = new Design();

	public Menu_Rule() {
		setSize(400, 600);
		setLayout(null);

		mainPanel = new JPanel();
		mainPanel.setBounds(40, 40, 300, 400);
		mainPanel.setLayout(null);

		backButton = new JButton("뒤로가기", de.setButton());
		backButton.setHorizontalTextPosition(SwingConstants.CENTER);
		backButton.setFont(de.font);
		backButton.setBounds(140, 460, 100, 40);
		
		icon = new ImageIcon("image/gif/1P_Back_Move.gif");
		backMoveimg = new JLabel(icon);
//		img = icon.getImage();
//		backMoveimg = new JLabel() {
//			public void paint(Graphics g) {
//				g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
//			}
//		};
		backMoveimg.setBounds(0, 0, 40, 40);
		
		
		add(backButton);
		add(mainPanel);
		mainPanel.add(backMoveimg);
		add(de.setBackground());
	}
}
