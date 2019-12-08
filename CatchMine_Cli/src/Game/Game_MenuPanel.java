package Game;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game_MenuPanel extends JPanel {
	// 메뉴에 있어야 할 목록 가진 아이템, 사용가능한 깃발 갯수, 멀티면 유저 목록
	// 이 클래스에서는 진행되고 있는 게임에서 값을 받아와 단순히 진행도(지뢰의 갯수, 깃발의 갯수)와 캐릭터의 상태(체력, 아이템)를 알려준다.
	final static int MENUXSIZE = 1400;
	final static int MENUYSIZE = 100;

	private ImageIcon statusImage = new ImageIcon("image/status.png");
	private JLabel statIcon;

	private static ImageIcon p_hp0 = new ImageIcon("image/GameObject/Heart 0.png");
	private static ImageIcon p_hp1 = new ImageIcon("image/GameObject/Heart 1.png");
	private static ImageIcon p_hp2 = new ImageIcon("image/GameObject/Heart 2.png");
	private static ImageIcon p_hp3 = new ImageIcon("image/GameObject/Heart 3.png");
	private static ImageIcon[] hpImageList = { p_hp0, p_hp1, p_hp2, p_hp3 };

	// 게임 위쪽 메뉴 UI 패널
	private JPanel menuPanel; // 메뉴 전체에 컴포넌트를 담을 패널
	private JLabel timeLabel; // 시간이 출력되는 레이블
	private JLabel mineLabel; // 이 게임에 있는 지뢰의 갯수를 명시해놓는 레이블
	private JLabel itemPocketLabel; // 가진 아이템을 메뉴창에 표시해줄 이미지를 그릴 레이블
	private static JLabel flagLabel;
	private static JLabel hpLabel; // player의 Hp를 표시해주는 이미지

	// 게임 플레이 시간
	final static int time = 0;

	singleGame sG = new singleGame(); // 싱글게임 클래스의 필드를 사용하기위해서 사용

	public Game_MenuPanel() {
		setLayout(null);
		setSize(MENUXSIZE, MENUYSIZE);
		this.setBackground(Color.BLUE);
		statIcon = new JLabel();
		statIcon.setIcon(statusImage);

		menuPanel = new JPanel(); // 메뉴 패널 생성
		menuPanel.setLayout(null); // 절대좌표를 쓰기 위해 레이아웃을 null로 맞춰줌
		menuPanel.setBounds(0, 0, MENUXSIZE, MENUYSIZE);
		menuPanel.setOpaque(false);

		timeLabel = new JLabel(timer(time)); // 분:초 형식으로 Label에 텍스트를 넣음
		menuPanel.add(timeLabel); // 메뉴 패널에 추가

		timeLabel.setFont(new Font("빙그레체", Font.BOLD, 50));
		timeLabel.setBounds(850, 5, 200, 100);

		mineLabel = new JLabel(sG.getMineCount() + "");
		menuPanel.add(mineLabel);

		mineLabel.setFont(new Font("빙그레체", Font.BOLD, 40));
		mineLabel.setBounds(560, 2, 200, 100);

		flagLabel = new JLabel(sG.getFlagCount() + "");
		flagLabel.setFont(new Font("빙그레체", Font.BOLD, 40));
		flagLabel.setBounds(353, 2, 200, 100);

		menuPanel.add(flagLabel);

		hpLabel = new JLabel();
		hpLabel.setIcon(p_hp3);
		hpLabel.setBounds(30, 26, 174, 60);

		menuPanel.add(hpLabel);

		new timerThread().start(); // 생성과 동시에 타이머를 실행시킨다.

		menuPanel.setLocation(0, 0);

		setOpaque(false);
		add(menuPanel);
		add(statIcon);
		statIcon.setBounds(0, 0, MENUXSIZE, MENUYSIZE);

	}

	public static void sethpImage(int i) {
		hpLabel.setIcon(hpImageList[i]);
	}

	public static void setFlagCount(int i) {
		flagLabel.setText(i + "");
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
				timeLabel.setText(timer(count));

			}
		}
	}

}
