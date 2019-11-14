package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class singleGame extends JFrame implements KeyListener {
	final static int FRAMEXSIZE = 1440;
	final static int FRAMEYSIZE = 900;

	final static int GAMEXSIZE = 1400;
	final static int GAMEYSIZE = 720;

	final static int MENUXSIZE = 1400;
	final static int MENUYSIZE = 80;

	// 게임 플레이 시간
	final static int time = 0;

	// 실제 게임이 플레이 되는 패널 brjtn 1
	private JPanel gamePanel;

	// 게임 위쪽 메뉴 UI 패널
	private JPanel menuPanel; // 메뉴 틀
	private JButton optionButton; // 옵션 버튼
	private JPanel timerPanel; // 타이머 패널
	private JLabel timeLabel; // 시간이 출력되는 레이블

	// ================= 이미지 ================ //
	ImageIcon backImage = new ImageIcon("image/back.png");
	// ================= 블럭 이미지 ================ //
	ImageIcon teduriImage = new ImageIcon("image/imsiTeduri.png");
	ImageIcon blockImage = new ImageIcon("image/imsiBlock.png");
	// ================= 블럭 이미지 ================ //

	// ================= 내부 옵션 이미지 ================ //
	ImageIcon optionImage = new ImageIcon("image/option.png");
	ImageIcon menuImage = new ImageIcon("image/imsiMenu.png");
	// ================= 이미지 ================ //

	JPanel p;

	public singleGame() {
		setLayout(null);

		JLabel lab = new JLabel();
		lab.setSize(FRAMEXSIZE, FRAMEYSIZE);
		lab.setIcon(backImage);

		gamePanel = new JPanel();
		menuPanel = new JPanel();

		initGamePanel();
		initMenuPanel();

		this.add(gamePanel);
		this.add(menuPanel);
		this.add(lab);

		addKeyListener(this);
		
		setTitle("게임");
		setSize(FRAMEXSIZE, FRAMEYSIZE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyChar());

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A)
			System.out.println(e.getKeyChar());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println(e.getKeyCode());
	}

	// 블럭 리스트 채워넣기
	public void initBlock(ArrayList<block> list) {
		int x = 0;
		int y = 0;

		for (int i = 0; i < 35; i++) {
			for (int j = 0; j < 18; j++) {

				if ((i == 0 || j == 0) || (i == 34 || j == 17)) {
					list.add(new block(teduriImage, y, x));

				}

				else
					list.add(new block(blockImage, y, x));

				x += 40;

			}
			x = 0;
			y += 40;

		}
	}

	int playerX = 40;
	int playerY = 40;

	// 게임 창 초기화
	public void initGamePanel() {
		gamePanel.setLayout(null);
		gamePanel.setSize(1400, 720);
		gamePanel.setBackground(new Color(10, 235, 100));
		gamePanel.setLocation(20, 140);

		p = new player();

		p.setLocation(playerY, playerX);

		gamePanel.add(p);

		ArrayList<block> bl = new ArrayList<block>();

		initBlock(bl);

		for (int i = 0; i < bl.size(); i++) {
			System.out.println("x좌표 : " + bl.get(i).getX() + " ~ " + (bl.get(i).getX() + 40) + " y좌표 : "
					+ bl.get(i).getY() + " ~ " + (bl.get(i).getY() + 40));

			gamePanel.add(bl.get(i));
		}
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
//					e.printStackTrace();
					System.out.println("timerThread");
					System.out.println(e.toString());
				}
				timeLabel.setText("");
				timeLabel.setText(timer(i));

				// 한번쓰고 버릴꺼면 이렇게 만들어도 됨
//				new Thread() {
//					@Override
//					public void run() {
//					
//					}
//				}.start();

			}
		}
	}

	// 메뉴 패널 초기구성
	public void initMenuPanel() {
		JLabel menuLabel = new JLabel();
		menuLabel.setIcon(menuImage);
		menuLabel.setSize(MENUXSIZE, MENUYSIZE);
		timerPanel = new JPanel();
		optionButton = new JButton("");

		timeLabel = new JLabel(timer(time));
		timeLabel.setFont(new Font("빙그레체", Font.BOLD, 30));
		timeLabel.setLocation(1000, 40);

		timerPanel.setSize(180, 50);
		timerPanel.setBackground(new Color(0, 0, 0, 0));

		new timerThread().start();

		timerPanel.add(timeLabel);

		timerPanel.setLocation(550, 15);

		menuPanel.setLayout(null);

		optionButton.setIcon(optionImage);
		optionButton.setSize(60, 60);
		optionButton.setLocation(1300, 10);

		menuPanel.setSize(MENUXSIZE, MENUYSIZE);
		menuPanel.setLocation(20, 20);

		menuPanel.add(optionButton);
		menuPanel.add(timerPanel);

		menuPanel.add(menuLabel);
	}

	public static void main(String[] args) {

		new singleGame();

	}

}
