package Game;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class multiGame extends JPanel implements KeyListener { // �̱�

	final static int GAMEXSIZE = 1400;
	final static int GAMEYSIZE = 720;

	final static int GAMEXPoint = 35;
	final static int GAMEYPoint = 18;
	multiGame multi = this;

	// ��
	block bl = new block(); // block Ŭ������ �������ִ� �ʵ带 ����ϱ� ���ؼ� ����, �ʿ信 ���ؼ� �����Ҽ�����
	block[][] block = new block[GAMEYPoint][GAMEXPoint]; // ���� ���� ������� �迭
	// ����
	mine mine = new mine(); // mine Ŭ������ �ִ� �޼ҵ带 ����ϱ� ���� ����
	boolean[][] minePosition = new boolean[GAMEYPoint][GAMEXPoint]; // ���ڰ� ��ġ�� ��ġ�� �������ֱ� ���� ���� 2�����迭
	int mineCount = 100; // ���ڰ� �� ����, ���� Mune_Single ���� ���̵� ������ ���� �ٸ� ���� �ް��� ����

	// ��� ����
//	flag flag = new flag();
	flag[][] flagArr = new flag[GAMEYPoint][GAMEXPoint];
	boolean[][] flagPosition = new boolean[GAMEYPoint][GAMEXPoint]; // ����� �������� �Ȳ������� Ȯ��
	int flagCount = mineCount; // ����� ������ ������ŭ�� �����ؾ� �Ѵ�.

	int[][] blockPlan = new int[GAMEYPoint][GAMEXPoint]; // ��ü���� ��ġ�� ��ҵ��� ��Ȳ�� ��� ��

	static Socket gameSocket;
	Thread gameTh;
	multiGameReceiverThread gameRun;

	static DataOutputStream gameOutStream;

	// Player ��ü
	player p = new player(1, 40, 40);
	player p2 = new player(2, 1320, 40);
	int playerX = p.getX(); // ���� �÷��̾��� ��ǥ
	int playerY = p.getY(); // ���� �÷��̾��� ��ǥ
	static int state; // �÷��̾��� ����

	public multiGame(Socket gameSocket) {
		this.gameSocket = gameSocket;
		setLayout(null);
		initFlag();
		add(p);
		add(p2);

		// ������ �ƿ� ��Ʈ�� ����.
		try {
			gameOutStream = new DataOutputStream(gameSocket.getOutputStream());

		} catch (Exception e) {
			e.printStackTrace();
		}

		gameRun = new multiGameReceiverThread(gameSocket, multi);
		gameTh = new Thread(gameRun);
		
		// block�� ���� ��� �ʱ� ���¸� �����ϰ� �гο� �Է�����
		bl.initBlock(this, block);
		// player�� �ʱ� ��ġ�� �����
		// ������ ��ġ�� �������ִ� �޼ҵ�
		generateMine(minePosition);
		genMap();

		this.setFocusable(true);
		this.addKeyListener(this);
	}

	public int getMineCount() {
		return this.mineCount;
	}

	public int getFlagCount() { // �⺻�� ������ ������ŭ ���� �� �ʿ��� ���� ��߼��� �����ؾ���.
		int usingFlag = 0; // ����� ������ flagPosition�� �˻��ϸ鼭 ������ų����

		for (int i = 0; i < 18; i++)
			for (int j = 0; j < 35; j++)
				if (flagPosition[i][j] == true)
					usingFlag++;

		return this.flagCount - usingFlag; // �־��� ����� ���� - ����� ����
	}

	// ���ڰ� �ִ� ��ġ�� 2�����迭�� ������ ������ ������ŭ �����ϰ� ��´�.
	public void generateMine(boolean[][] bool) {
		int count = 0;
		int imsi = 0;
		while (count < mineCount) {
			int x = (int) (Math.random() * bool.length);
			int y = (int) (Math.random() * bool[x].length);

			// ���� ���ڰ� ����, �׵θ��� �ƴϸ� ���ڸ� �߰��ϰ� ������ ������ �ø�
			if (bool[x][y] == false && (x != 0 && y != 0) && (x != bool.length - 1 && y != bool[x].length - 1)) {
				bool[x][y] = true;
				count++;
			}

		}
	}

	public void initFlag() {
		for (int i = 0; i < flagArr.length; i++)
			for (int j = 0; j < flagArr[i].length; j++)
				flagArr[i][j] = new flag();
	}

	public void genMap() {
		for (int i = 0; i < block.length; i++)
			for (int j = 0; j < block[i].length; j++)
				if ((i == 0 || j == 0) || (i == 17 || j == 34)) // ��
					blockPlan[i][j] = 11;
				else if (minePosition[i][j] == false)
					blockPlan[i][j] = mine.getMineCount(minePosition, i, j); // ������ ����
				else
					blockPlan[i][j] = 10; // ����
	}

	// s Ű�� ������ ���� �޼ҵ带 ����, ���� �� ����� ����
	public void putFlag() {
		int xPoint = p.getX() / 40;
		int yPoint = p.getY() / 40;

		block[yPoint][xPoint].add(flagArr[yPoint][xPoint], new Integer(2));

		System.out.println(flagPosition[yPoint][xPoint]);
		if (flagPosition[yPoint][xPoint] == false) {
			block[yPoint][xPoint].setBlockState(true); // ����� �������� ��� �� ���� �湮���θ� true

			flagPosition[yPoint][xPoint] = true;
			flagArr[yPoint][xPoint].setFlagImage(0);

		} else {// ����� �ȾҴµ� �ٽ� �������� -> ? ǥ�÷� �ٲ� �̶��� ���� �ǵ��� �� �ִ�.
			block[yPoint][xPoint].setBlockState(false);

			flagPosition[yPoint][xPoint] = false; // ����� �ƴ�����.. '?' �� ���� ������ҵ�..?
			flagArr[yPoint][xPoint].setFlagImage(1); // ? �̹����� ����

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

		// AŰ�� �Է� + �� ��ġ ���� ���õ��� �ʾҴٸ�, ���� �ν�
		if (e.getKeyCode() == KeyEvent.VK_A && block[yPoint][xPoint].getBlockState() != true) {
			state = 10;
			p.setImage(state);
			hitBlock();
		}
		// SŰ�� ���� ��� or ? �� ���� �� �ִ�.
		if (e.getKeyCode() == KeyEvent.VK_S) {
			if (getFlagCount() > 0)
				putFlag();
			Game_MenuPanel.setFlagCount(getFlagCount());
		}

		if (e.getKeyCode() == KeyEvent.VK_M)
			for (int i = 0; i < block.length; i++)
				System.out.println(Arrays.toString(blockPlan[i]));

	} // KeyPressed

	@Override
	public void keyReleased(KeyEvent e) {
		stop(e.getKeyCode());
	}

	// �� Ÿ�� ��ư �Է½� ȣ�� �� �޼ҵ� ����
	public void hitBlock() {
		int xPoint = p.getX() / 40;
		int yPoint = p.getY() / 40;

		// isMine �޼ҵ�� �װų�, �ֺ���
		System.out.println("ĳ���� ��ġ�� ���� ���� �Ǿ����� ? : " + block[yPoint][xPoint].getBlockState());
		System.out.println("���õ� ���� ��ǥ <" + block[yPoint][xPoint].getX() + ", " + block[yPoint][xPoint].getY() + "> : <"
				+ yPoint + "," + xPoint + ">");
		System.out.println("���⿡ ���ڰ� �ִ���?" + mine.isMine(minePosition, yPoint, xPoint));

		block[yPoint][xPoint].setImage();

		// ���� ���� ���� ���ڰ� �ƴϸ� �ֺ��� �ִ� ������ ������ �ְ�, �ƴϸ� ���ڸ� �ִ´�. �� ��� ���� �й�
		if (mine.isMine(minePosition, yPoint, xPoint) == false) {
			block[yPoint][xPoint].add(new MineNum(mine.getMineCount(minePosition, yPoint, xPoint)), new Integer(2)); // �ϴ�������
			if (mine.getMineCount(minePosition, yPoint, xPoint) == 0)
				linkedOpen(yPoint, xPoint);
//			mineRecursive(blockPlan, yPoint, xPoint / 2);
		} else { // ���ڸ� ����� �� ?
			block[yPoint][xPoint].add(new mine(1), new Integer(2));
			p.setPlayerHP(p.getPlayerHP() - 1);
			Game_MenuPanel.sethpImage(p.getPlayerHP());

			if (p.getPlayerHP() == 0)
				defeatGmae(minePosition, block);
		}
		block[yPoint][xPoint].setBlockState(true);

	}

	// ������ ���ֺ��� ���ڰ� ������ ���� ���� ���� ���� �޼ҵ�
	public void linkedOpen(int x, int y) {
		// x,y�� Ÿ���� �� ���� ��ġ�� ������, �ݺ��� x-1~x+1 ���� , y-1 ~ y+1 ���� �ؾ��Ѵ�..
		// x�� ����(yPoint) , y�� �ʺ�(xPoint)�� �־���.

		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				if ((i == x && j == y) || (i < 1 || j < 1 || i > 16 || j > 33) || mine.isMine(minePosition, i, j)
						|| block[i][j].getBlockState()) { // ��ǥ�� �׵θ�, �������̰ų� , ��ġ�� ���ڰ� ������
					continue;
				} else if (mine.getMineCount(minePosition, i, j) == 0) { // ���õ� ���ֺ��� ���ڰ� ������ �̺κп��� ��������� �Լ��� ȣ��
					block[i][j].setImage();
					block[i][j].add(new MineNum(mine.getMineCount(minePosition, i, j)), new Integer(2));
					block[i][j].setBlockState(true);
					linkedOpen(i, j);

				} else { //
					block[i][j].setImage();
					block[i][j].add(new MineNum(mine.getMineCount(minePosition, i, j)), new Integer(2));
					block[i][j].setBlockState(true);
				}
			}
		}

	}

	// �̵��� �����Ҷ� ������ ��ǵ��� ������ �ϴ� �޼ҵ�
	public void stop(int keyType) {
		int prevMotion = 7;
		// ����Ű ���� �Է½�
		if (keyType == KeyEvent.VK_UP) {
			state = 5; // ��
			p.setImage(state);
			prevMotion = state;
		}
		// ����Ű ���� �Է½�
		if (keyType == KeyEvent.VK_LEFT) {
			state = 6;
			p.setImage(state);
			prevMotion = state;
		}
		// ����Ű �Ʒ� �Է½�
		if (keyType == KeyEvent.VK_DOWN) {
			state = 7;
			p.setImage(state);
			prevMotion = state;
		}
		// ����Ű ������ �Է½�
		if (keyType == KeyEvent.VK_RIGHT) {
			state = 8;
			p.setImage(state);
			prevMotion = state;

		}

		if (keyType == KeyEvent.VK_A) {
			state = prevMotion;
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

	// ���ӿ� �й��� �� ���� �޼ҵ�
	public void defeatGmae(boolean[][] bool, block[][] block) {

		new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					for (int i = 0; i < block.length; i++) {
						for (int j = 0; j < block[i].length; j++) {
							if (bool[i][j] == true && block[i][j].getBlockState() == false) {
								block[i][j].add(new mine(0), new Integer(2));
							}

						}
					}

					for (int i = 0; i < block.length; i++) {
						for (int j = 0; j < block[i].length; j++) {
							if (bool[i][j] == true && block[i][j].getBlockState() == false) {
								Thread.sleep(10);
								block[i][j].add(new mine(1), new Integer(3));
							}

						}
					}
				} catch (InterruptedException e) {
					// TODO: handle exception
				}

			}
		}.start();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
