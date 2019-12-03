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

	// ���� �÷��� �ð�
	final static int time = 0;

	// ���� ������ �÷��� �Ǵ� �г� brjtn 1
	private JPanel gamePanel;

	// ���� ���� �޴� UI �г�
	private JPanel menuPanel; // �޴� Ʋ
	private JButton optionButton; // �ɼ� ��ư
	private JPanel timerPanel; // Ÿ�̸� �г�
	private JLabel timeLabel; // �ð��� ��µǴ� ���̺�

	// ================= �̹��� ================ //
	ImageIcon backImage = new ImageIcon("image/back.png");
	// ================= �� �̹��� ================ //
	ImageIcon teduriImage = new ImageIcon("image/GameObject/teduri.png");
	ImageIcon blockImage = new ImageIcon("image/GameObject/block1.png");
	ImageIcon blockImage2 = new ImageIcon("image/GameObject/block2.png");
	ImageIcon blockImage3 = new ImageIcon("image/GameObject/block3.png");
	ImageIcon tileImage = new ImageIcon("image/GameObject/tile.png");
	// ================= �� �̹��� ================ //

	// ================= ���� �ɼ� �̹��� ================ //
	ImageIcon optionImage = new ImageIcon("image/option.png");
	ImageIcon menuImage = new ImageIcon("image/imsiMenu.png");
	// ================= �̹��� ================ //

	// Player ��ü
	player p = new player();

	// ��
	block[][] bl = new block[18][35];

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

	private long prevTime = 0; // ������

	@Override
	public void keyPressed(KeyEvent e) {

		int xPoint = p.getLocationX() / 40;
		int yPoint = p.getLocationY() / 40;

		if (e.getKeyCode() == KeyEvent.VK_K)
			System.out.println(bl[(p.getLocationY() + 20) / 39][(p.getLocationX() + 20) / 39].getImageName());

		move(e.getKeyCode());

		long curTime = System.currentTimeMillis() - prevTime; // ��Ÿ�� ���
		if (curTime > 450) { // ��Ÿ�� 0.45��
			hitBlock(e.getKeyCode());
			prevTime = System.currentTimeMillis();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	// �� ����Ʈ ä���ֱ�
	public void initBlock(block[][] bl) {
		int x = 0;
		int y = 0;

		for (int i = 0; i < bl.length; i++) {
			for (int j = 0; j < bl[i].length; j++) {

				if ((i == 0 || j == 0) || (i == 17 || j == 34)) {
					bl[i][j] = new block(teduriImage, 1000, x, y);

				}

				else
					bl[i][j] = new block(blockImage, 3, x, y);

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

	// ���� â �ʱ�ȭ
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

	// �÷��� Ÿ���� 00:00 �������� ���
	public String timer(int time) {
		int min = time / 60;
		int sec = time % 60;

		return String.format("%d : %02d", min, sec);
	}

	// �ð��� �귯���� ����
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

				// �ѹ����� �������� �̷��� ���� ��
//				new Thread() {
//					@Override
//					public void run() {
//					
//					}
//				}.start();

			}
		}
	}

	// �޴� �г� �ʱⱸ��
	public void initMenuPanel() {
		JLabel menuLabel = new JLabel();
		menuLabel.setIcon(menuImage);
		menuLabel.setSize(MENUXSIZE, MENUYSIZE);
		timerPanel = new JPanel();
		optionButton = new JButton("");

		timeLabel = new JLabel(timer(time));
		timeLabel.setFont(new Font("���׷�ü", Font.BOLD, 30));
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

	// �̵�Ű �Է¿� ���� ĳ������ ���� ��ȯ
	public int getState() {
		return state;
	}

	// �� Ÿ�� ��ư �Է½� ȣ�� �� �޼ҵ� ����
	public void hitBlock(int keyType) {
		int xPoint = (p.getLocationX() + 20) / 40;
		int yPoint = (p.getLocationY() + 20) / 40;

		if (keyType == KeyEvent.VK_UP) {
			state = 5;
			p.painting(state);

			bl[yPoint - 1][xPoint].setHp(bl[yPoint - 1][xPoint].getHp() - 1);
			System.out.println("�� �� HP : " + bl[yPoint - 1][xPoint].getHp());
			System.out.println(bl[yPoint - 1][xPoint].isBlock());

			if (bl[yPoint - 1][xPoint].getHp() == 2)
				bl[yPoint - 1][xPoint].setImage(blockImage2);
			else if (bl[yPoint - 1][xPoint].getHp() == 1)
				bl[yPoint - 1][xPoint].setImage(blockImage3);
			else if (bl[yPoint - 1][xPoint].getHp() <= 0)
				bl[yPoint - 1][xPoint].setImage(tileImage);

		}
		if (keyType == KeyEvent.VK_DOWN) {
			state = 7;
			p.painting(state);

			bl[yPoint + 1][xPoint].setHp(bl[yPoint + 1][xPoint].getHp() - 1);
			System.out.println("�Ʒ� �� HP : " + bl[yPoint + 1][xPoint].getHp());

			if (bl[yPoint + 1][xPoint].getHp() == 2)
				bl[yPoint + 1][xPoint].setImage(blockImage2);
			else if (bl[yPoint + 1][xPoint].getHp() == 1)
				bl[yPoint + 1][xPoint].setImage(blockImage3);
			else if (bl[yPoint + 1][xPoint].getHp() <= 0)
				bl[yPoint + 1][xPoint].setImage(tileImage);
			p.revalidate();
			p.repaint();
		}
		if (keyType == KeyEvent.VK_LEFT) {
			state = 6;
			p.painting(state);

			bl[yPoint][xPoint - 1].setHp(bl[yPoint][xPoint - 1].getHp() - 1);
			System.out.println("�� �� HP : " + bl[yPoint][xPoint - 1].getHp());

			if (bl[yPoint][xPoint - 1].getHp() == 2)
				bl[yPoint][xPoint - 1].setImage(blockImage2);
			else if (bl[yPoint][xPoint - 1].getHp() == 1)
				bl[yPoint][xPoint - 1].setImage(blockImage3);
			else if (bl[yPoint][xPoint - 1].getHp() <= 0)
				bl[yPoint][xPoint - 1].setImage(tileImage);
			p.revalidate();
			p.repaint();
		}
		if (keyType == KeyEvent.VK_RIGHT) {
			state = 8;
			p.painting(state);

			bl[yPoint][xPoint + 1].setHp(bl[yPoint][xPoint + 1].getHp() - 1);
			System.out.println("�� �� HP : " + bl[yPoint][xPoint + 1].getHp());

			if (bl[yPoint][xPoint + 1].getHp() == 2)
				bl[yPoint][xPoint + 1].setImage(blockImage2);
			else if (bl[yPoint][xPoint + 1].getHp() == 1)
				bl[yPoint][xPoint + 1].setImage(blockImage3);
			else if (bl[yPoint][xPoint + 1].getHp() <= 0)
				bl[yPoint][xPoint + 1].setImage(tileImage);
			p.revalidate();
			p.repaint();
		}
	}

	public void move(int keyType) {
		// WŰ �Է½�
		if (keyType == KeyEvent.VK_W) {
			state = 1; // ��
			p.painting(state);

			p.LocationSet(playerX, playerY -= 5);
			p.outOfrange();

			p.revalidate();
//			p.repaint();

			System.out.println(p.getLocationX() + " " + p.getLocationY());
			System.out.println(p.getX() + " " + p.getY());
		}
		// AŰ �Է½�
		if (keyType == KeyEvent.VK_A) {
			state = 2;
			p.painting(state);
			p.LocationSet(playerX -= 5, playerY);

			p.outOfrange();

			p.revalidate();
//			p.repaint();

			System.out.println(p.getLocationX() + " " + p.getLocationY());

		}
		// SŰ �Է½�
		if (keyType == KeyEvent.VK_S) {
			state = 3;
			p.painting(state);
			p.LocationSet(playerX, playerY += 5);

			p.outOfrange();

			p.revalidate();
//			p.repaint();

			System.out.println(p.getLocationX() + " " + p.getLocationY());

		}
		// DŰ �Է½�
		if (keyType == KeyEvent.VK_D) {
			state = 4;
			p.painting(state);
			p.LocationSet(playerX += 5, playerY);
			p.outOfrange();

			p.revalidate();
//			p.repaint();

			System.out.println(p.getLocationX() + " " + p.getLocationY());
		}
	}

	public static void main(String[] args) {

		singleGame sGame = new singleGame();

	}

}
