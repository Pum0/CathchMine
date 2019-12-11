package Game;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Grahpics.PlayMusic;

public class singleGame extends JPanel implements KeyListener { // �̱�
	final static int FRAMEXSIZE = 1440;
	final static int FRAMEYSIZE = 900;
	final static int GAMEXSIZE = 1400;
	final static int GAMEYSIZE = 720;

	final static int GAMEXPoint = 35;
	final static int GAMEYPoint = 18;

//   singleGame sG = this; // �̱۰����г� �ڽ�
	PlayMusic playBGM;

	// Player ��ü
	player p = new player(1, 40, 40);
//   player p2 = new player(2, 1320, 40);

	int playerX = p.getX(); // ���� �÷��̾��� ��ǥ - ������
	int playerY = p.getY(); // ���� �÷��̾��� ��ǥ - ������
	static int state; // �÷��̾��� ���� (���)

	// ��
	block bl = new block(); // block Ŭ������ �������ִ� �ʵ带 ����ϱ� ���ؼ� ����, �ʿ信 ���ؼ� �����Ҽ�����
	block[][] block = new block[GAMEYPoint][GAMEXPoint]; // ���� ���� ������� �迭
	// ����
	mine mine = new mine(); // mine Ŭ������ �ִ� �޼ҵ带 ����ϱ� ���� ����
	boolean[][] minePosition = new boolean[GAMEYPoint][GAMEXPoint]; // ���ڰ� ��ġ�� ��ġ�� �������ֱ� ���� ���� 2�����迭
	static int mineCount = 30; // ���ڰ� �� ����, ���� Mune_Single ���� ���̵� ������ ���� �ٸ� ���� �ް��� ����

	// ��� ����
	flag[][] flagArr = new flag[GAMEYPoint][GAMEXPoint];
	boolean[][] flagPosition = new boolean[GAMEYPoint][GAMEXPoint]; // ����� �������� �Ȳ������� Ȯ��
	int flagCount = mineCount; // ����� ������ ������ŭ�� �����ؾ� �Ѵ�.

	int[][] blockPlan = new int[GAMEYPoint][GAMEXPoint]; // ��ü���� ��ġ�� ��ҵ��� ��Ȳ�� ��� ��

	result result = new result();
//   result result;

	public singleGame() {
		setLayout(null);
		this.add(p);

//		Main.backgroundMusic = new PlayMusic("gameMusic.mp3", true);
//		Main.backgroundMusic.start();

		// player�� �ʱ� ��ġ�� �����
		p.setBounds(playerX, playerY, 40, 40);

		// block�� ���� ��� �ʱ� ���¸� �����ϰ� �гο� �Է�����
		bl.initBlock(this, block);
		initFlag();

		// ������ ��ġ�� �������ִ� �޼ҵ�
		generateMine(minePosition);
		genMap();

		this.setFocusable(true);
		this.addKeyListener(this);
	}

	public static void setMineCount(int mineCount) {
		singleGame.mineCount = mineCount;
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
			for (int j = 0; j < flagArr[i].length; j++) {
				flagArr[i][j] = new flag();

				if (i != 0 || j != 0 || i < flagArr.length - 1 || j < flagArr[j].length - 1)
					block[i][j].add(flagArr[i][j], new Integer(100)); // �����ϸ鼭 ������ �������������
			}

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

		System.out.println(flagPosition[yPoint][xPoint]);

		if (flagPosition[yPoint][xPoint] == false && block[yPoint][xPoint].getBlockState() != true
				&& (flagArr[yPoint][xPoint].getFlagShape() == 0)) {
			block[yPoint][xPoint].setBlockState(true); // ����� �������� ��� �� ���� �湮���θ� true

			flagPosition[yPoint][xPoint] = true; // ����� ����
			flagArr[yPoint][xPoint].setFlagShape(1);
			flagArr[yPoint][xPoint].setFlagImage(1);

		} else if (flagArr[yPoint][xPoint].getFlagShape() == 1 && flagPosition[yPoint][xPoint] == true) {// ����� �ȾҴµ� �ٽ�
			// �������� -> ?
			// ǥ�÷� �ٲ�
			// �̶��� ����
			// �ǵ��� �� �ִ�.
			block[yPoint][xPoint].setBlockState(false);

			flagPosition[yPoint][xPoint] = false;

			flagArr[yPoint][xPoint].setFlagShape(2);
			flagArr[yPoint][xPoint].setFlagImage(2); // ? �̹����� ����

		} else { // ?���µ� ����
			flagPosition[yPoint][xPoint] = false;

			flagArr[yPoint][xPoint].setFlagShape(0);
			flagArr[yPoint][xPoint].setFlagImage(0);

		}

	}

	private long prevTime = 0; // ������

