package Scenes;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import Grahpics.Design;
import MyListener.Action;
import MyListener.Key;
import MyListener.Mouse;

public class Menu_Rule extends JPanel {
	JPanel mainPanel;
	JLabel backMoveLabel, leftMoveLabel, rightMoveLabel, frontMoveLabel, keyLabel, AKeyLabel, SKeyLabel, DKeyLabel,
			JumpLabel, FlagLabel, QMLable, SKeyLable2, SKeyLable3, ItemLabel, ItemLabel2;
	ImageIcon backMoveIcon, leftMoveIcon, rightMoveIcon, frontMoveIcon, keyIcon, AKeyIcon, SKeyIcon, DKeyIcon, JumpIcon,
			FlagIcon, QMIcon, SKeyIcon2, SKeyIcon3, ItemIcon, ItemIcon2;

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

		backMoveIcon = new ImageIcon("image/Key_Image/Back_Move.gif");
		backMoveLabel = new JLabel(backMoveIcon);
		backMoveLabel.setBounds(50, 20, 40, 40);

		leftMoveIcon = new ImageIcon("image/Key_Image/Left_Move.gif");
		leftMoveLabel = new JLabel(leftMoveIcon);
		leftMoveLabel.setBounds(10, 65, 40, 40);

		frontMoveIcon = new ImageIcon("image/Key_Image/Front_Move.gif");
		frontMoveLabel = new JLabel(frontMoveIcon);
		frontMoveLabel.setBounds(50, 65, 40, 40);

		rightMoveIcon = new ImageIcon("image/Key_Image/Right_Move.gif");
		rightMoveLabel = new JLabel(rightMoveIcon);
		rightMoveLabel.setBounds(90, 65, 40, 40);

		keyIcon = new ImageIcon("image/Key_Image/wasd.png");
		keyLabel = new JLabel(keyIcon);
		keyLabel.setBounds(150, 20, 120, 120);

//		-----------------------------------------------------------------

		AKeyIcon = new ImageIcon("image/Key_Image/A(36x36).png");
		AKeyLabel = new JLabel(AKeyIcon);
		AKeyLabel.setBounds(74, 135, 36, 36);

		JumpIcon = new ImageIcon("image/gif/jump.gif");
		JumpLabel = new JLabel(JumpIcon);
		JumpLabel.setBounds(10, 130, 40, 40);

		SKeyIcon = new ImageIcon("image/Key_Image/S(36x36).png");
		SKeyLabel = new JLabel(SKeyIcon);
		SKeyLabel.setBounds(74, 201, 36, 36);

		FlagIcon = new ImageIcon("image/GameObject/RedFlag.png");
		FlagLabel = new JLabel(FlagIcon);
		FlagLabel.setBounds(10, 201, 40, 40);

		QMIcon = new ImageIcon("image/GameObject/Q_Mark.png");
		QMLable = new JLabel(QMIcon);
		QMLable.setBounds(134,201,40,40);
		
		SKeyIcon2 = new ImageIcon("image/Key_Image/S(36x36).png");
		SKeyLable2 = new JLabel(SKeyIcon2);
		SKeyLable2.setBounds(194,201,36,36);
		
		SKeyIcon3 = new ImageIcon("image/Key_Image/S(36x36).png");
		SKeyLable3 = new JLabel(SKeyIcon3);
		SKeyLable3.setBounds(234,201,36,36);
		
		DKeyIcon = new ImageIcon("image/Key_Image/D(36x36).png");
		DKeyLabel = new JLabel(DKeyIcon);
		DKeyLabel.setBounds(124, 267, 36, 36);

		ItemIcon = new ImageIcon("image/GameObject/Item/HP_Potion.gif");
		ItemLabel = new JLabel(ItemIcon);
		ItemLabel.setBounds(10, 267, 40, 40);

		ItemIcon2 = new ImageIcon("image/GameObject/Item/Radar.gif");
		ItemLabel2 = new JLabel(ItemIcon2);
		ItemLabel2.setBounds(64, 267, 40, 40);

		mainPanel.add(backMoveLabel);
		mainPanel.add(leftMoveLabel);
		mainPanel.add(frontMoveLabel);
		mainPanel.add(rightMoveLabel);
		mainPanel.add(keyLabel);
		mainPanel.add(AKeyLabel);
		mainPanel.add(SKeyLabel);
		mainPanel.add(DKeyLabel);
		mainPanel.add(JumpLabel);
		mainPanel.add(FlagLabel);
		mainPanel.add(QMLable);
		mainPanel.add(SKeyLable2);
		mainPanel.add(SKeyLable3);
		mainPanel.add(ItemLabel);
		mainPanel.add(ItemLabel2);
		add(backButton);
		add(panelPane);

		// 게임 룰 패널
		backButton.addActionListener(al);
		backButton.addMouseListener(ml);

		add(de.setBackground());
	}
}
