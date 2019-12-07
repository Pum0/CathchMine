package Game;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

import javax.swing.JPanel;

public class singleGame extends JPanel implements KeyListener { // �̱�
	final static int FRAMEXSIZE = 1440;
	final static int FRAMEYSIZE = 900;

	final static int GAMEXSIZE = 1400;
	final static int GAMEYSIZE = 720;

//	singleGame sG = this; // �̱۰����г� �ڽ�
	// Player ��ü
	player p = new player();
	int playerX = p.getX(); // ���� �÷��̾��� ��ǥ
	int playerY = p.getY(); // ���� �÷��̾��� ��ǥ
	static int state; // �÷��̾��� ����

	// ��
	block bl = new block(); // block Ŭ������ �������ִ� �ʵ带 ����ϱ� ���ؼ� ����, �ʿ信 ���ؼ� �����Ҽ�����
	block[][] block = new block[18][35]; // ���� ���� ������� �迭
	// ����
	mine mine = new mine();
	boolean[][] minePosition = new boolean[18][35];
	int mineCount = 100;

	public singleGame() {
		setLayout(null);
		setBackground(Color.RED);

		this.add(p);
		bl.initBlock(this, block);
		p.setBounds(playerX, playerY, 40, 40);

		generateMine(minePosition);

		this.setFocusable(true);

		this.addKeyListener(this);

	}
	
	
	// ���ڰ� �ִ� ��ġ�� 2�����迭�� ������ ������ ������ŭ �����ϰ� ��´�.
	public void generateMine(boolean[][] bool) {
		int count = 0;

		while (count < mineCount) {
			int x = (int) (Math.random() * bool.length);
			int y = (int) (Math.random() * bool[x].length);

			if (bool[x][y] == false) {
				bool[x][y] = true;
				count++;
			}

		}
	}

	private long prevTime = 0; // ������

	@Override
	public void keyPressed(KeyEvent e) {
		int xPoint = p.getX() / 40;
		int yPoint = p.getY() / 40;

		long curTime = System.currentTimeMillis() - prevTime; // ��Ÿ�� ���
		if (curTime > 35) { // ��Ÿ�� 0.1��
			move(e.getKeyCode());

			prevTime = System.currentTimeMillis();
		}

		if (e.getKeyCode() == KeyEvent.VK_Q && block[yPoint][xPoint].getBlockState() != true) {

			state = 10;
			p.setState(state);
			hitBlock();

		}

		// Mine �迭 Ȯ�ο�
		if (e.getKeyCode() == KeyEvent.VK_O) {
			for (int i = 0; i < minePosition.length; i++)
				System.out.println(Arrays.toString(minePosition[i]));
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

		stop(e.getKeyCode());

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	// �� Ÿ�� ��ư �Է½� ȣ�� �� �޼ҵ� ����
	public void hitBlock() {
		int xPoint = p.getX() / 40;
		int yPoint = p.getY() / 40;

		System.out.println("ĳ���� ��ġ�� ���� ���� �Ǿ����� ? : " + block[yPoint][xPoint].getBlockState());
		System.out.println("���õ� ���� ��ǥ <" + block[yPoint][xPoint].getX() + ", " + block[yPoint][xPoint].getY() + ">");

		block[yPoint][xPoint].revalidate();
		block[yPoint][xPoint].setImage();

		block[yPoint][xPoint].setBlockState(true);

	}

	// �̵��� �����Ҷ� ������ ��ǵ��� ������ �ϴ� �޼ҵ�
	public void stop(int keyType) {
		// ����Ű ���� �Է½�
		if (keyType == KeyEvent.VK_UP) {
			state = 5; // ��
			p.setImage(state);
		}
		// ����Ű ���� �Է½�
		if (keyType == KeyEvent.VK_LEFT) {
			state = 6;
			p.setImage(state);
		}
		// ����Ű �Ʒ� �Է½�
		if (keyType == KeyEvent.VK_DOWN) {
			state = 7;
			p.setImage(state);

		}
		// ����Ű ������ �Է½�
		if (keyType == KeyEvent.VK_RIGHT) {
			state = 8;
			p.setImage(state);

		}
	}

	// �̵����� �ٷ�� �޼ҵ�
	public void move(int keyType) {

		// ����Ű ���� �Է½�
		if (keyType == KeyEvent.VK_UP) {
			state = 1; // ��
			p.setImage(state);

			p.LocationSet(playerX, playerY -= 40);
			p.outOfrange();

		}
		// ����Ű ���� �Է½�
		if (keyType == KeyEvent.VK_LEFT) {
			state = 2;
			p.setImage(state);

			p.LocationSet(playerX -= 40, playerY);

			p.outOfrange();

		}
		// ����Ű �Ʒ� �Է½�
		if (keyType == KeyEvent.VK_DOWN) {
			state = 3;
			p.setImage(state);

			p.LocationSet(playerX, playerY += 40);

			p.outOfrange();

		}
		// ����Ű ������ �Է½�
		if (keyType == KeyEvent.VK_RIGHT) {
			state = 4;
			p.setImage(state);

			p.LocationSet(playerX += 40, playerY);
			p.outOfrange();

		}

	}

}
