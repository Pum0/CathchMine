package Game;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
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
	mine mine = new mine(); // mine Ŭ������ �ִ� �޼ҵ带 ����ϱ� ���� ����
	boolean[][] minePosition = new boolean[18][35]; // ���ڰ� ��ġ�� ��ġ�� �������ֱ� ���� ���� 2�����迭
	int mineCount = 250; // ���ڰ� �� ����, ���� Mune_Single ���� ���̵� ������ ���� �ٸ� ���� �ް��� ����

	public singleGame() {
		setLayout(null);

		this.add(p);
		p.setBounds(playerX, playerY, 40, 40);
		// block�� ���� ��� �ʱ� ���¸� �����ϰ� �гο� �Է�����
		bl.initBlock(this, block);
		// player�� �ʱ� ��ġ�� �����
		// ������ ��ġ�� �������ִ� �޼ҵ�
		generateMine(minePosition);

		this.setFocusable(true);
		this.addKeyListener(this);
	}

	// ���� ������ �̹����� �ִ� �޼ҵ带 ���⼭ ����
	public void disposeMine(JPanel pan) {

	}

	// ���ڰ� �ִ� ��ġ�� 2�����迭�� ������ ������ ������ŭ �����ϰ� ��´�.
	public void generateMine(boolean[][] bool) {
		int count = 0;
		int imsi = 0;
		while (count < mineCount) {
			imsi++;
			int x = (int) (Math.random() * bool.length);
			int y = (int) (Math.random() * bool[x].length);

			System.out.println(imsi);
			// ���� ���ڰ� ����, �׵θ��� �ƴϸ� ���ڸ� �߰��ϰ� ������ ������ �ø�
			if (bool[x][y] == false && (x != 0 && y != 0) && (x != bool.length - 1 && y != bool[x].length - 1)) {
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

		if (e.getKeyCode() == KeyEvent.VK_B) {
			System.out.println("�ֺ� ���� �ִ� ���� ������ : " + mine.getMineCount(minePosition, yPoint, xPoint));
		}
		if (e.getKeyCode() == KeyEvent.VK_C) {
			int[][] g = new int[18][35];
			for (int i = 1; i < 18 - 1; i++) {
				for (int j = 1; j < 35 - 1; j++)
					g[i][j] = mine.getMineCount(minePosition, i, j);
			}

			for (int i = 0; i < 18; i++) {
				System.out.println(Arrays.toString(g[i]));
			}
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

		// isMine �޼ҵ�� �װų�, �ֺ���
		System.out.println("ĳ���� ��ġ�� ���� ���� �Ǿ����� ? : " + block[yPoint][xPoint].getBlockState());
		System.out.println("���õ� ���� ��ǥ <" + block[yPoint][xPoint].getX() + ", " + block[yPoint][xPoint].getY() + ">");
		System.out.println("���⿡ ���ڰ� �ִ���?" + mine.isMine(minePosition, yPoint, xPoint));

//		block[yPoint][xPoint].revalidate();
		block[yPoint][xPoint].setImage();
		// ���� ���� ���� ���ڰ� �ƴϸ� �ֺ��� �ִ� ������ ������ �ְ� �ƴϸ� ���ڸ� �ִ´�
		if (mine.isMine(minePosition, yPoint, xPoint) == false)
			block[yPoint][xPoint].add(new MineNum(mine.getMineCount(minePosition, yPoint, xPoint)), new Integer(2));
		else
			block[yPoint][xPoint].add(new mine(), new Integer(2));

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

	
	
	// ���� ������ ������ ��Ÿ�� �̹����� ������ �ִ� �г�
	class MineNum extends JPanel {
		ImageIcon N1 = new ImageIcon("image/GameObject/blockNumber/N1.png");
		ImageIcon N2 = new ImageIcon("image/GameObject/blockNumber/N2.png");
		ImageIcon N3 = new ImageIcon("image/GameObject/blockNumber/N3.png");
		ImageIcon N4 = new ImageIcon("image/GameObject/blockNumber/N4.png");
		ImageIcon N5 = new ImageIcon("image/GameObject/blockNumber/N5.png");
		ImageIcon N6 = new ImageIcon("image/GameObject/blockNumber/N6.png");
		ImageIcon N7 = new ImageIcon("image/GameObject/blockNumber/N7.png");
		ImageIcon N8 = new ImageIcon("image/GameObject/blockNumber/N8.png");

		ImageIcon[] numberIcon = { null, N1, N2, N3, N4, N5, N6, N7, N8 };

		JLabel mineNumberIcon;

		public MineNum() {
		}

		public MineNum(int MineCount) {
			this.setSize(40, 40);
			this.setLayout(new GridLayout(0, 1));
			this.setOpaque(false);

			mineNumberIcon = new JLabel();
			mineNumberIcon.setIcon(numberIcon[MineCount]);

			this.add(mineNumberIcon);

		}
	}
	
	
	
	
	// ���������� ����, ����� �����ֱ� ���� ��� Ŭ����
	class Flag extends JPanel {
		ImageIcon flagImage = new ImageIcon("image/GameObject/RedFlag.png");
		JLabel flagIcon;

		public Flag() {
		}

		public Flag(int x, int y) {
			this.setSize(40, 40);
			this.setLayout(new GridLayout(0, 1));
			this.setOpaque(false);
			this.setLocation(x, y);

			flagIcon = new JLabel();
			flagIcon.setIcon(flagImage);

			this.add(flagIcon);

		}
	}
	
	
	
}
