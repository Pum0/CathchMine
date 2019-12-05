package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class singleGame extends JPanel implements KeyListener { // �̱�
	final static int FRAMEXSIZE = 1440;
	final static int FRAMEYSIZE = 900;

	final static int GAMEXSIZE = 1400;
	final static int GAMEYSIZE = 720;

	singleGame sG = this; // �̱۰����г� �ڽ�

	// ================= �̹��� ================ //
	ImageIcon backImage = new ImageIcon("image/back.png");
	// ================= �� �̹��� ================ //
	ImageIcon teduriImage = new ImageIcon("image/GameObject/teduri.png");
	ImageIcon blockImage = new ImageIcon("image/GameObject/block1.png");
	ImageIcon blockImage2 = new ImageIcon("image/GameObject/block2.png");
	ImageIcon blockImage3 = new ImageIcon("image/GameObject/block3.png");
	ImageIcon tileImage = new ImageIcon("image/GameObject/tile.png");
	// ================= �� �̹��� ================ //

	// ================= �̹��� ================ //

	// Player ��ü
	player p = new player();

	// ��
	block[][] bl = new block[18][35];

	static int state = 1;

	int playerX = p.getX();
	int playerY = p.getY();

	public singleGame() {
		setLayout(null);
		setBackground(Color.RED);

		this.add(p);
		p.setBounds(playerX, playerY, 40, 40);

		initBlock(bl);

		for (int i = 0; i < bl.length; i++)
			for (int j = 0; j < bl[i].length; j++)
				add(bl[i][j]);

		this.setFocusable(true);

		this.addKeyListener(this);

	}

	private long prevTime = 0; // ������

	@Override
	public void keyPressed(KeyEvent e) {

		int xPoint = p.getX() / 40;
		int yPoint = p.getY() / 40;

		long curTime = System.currentTimeMillis() - prevTime; // ��Ÿ�� ���
		if (curTime > 100) { // ��Ÿ�� 0.1��
			move(e.getKeyCode());
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

	public void initBlock(block[][] bl) {
		int x = 0;
		int y = 0;

		for (int i = 0; i < bl.length; i++) {
			for (int j = 0; j < bl[i].length; j++) {

				if ((i == 0 || j == 0) || (i == 17 || j == 34)) {
					bl[i][j] = new block(teduriImage, x, y);

				}

				else
					bl[i][j] = new block(blockImage, x, y);

				x += 40;

			}
			x = 0;
			y += 40;

		}

	}

	// �̵�Ű �Է¿� ���� ĳ������ ���� ��ȯ
	public int getState() {
		return state;
	}

	// �� Ÿ�� ��ư �Է½� ȣ�� �� �޼ҵ� ����
	public void hitBlock(int keyType) {
		int xPoint = (p.getX() + 20) / 40;
		int yPoint = (p.getY() + 20) / 40;

	}

	public void move(int keyType) {

		// WŰ �Է½�
		if (keyType == KeyEvent.VK_W) {
			state = 1; // ��
			p.painting(state);

			p.LocationSet(playerX, playerY -= 40);
			p.outOfrange();

			p.revalidate();
			p.repaint();

			System.out.println(p.getX() + " " + p.getY());
			System.out.println(p.getX() + " " + p.getY());
		}
		// AŰ �Է½�
		if (keyType == KeyEvent.VK_A) {
			state = 2;
			p.painting(state);
			p.LocationSet(playerX -= 40, playerY);

			p.outOfrange();

			p.revalidate();
			p.repaint();

			System.out.println(p.getX() + " " + p.getY());

		}
		// SŰ �Է½�
		if (keyType == KeyEvent.VK_S) {
			state = 3;
			p.painting(state);
			p.LocationSet(playerX, playerY += 40);

			p.outOfrange();

			p.revalidate();
			p.repaint();

			System.out.println(p.getX() + " " + p.getY());

		}
		// DŰ �Է½�
		if (keyType == KeyEvent.VK_D) {
			state = 4;
			p.painting(state);
			p.LocationSet(playerX += 40, playerY);
			p.outOfrange();

			p.revalidate();
			p.repaint();

			System.out.println(p.getX() + " " + p.getY());
		}

	}

	public static void main(String[] args) {

		singleGame sGame = new singleGame();

	}

}
