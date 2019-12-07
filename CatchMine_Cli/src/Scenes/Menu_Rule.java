package Scenes;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import Main.Design;
import MyListener.Action;
import MyListener.Key;
import MyListener.Mouse;

public class Menu_Rule extends JPanel {
	JPanel mainPanel;
	JLabel backMoveLabel, leftMoveLabel, rightMoveLabel, frontMoveLabel, keyLabel;
	ImageIcon backMoveIcon, leftMoveIcon, rightMoveIcon, frontMoveIcon, keyIcon;

	JScrollPane panelPane;
	
	public JButton backButton;

	Action al = new Action();
	Key kl = new Key();
	Mouse ml = new Mouse();
	Design de = new Design();

	public Menu_Rule() {

		setSize(400, 600);
		setLayout(null);

		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBorder(de.setBorder());
		Dimension size = new Dimension();
		size.setSize(280, 400);
		mainPanel.setPreferredSize(size);
		
		panelPane = new JScrollPane(mainPanel);
		panelPane.setBounds(40, 40, 300, 400);
		
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

		mainPanel.add(backMoveLabel);
		mainPanel.add(leftMoveLabel);
		mainPanel.add(frontMoveLabel);
		mainPanel.add(rightMoveLabel);
		mainPanel.add(keyLabel);
		add(backButton);
		add(panelPane);

		// 게임 룰 패널
		backButton.addActionListener(al);
		backButton.addMouseListener(ml);

		add(de.setBackground());
	}
}
