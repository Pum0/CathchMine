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
	ImageIcon blockImage = new ImageIcon("image/imsiBlock.png");
	// ================= �� �̹��� ================ //

	// ================= ���� �ɼ� �̹��� ================ //
	ImageIcon optionImage = new ImageIcon("image/option.png");
	ImageIcon menuImage = new ImageIcon("image/imsiMenu.png");
	// ================= �̹��� ================ //

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
		
		setTitle("����");
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

	// �� ����Ʈ ä���ֱ�
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

	// ���� â �ʱ�ȭ
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
			System.out.println("x��ǥ : " + bl.get(i).getX() + " ~ " + (bl.get(i).getX() + 40) + " y��ǥ : "
					+ bl.get(i).getY() + " ~ " + (bl.get(i).getY() + 40));

			gamePanel.add(bl.get(i));
		}
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
