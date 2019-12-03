package Main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Menu_Rule extends JPanel {
	JPanel mainPanel;
	JLabel backMoveLabel, leftMoveLabel, rightMoveLabel, frontMoveLabel, keyLabel,
			backAttackLabel, leftAttackLabel, rightAttackLabel, frontAttackLabel, keyLabel2 ;
	ImageIcon backMoveIcon, leftMoveIcon, rightMoveIcon, frontMoveIcon, keyIcon,
			backAttackIcon, leftAttackIcon, rightAttackIcon, frontAttackIcon, keyIcon2;
	
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
		mainPanel.setBorder(de.setBorder());
		
		backButton = new JButton("뒤로가기", new ImageIcon("image/button/100x40.png"));
		backButton.setHorizontalTextPosition(SwingConstants.CENTER);
		backButton.setFont(de.setFont(14));
		backButton.setBorderPainted(false);
		backButton.setBounds(140, 460, 100, 40);

		backMoveIcon = new ImageIcon("image/gif/Back_Move.gif");
		backMoveLabel = new JLabel(backMoveIcon);
		backMoveLabel.setBounds(60, 20, 40, 40);

		leftMoveIcon = new ImageIcon("image/gif/Left_Move.gif");
		leftMoveLabel = new JLabel(leftMoveIcon);
		leftMoveLabel.setBounds(20, 65, 40, 40);

		frontMoveIcon = new ImageIcon("image/gif/Front_Move.gif");
		frontMoveLabel = new JLabel(frontMoveIcon);
		frontMoveLabel.setBounds(60, 65, 40, 40);

		rightMoveIcon = new ImageIcon("image/gif/Right_Move.gif");
		rightMoveLabel = new JLabel(rightMoveIcon);
		rightMoveLabel.setBounds(100, 65, 40, 40);

		keyIcon = new ImageIcon("image/moveKey.png");
		keyLabel = new JLabel(keyIcon);
		keyLabel.setBounds(160, 20, 120, 120);
		
		
		
		backAttackIcon = new ImageIcon("image/gif/Back_AttackMotion.gif");
		backAttackLabel = new JLabel(backAttackIcon);
		backAttackLabel.setBounds(60, 120, 40, 40);

		leftAttackIcon = new ImageIcon("image/gif/Left_AttackMotion.gif");
		leftAttackLabel = new JLabel(leftAttackIcon);
		leftAttackLabel.setBounds(20, 165, 40, 40);

		frontAttackIcon = new ImageIcon("image/gif/Front_AttackMotion.gif");
		frontAttackLabel = new JLabel(frontAttackIcon);
		frontAttackLabel.setBounds(60, 165, 40, 40);

		rightAttackIcon = new ImageIcon("image/gif/Right_AttackMotion.gif");
		rightAttackLabel = new JLabel(rightAttackIcon);
		rightAttackLabel.setBounds(100, 165, 40, 40);
		
		keyIcon2 = new ImageIcon("image/attackKey.png");
		keyLabel2 = new JLabel(keyIcon2);
		keyLabel2.setBounds(160, 120, 120, 120);

		add(backButton);
		add(mainPanel);
		mainPanel.add(backMoveLabel);
		mainPanel.add(leftMoveLabel);
		mainPanel.add(frontMoveLabel);
		mainPanel.add(rightMoveLabel);
		mainPanel.add(keyLabel);
		
		mainPanel.add(backAttackLabel);
		mainPanel.add(leftAttackLabel);
		mainPanel.add(frontAttackLabel);
		mainPanel.add(rightAttackLabel);
		mainPanel.add(keyLabel2);
		
		add(de.setBackground());
	}
}