	@Override
	public void keyPressed(KeyEvent e) {
		int xPoint = p.getX() / 40;
		int yPoint = p.getY() / 40;

		long curTime = System.currentTimeMillis() - prevTime; // ��Ÿ�� ����

		if (curTime > 35) { // ��Ÿ�� 0.035�� , ���� ����� ����� ������ �ָ� �ȴ�.
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
			if (getFlagCount() > 0) // ��� ������ ����� ���� ������
				putFlag();

			if (isWin(minePosition, flagPosition)) {
				System.out.println("���ӿ� �¸��ϼ̽��ϴ�!");
				result = new result(0);

				this.add(result);
				this.remove(p);
				removeKeyListener(this);
				result.setBounds(0, 0, 1400, 720);
				Game_MenuPanel.timerT.stop(); // �¸��ÿ��� Ŭ����Ÿ�� üũ�� ���� Ÿ�̸Ӹ� ����
			}

			Game_MenuPanel.setFlagCount(getFlagCount()); // �޴��гο� ���ڸ� ��� �� �ְ�
		}

		if (e.getKeyCode() == KeyEvent.VK_M)
			for (int i = 0; i < block.length; i++)
				System.out.println(Arrays.toString(blockPlan[i])); // �� ��ġ���� Ȯ���غ��� �뵵�� ����
		// ���߿� ���� ����

	} // KeyPressed

	@Override
	public void keyReleased(KeyEvent e) {
		stop(e.getKeyCode());
	}

	// �� Ÿ�� ��ư �Է½� ȣ�� �� �޼ҵ� ����
	public void hitBlock() {
		int xPoint = p.getX() / 40;
		int yPoint = p.getY() / 40;

		block[yPoint][xPoint].setImage();
		flagArr[yPoint][xPoint].setFlagImage(0);
		// ���� ���� ���� ���ڰ� �ƴϸ� �ֺ��� �ִ� ������ ������ �ְ�, �ƴϸ� ���ڸ� �ִ´�. �� ��� ������ �Ҹ�
		if (mine.isMine(minePosition, yPoint, xPoint) == false) {
			playBGM = new PlayMusic("Object/stone_break.mp3", false);
			playBGM.start();
			block[yPoint][xPoint].add(new MineNum(mine.getMineCount(minePosition, yPoint, xPoint)), new Integer(2)); // �ϴ�������

			if (mine.getMineCount(minePosition, yPoint, xPoint) == 0)
				linkedOpen(yPoint, xPoint);

		} else { // ���ڸ� ����� �� ?
			playBGM = new PlayMusic("Object/boom.mp3", false);
			playBGM.start();
			flagCount--;
			Game_MenuPanel.setFlagCount(getFlagCount());
			block[yPoint][xPoint].add(new mine(1), new Integer(2));
			p.setPlayerHP(p.getPlayerHP() - 1);
			Game_MenuPanel.sethpImage(p.getPlayerHP());

			if (isDefeat()) {
				System.out.println("���� �й�");
//            defeatGame();
//            new Thread(defeat).run();
				result = new result(1);
				this.add(result);
				result.setBounds(0, 0, 1400, 720);
				removeKeyListener(this);
				Game_MenuPanel.timerT.stop();
			}
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
	
	public void getItem() {
		// ������ ���
		List<String> item = new ArrayList<>();
		
		
		
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
		playBGM = new PlayMusic("Object/footstep.mp3", false);
		playBGM.start();
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

	// �¸��� �й� ���θ� �Ǵ� �� �ִ� �޼ҵ� ��
	public boolean isWin(boolean[][] mine, boolean[][] flag) {
		for (int i = 0; i < mine.length; i++)
			for (int j = 0; j < mine[i].length; j++)
				if (mine[i][j] != flag[i][j]) // ������ ��ġ�� ����� ��ġ�� ���� �ʴٸ�?
					return false;
		// ��� �迭���� ��ġ��Ұ� ��ġ�� �Ǿ��� �� true �� ��ȯ
		return true;
	} // win�޼ҵ�� ��� flag�� �� ��� �Ͽ����� ��Ȯ�ϰ� ���Ҵ���

	public boolean isDefeat() {
		if (p.getPlayerHP() == 0)
			return true;

		return false;
	}

	class result extends JPanel {
		Runnable defeat, win;

		JLabel winDe;
		Thread w_T, d_T;

		public result() {

		}

		public result(int i) {
			winDe = new JLabel();
			setSize(FRAMEXSIZE, FRAMEYSIZE);
			setLayout(new GridLayout(0, 1));
			add(winDe);

			if (i == 0) {
				System.out.println("Win Event");

				winGame();

			} else {
				System.out.println("Defeat Event");
				defeatGame();
			}
		}

		public void winGame() {
			winDe.setIcon(new ImageIcon("image/gif/YOUWIN.gif"));
		}

		// �й�
		public void defeatGame() {
			defeat = new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						int sec = 200;
						for (int i = 0; i < block.length; i++) {
							for (int j = 0; j < block[i].length; j++) {
								if (minePosition[i][j] == true && block[i][j].getBlockState() == false) {
									block[i][j].add(new mine(0), new Integer(2));
								}

							}
						}

						for (int i = 0; i < block.length; i++) {
							for (int j = 0; j < block[i].length; j++) {

								if (minePosition[i][j] == true && block[i][j].getBlockState() == false) {
									if (sec > 10)
										sec -= 10;
									Thread.sleep(sec);
									playBGM = new PlayMusic("Object/boom.mp3", false);
									playBGM.start();
				
									block[i][j].add(new mine(1), new Integer(3));
								}

							}
						}
						winDe.setIcon(new ImageIcon("image/gif/GAMEOVER (0).gif"));
						Thread.sleep(1500);
						winDe.setIcon(new ImageIcon("image/gif/GAMEOVER (1).gif"));

					} catch (InterruptedException e) {
					}

				}
			};
			d_T = new Thread(defeat);
			d_T.start();

		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}