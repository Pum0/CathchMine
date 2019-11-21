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
	ImageIcon teduriImage = new ImageIcon("image/imsiTeduri.png");
	ImageIcon blockImage = new ImageIcon("image/GameObject/block1.png");
	ImageIcon sendImage = new ImageIcon("image/huk.png");
	// ================= �� �̹��� ================ //

	// ================= ���� �ɼ� �̹��� ================ //
	ImageIcon optionImage = new ImageIcon("image/option.png");
	ImageIcon menuImage = new ImageIcon("image/imsiMenu.png");
	// ================= �̹��� ================ //

	// Player ��ü
	player p = new player();

	// ��
	block[][] bl = new block[35][18];

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

//		gamePanel.addKeyListener(this);
		addKeyListener(this);

		setTitle("����");
		setSize(FRAMEXSIZE, FRAMEYSIZE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_K)
			System.out.println(bl[(p.getLocationY() + 20) / 39][(p.getLocationX() + 20) / 39].getImageName());

		// WŰ �Է½�
		if (e.getKeyCode() == KeyEvent.VK_W) {
			p.LocationSet(playerX, playerY -= 5);
			p.outOfrange();

			p.revalidate();
			p.repaint();

			System.out.println(p.getLocationX() + " " + p.getLocationY());
			System.out.println(p.getX() + " " + p.getY());
		}
		// AŰ �Է½�
		if (e.getKeyCode() == KeyEvent.VK_A) {
			p.LocationSet(playerX -= 5, playerY);

			p.outOfrange();

			p.revalidate();
			p.repaint();

			System.out.println(p.getLocationX() + " " + p.getLocationY());

		}
		// SŰ �Է½�
		if (e.getKeyCode() == KeyEvent.VK_S) {
			p.LocationSet(playerX, playerY += 5);

			p.outOfrange();

			p.revalidate();
			p.repaint();

			System.out.println(p.getLocationX() + " " + p.getLocationY());

		}
		// DŰ �Է½�
		if (e.getKeyCode() == KeyEvent.VK_D) {

			p.LocationSet(playerX += 5, playerY);
			p.outOfrange();

			p.revalidate();
			p.repaint();

			System.out.println(p.getLocationX() + " " + p.getLocationY());
		}

		if (e.getKeyCode() == KeyEvent.VK_UP)
			System.out.println("UP");
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			System.out.println("DOWN");
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			System.out.println("LEFT");
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			System.out.println("RIGHT");

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

				if ((i == 0 || j == 0) || (i == 34 || j == 17)) {
					bl[i][j] = new block(teduriImage, y, x);

				}

				else
					bl[i][j] = new block(blockImage, y, x);

				x += 40;

			}
			x = 0;
			y += 40;

		}

		bl[1][1] = new block(sendImage, 40, 40);
		bl[1][2] = new block(sendImage, 40, 80);
		bl[2][1] = new block(sendImage, 80, 40);
		bl[2][2] = new block(sendImage, 80, 80);

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

	public static void main(String[] args) {

		new singleGame();

	}

}
