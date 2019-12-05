package Game;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game_MenuPanel extends JPanel {
	final static int MENUXSIZE = 1400;
	final static int MENUYSIZE = 120;

	// ================= 내부 옵션 이미지 ================ //

	ImageIcon menuImage = new ImageIcon("image/imsiMenu.png");

	// 게임 위쪽 메뉴 UI 패널
	private JPanel timerPanel; // 타이머 패널
	private JLabel timeLabel; // 시간이 출력되는 레이블

	// 게임 플레이 시간
	final static int time = 0;

	// 게임 메뉴 초기화
	// 메뉴 패널 초기구성
	public Game_MenuPanel() {
		setBackground(Color.BLUE);

		timerPanel = new JPanel();

		timeLabel = new JLabel(timer(time));
		timeLabel.setFont(new Font("빙그레체", Font.BOLD, 30));
		timeLabel.setLocation(1000, 40);

		timerPanel.setSize(180, 50);
		timerPanel.setOpaque(false);

		timerPanel.add(timeLabel);

		new timerThread().start();

		timerPanel.setLocation(1000, 15);

		setLayout(null);

		setSize(MENUXSIZE, MENUYSIZE);
		setLocation(20, 20);

		add(timerPanel);

	}

	// 플레이 타임을 00:00 형식으로 출력
	public String timer(int time) {
		int min = time / 60;
		int sec = time % 60;

		return String.format("%d : %02d", min, sec);
	}

	// 시간이 흘러가게 설정
	class timerThread extends Thread {

		@Override
		public void run() {
			for (int i = 0;; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("timerThread");
					System.out.println(e.toString());
				}
				timeLabel.setText("");
				timeLabel.setText(timer(i));

			}
		}
	}

}
