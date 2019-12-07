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
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Main.Design;
import MyListener.Action;
import MyListener.Key;
import MyListener.Mouse;

public class Menu_Option extends JPanel /* implements ActionListener */ {
	public JComboBox<String> music;
	JLabel selectMusic, volumeValue;
	JSlider musicVolume; // 슬라이더
	JPanel mainPanel;
	JPanel box;
	public JButton backButton;

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

		musicVolume = new JSlider(0, 100); // 슬라이더
		musicVolume.setMajorTickSpacing(50); // 큰 눈금 간격
		musicVolume.setPaintTicks(true); // 눈금 표시
		musicVolume.setPaintLabels(true); // 값을 레이블로 표시
		musicVolume.setForeground(Color.BLACK);
		musicVolume.setOpaque(false);
		musicVolume.setFont(de.setFont(14));
		mainPanel.add(musicVolume);
		musicVolume.setBounds(25, 80, 250, 50);

		volumeValue = new JLabel("50"); // 볼륨값 표시
		volumeValue.setForeground(Color.BLACK);
		volumeValue.setBounds(135, 10, 100, 100);
		volumeValue.setFont(de.setFont(14));
		mainPanel.add(volumeValue);

		box = new JPanel() { // 패널에다가 페인트 추가해서 사각형 생성
			@Override
			public void paint(Graphics g) {
				g.drawRoundRect(0, 20, 35, 20, 5, 5);
			}
		};
		box.setBounds(130, 30, 100, 100);
		box.setForeground(Color.BLACK);
		mainPanel.add(box);
		
		backButton = new JButton("뒤로가기", new ImageIcon("image/button/100x40.png"));
		backButton.setHorizontalTextPosition(SwingConstants.CENTER);
		backButton.setBounds(140, 460, 100, 40);
		backButton.setBorderPainted(false);
		add(backButton);

		musicVolume.addChangeListener(new ChangeListener() { // 슬라이더 값을 받아와서 musicVolume 레이블에 텍스트 셋
			@Override
			public void stateChanged(ChangeEvent e) {
				volumeValue.setText(""+musicVolume.getValue());
			}
		});

		// 게임 옵션 패널
				backButton.addActionListener(al);
				backButton.addMouseListener(ml);
				music.addActionListener(al);
		
		add(de.setBackground());
	}

}
