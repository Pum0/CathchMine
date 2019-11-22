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
	ImageIcon blockImage = new ImageIcon("image/GameObject/block1.png");
	ImageIcon tileImage = new ImageIcon("image/GameObject/tile.png");
	// ================= 블럭 이미지 ================ //

	// ================= 내부 옵션 이미지 ================ //
	ImageIcon optionImage = new ImageIcon("image/option.png");
	ImageIcon menuImage = new ImageIcon("image/imsiMenu.png");
	// ================= 이미지 ================ //

	// Player 객체
	player p = new player();

	// 블럭
	block[][] bl = new block[35][18];

	static int state = 1;

	int playerX = 40;
	int playerY = 40;

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

		setTitle("Catch-Mine Game");
		setSize(FRAMEXSIZE, FRAMEYSIZE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_K)
			System.out.println(bl[(p.getLocationY() + 20) / 39][(p.getLocationX() + 20) / 39].getImageName());

		// W키 입력시
		if (e.getKeyCode() == KeyEvent.VK_W) {
			state = 1; // 위
			p.painting(state);

			p.LocationSet(playerX, playerY -= 5);
			p.outOfrange();

			p.revalidate();
			p.repaint();

			System.out.println(p.getLocationX() + " " + p.getLocationY());
			System.out.println(p.getX() + " " + p.getY());
		}
		// A키 입력시
		if (e.getKeyCode() == KeyEvent.VK_A) {
			state = 2;
			p.painting(state);
			p.LocationSet(playerX -= 5, playerY);

			p.outOfrange();

			p.revalidate();
			p.repaint();

			System.out.println(p.getLocationX() + " " + p.getLocationY());

		}
		// S키 입력시
		if (e.getKeyCode() == KeyEvent.VK_S) {
			state = 3;
			p.painting(state);
			p.LocationSet(playerX, playerY += 5);

			p.outOfrange();

			p.revalidate();
			p.repaint();

			System.out.println(p.getLocationX() + " " + p.getLocationY());

		}
		// D키 입력시
		if (e.getKeyCode() == KeyEvent.VK_D) {
			state = 4;
			p.painting(state);
			p.LocationSet(playerX += 5, playerY);
			p.outOfrange();

			p.revalidate();
			p.repaint();

			System.out.println(p.getLocationX() + " " + p.getLocationY());
		}

		// 위 방향키
		if (e.getKeyCode() == KeyEvent.VK_UP)
			hitBlock(KeyEvent.VK_UP);
		// 아래 방향키
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			hitBlock(KeyEvent.VK_DOWN);

		// 왼쪽 방향키
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			hitBlock(KeyEvent.VK_LEFT);
		// 오른쪽 방향키
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			hitBlock(KeyEvent.VK_RIGHT);

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	// 블럭 리스트 채워넣기
	public void initBlock(block[][] bl) {
		int x = 0;
		int y = 0;

		for (int i = 0; i < bl.length; i++) {
			for (int j = 0; j < bl[i].length; j++) {

				if ((i == 0 || j == 0) || (i == 34 || j == 17)) {
					bl[i][j] = new block(teduriImage, 1000, y, x);

				}

				else
					bl[i][j] = new block(blockImage, 3, y, x);

				x += 40;

			}
			x = 0;
			y += 40;

		}

		bl[1][1] = new block(tileImage, 0, 40, 40);
		bl[1][2] = new block(tileImage, 0, 40, 80);
		bl[2][1] = new block(tileImage, 0, 80, 40);
		bl[2][2] = new block(tileImage, 0, 80, 80);

	}

	// 게임 창 초기화
	public void initGamePanel() {
		gamePanel.setLayout(null);
		gamePanel.setSize(1400, 720);
		gamePanel.setBackground(new Color(10, 235, 100));
		gamePanel.setLocation(20, 140);

		p.setLocation(playerY, playerX);

		gamePanel.add(p);

		initBlock(bl);

		for (int i = 0; i < bl.length; i++)
			for (int j = 0; j < bl[i].length; j++)
				gamePanel.add(bl[i][j]);
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
		timerPanel.setOpaque(false);

		new timerThread().start();

		timerPanel.add(timeLabel);

		timerPanel.setLocation(550, 15);

		menuPanel.setLayout(null);

		optionButton.setIcon(optionImage);
		optionButton.setSize(60, 60);
		optionButton.setLocation(1300, 10);

		optionButton.setFocusable(false);

		menuPanel.setSize(MENUXSIZE, MENUYSIZE);
		menuPanel.setLocation(20, 20);

		menuPanel.add(optionButton);
		menuPanel.add(timerPanel);

		menuPanel.add(menuLabel);
	}

	// 이동키 입력에 따른 캐릭터의 상태 반환
	public int getState() {
		return state;
	}

	// 블럭 타격 버튼 입력시 호출 될 메소드 정의
	public void hitBlock(int keyType) {
		if (keyType == KeyEvent.VK_UP) {
			bl[p.getY() / 40 - 1][p.getX() / 40].setHp(bl[p.getY() / 40 - 1][p.getX() / 40].getHp() - 1);
			System.out.println("위 블럭 HP : " + bl[p.getY() / 40 - 1][p.getX() / 40].getHp());
			System.out.println(bl[p.getY() / 40 - 1][p.getX() / 40].isBlock());
			
		}
		if (keyType == KeyEvent.VK_DOWN) {
			bl[p.getY() / 40 + 1][p.getX() / 40].setHp(bl[p.getY() / 40 + 1][p.getX() / 40].getHp() - 1);
			System.out.println("아래 블럭 HP : " +bl[p.getY() / 40 + 1][p.getX() / 40].getHp());
		}
		if (keyType == KeyEvent.VK_LEFT) {
			bl[p.getY() / 40 ][p.getX() / 40 - 1].setHp(bl[p.getY() / 40 ][p.getX() / 40 - 1].getHp() - 1);
			System.out.println("좌 블럭 HP : " + bl[p.getY() / 40][p.getX() / 40 - 1].getHp());
		}
		if (keyType == KeyEvent.VK_RIGHT) {
			bl[p.getY() / 40][p.getX() / 40 + 1].setHp(bl[p.getY() / 40][p.getX() / 40 + 1].getHp() - 1);
			System.out.println("우 블럭 HP : " + bl[p.getY() / 40][p.getX() / 40 + 1].getHp());
		}
	}

	public static void main(String[] args) {

		singleGame sGame = new singleGame();

	}

}
