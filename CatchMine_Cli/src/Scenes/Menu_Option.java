package Scenes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Grahpics.Design;
import MyListener.Action;
import MyListener.Key;
import MyListener.Mouse;

public class Menu_Option extends JPanel /* implements ActionListener */ {
	public JComboBox<String> music;
	JLabel selectMusic, volumeValue, IPset;
	public JTextField IPfield;
	JPanel mainPanel;
	public JButton setIP, backButton;

	private String musics[] = { "배경음 1", "배경음 2", "배경음 3", "배경음 4" };

	Action al = new Action();
	Key kl = new Key();
	Mouse ml = new Mouse();
	Design de = new Design();

	public Menu_Option() {
		setSize(400, 600);
		setLayout(null);

		mainPanel = new JPanel();
		mainPanel.setBounds(40, 40, 300, 400);
		mainPanel.setLayout(null);
		mainPanel.setBorder(de.setBorder());
		add(mainPanel);

		selectMusic = new JLabel("음악 선택"); // 음악선택 레이블
		selectMusic.setForeground(Color.BLACK); // 폰트색 화이트
		selectMusic.setFont(de.setFont(14));
		mainPanel.add(selectMusic); // 추가
		selectMusic.setBounds(30, 20, 100, 20); // setBounds() 크기 위치 설정

		music = new JComboBox<String>(musics); // 배경음 선택 콤보박스
		music.setBorder(new LineBorder(Color.DARK_GRAY, 1));
		music.setSelectedIndex(0); // 맨 처음 선택된게 0번 인덱스
		music.setFont(de.setFont(10));
		mainPanel.add(music);
		music.setBounds(110, 20, 150, 20);

		// --------------------------------------------------------
		IPset = new JLabel("IP 주소 입력");
		IPset.setBounds(100, 310, 150, 20);
		IPset.setFont(de.setFont(18));

		IPfield = new JTextField(10);
		IPfield.setFont(de.setFont(18));
		IPfield.setBounds(25, 350, 150, 30);
		setIP = new JButton("적용", new ImageIcon("image/button/90x30.png"));
		setIP.setBorderPainted(false);
		setIP.setHorizontalTextPosition(SwingConstants.CENTER);
		setIP.setBounds(185, 350, 90, 30);
		// --------------------------------------------------------

		mainPanel.add(IPset);
		mainPanel.add(IPfield);
		mainPanel.add(setIP);

		backButton = new JButton("뒤로가기", new ImageIcon("image/button/100x40.png"));
		backButton.setHorizontalTextPosition(SwingConstants.CENTER);
		backButton.setBounds(140, 460, 100, 40);
		backButton.setBorderPainted(false);
		add(backButton);

		// 게임 옵션 패널
		setIP.addActionListener(al);
		setIP.addMouseListener(ml);
		backButton.addActionListener(al);
		backButton.addMouseListener(ml);
		music.addActionListener(al);

		add(de.setBackground());
	}

}
