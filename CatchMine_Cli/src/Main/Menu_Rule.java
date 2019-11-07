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
	JLabel backMoveLabel, leftMoveLabel, rightMoveLabel, frontMoveLabel, KeyLabel;
	ImageIcon backMoveIcon, leftMoveIcon, rightMoveIcon, frontMoveIcon, KeyIcon;
	Image backMoveImg, backMoveKey;
	JButton backButton;
	Design de = new Design();

	public Menu_Rule() {

		// img = icon.getImage();
		// backMoveimg = new JLabel() {
		// public void paint(Graphics g) {
		// g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		// }
		// };

		setSize(400, 600);
		setLayout(null);

		mainPanel = new JPanel();
		mainPanel.setBounds(40, 40, 300, 400);
		mainPanel.setLayout(null);

		backButton = new JButton("뒤로가기", de.setButton());
		backButton.setHorizontalTextPosition(SwingConstants.CENTER);
		backButton.setFont(de.font);
		backButton.setBounds(140, 460, 100, 40);

		backMoveIcon = new ImageIcon("image/gif/Back_Move.gif");
		backMoveLabel = new JLabel(backMoveIcon);
		backMoveLabel.setBounds(40, 0, 40, 40);

		leftMoveIcon = new ImageIcon("image/gif/Left_Move.gif");
		leftMoveLabel = new JLabel(leftMoveIcon);
		leftMoveLabel.setBounds(0, 45, 40, 40);

		frontMoveIcon = new ImageIcon("image/gif/Front_Move.gif");
		frontMoveLabel = new JLabel(frontMoveIcon);
		frontMoveLabel.setBounds(40, 45, 40, 40);

		rightMoveIcon = new ImageIcon("image/gif/Right_Move.gif");
		rightMoveLabel = new JLabel(rightMoveIcon);
		rightMoveLabel.setBounds(80, 45, 40, 40);

		KeyIcon = new ImageIcon("image/moveKey.png");
		KeyLabel = new JLabel(KeyIcon);
		KeyLabel.setBounds(180, 0, 120, 120);

		add(backButton);
		add(mainPanel);
		mainPanel.add(backMoveLabel);
		mainPanel.add(leftMoveLabel);
		mainPanel.add(frontMoveLabel);
		mainPanel.add(rightMoveLabel);
		mainPanel.add(KeyLabel);
		add(de.setBackground());
	}
}
