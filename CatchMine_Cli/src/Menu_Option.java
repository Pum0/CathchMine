import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Menu_Option extends JPanel /* implements ActionListener */ {
	JComboBox<String> music;
	JLabel selectMusic, volumeValue;
	JSlider musicVolume; // 슬라이더
	JPanel box;

	private String musics[] = { "배경음 1", "배경음 2", "배경음 3", "배경음 4" };

	public Menu_Option() {
		setSize(400, 600);
		setLayout(null);

		selectMusic = new JLabel("음악 선택"); // 음악선택 레이블
		add(selectMusic);
		selectMusic.setBounds(50, 100, 100, 20); // setBounds() 크기 위치 설정

		music = new JComboBox<String>(musics); // 배경음 선택 콤보박스
		music.setSelectedIndex(0); // 맨 처음 선택된게 0번 인덱스
		// music.addActionListener(this);
		add(music);
		music.setBounds(130, 100, 200, 20);

		musicVolume = new JSlider(0, 100); // 슬라이더
		musicVolume.setMajorTickSpacing(50); // 큰 눈금 간격
		// musicVolume.setMinorTickSpacing(1); // 작은 눈금 간격
		musicVolume.setPaintTicks(true); // 눈금 표시
		musicVolume.setPaintLabels(true); // 값을 레이블로 표시
		add(musicVolume);
		musicVolume.setBounds(45, 120, 300, 50);

		volumeValue = new JLabel("50"); // 볼륨값 표시
		volumeValue.setBounds(350, 80, 100, 100);
		add(volumeValue);
		
		box = new JPanel() {	//패널에다가 페인트 추가해서 사각형 생성
			@Override
			public void paint(Graphics g) {
				g.drawRoundRect(0, 0, 30, 15, 5, 5);
			}
		};
		box.setBounds(348, 121, 100, 100);
		add(box);
		
		musicVolume.addChangeListener(new ChangeListener() {	//슬라이더 값을 받아와서 musicVolume 레이블에 텍스트 셋
			@Override
			public void stateChanged(ChangeEvent e) {
				volumeValue.setText(" " + musicVolume.getValue());

			}
		});

	}

}
