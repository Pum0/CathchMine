package Game;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game_MenuPanel extends JPanel {
	// 메뉴에 있어야 할 목록 가진 아이템, 사용가능한 깃발 갯수, 멀티면 유저 목록
	final static int MENUXSIZE = 1400;
	final static int MENUYSIZE = 100;

	private ImageIcon statusImage = new ImageIcon("image/status.png");
	private JLabel statIcon;

	// 게임 위쪽 메뉴 UI 패널
	private JPanel menuPanel; // 타이머 패널
	private JLabel timeLabel; // 시간이 출력되는 레이블

	// 게임 플레이 시간
	final static int time = 0;

	singleGame sG = new singleGame(); // 싱글게임 클래스의 필드를 사용하기위해서 사용

	JLabel mineLabel;

	public Game_MenuPanel() {
		setLayout(null);
		setSize(MENUXSIZE, MENUYSIZE);
		this.setBackground(Color.BLUE);
		statIcon = new JLabel();
		statIcon.setIcon(statusImage);

		menuPanel = new JPanel();
		menuPanel.setLayout(null);
		menuPanel.setBounds(0, 0, MENUXSIZE, MENUYSIZE);
		menuPanel.setOpaque(false);

		timeLabel = new JLabel(timer(time));
		menuPanel.add(timeLabel);

		timeLabel.setFont(new Font("빙그레체", Font.BOLD, 50));
		timeLabel.setBounds(650, 0, 200, 100);

		mineLabel = new JLabel(sG.getMineCount() + "");
		menuPanel.add(mineLabel);
		
		mineLabel.setFont(new Font("빙그레체", Font.BOLD, 38));
		mineLabel.setBounds(540, 0, 200, 100);

		new timerThread().start();

		menuPanel.setLocation(0, 0);
//		setLocation(20, 20);

		setOpaque(false);

		add(menuPanel);
		add(statIcon);
		statIcon.setBounds(0, 0, MENUXSIZE, MENUYSIZE);

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
			int count = 0;
			while (true) {
				count++;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("timerThread");
					System.out.println(e.toString());
				}
				timeLabel.setText("");
				timeLabel.setText(timer(count));

			}
		}
	}

}
