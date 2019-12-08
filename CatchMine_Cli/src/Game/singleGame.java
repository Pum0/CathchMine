package Game;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class singleGame extends JPanel implements KeyListener { // 싱글
	final static int FRAMEXSIZE = 1440;
	final static int FRAMEYSIZE = 900;

	final static int GAMEXSIZE = 1400;
	final static int GAMEYSIZE = 720;

//	singleGame sG = this; // 싱글게임패널 자신
	// Player 객체
	player p = new player();
	int playerX = p.getX(); // 현재 플레이어의 좌표
	int playerY = p.getY(); // 현재 플레이어의 좌표
	static int state; // 플레이어의 상태

	// 블럭
	block bl = new block(); // block 클래스가 가지고있는 필드를 사용하기 위해서 생성, 필요에 의해서 삭제할수있음
	block[][] block = new block[18][35]; // 실제 블럭이 만들어질 배열
	// 지뢰
	mine mine = new mine(); // mine 클래스에 있는 메소드를 사용하기 위해 생성
	boolean[][] minePosition = new boolean[18][35]; // 지뢰가 배치될 위치를 선정해주기 위해 만든 2차원배열
	int mineCount = 100; // 지뢰가 들어갈 갯수, 차후 Mune_Single 에서 난이도 설정을 통해 다른 값을 받게할 예정

	// 깃발 생성
	flag flag = new flag();
	flag[][] flagArr = new flag[18][35];
	boolean[][] flagPosition = new boolean[18][35]; // 깃발이 꽂혔는지 안꽂혔는지 확인
	int flagCount = mineCount; // 깃발은 지뢰의 갯수만큼 제공한다.

	public singleGame() {
		setLayout(null);
		initFlag();
		this.add(p);
		p.setBounds(playerX, playerY, 40, 40);
		// block에 대한 모든 초기 상태를 정의하고 패널에 입력해줌
		bl.initBlock(this, block);
		// player의 초기 위치를 잡아줌
		// 지뢰의 위치를 선정해주는 메소드
		generateMine(minePosition);

		this.setFocusable(true);
		this.addKeyListener(this);
	}

	public int getMineCount() {
		return this.mineCount;
	}

	public int getFlagCount() {
		return this.flagCount;
	}

	// 지뢰가 있는 위치를 2차원배열에 정해준 지뢰의 갯수만큼 랜덤하게 담는다.
	public void generateMine(boolean[][] bool) {
		int count = 0;
		int imsi = 0;
		while (count < mineCount) {
			imsi++;
			int x = (int) (Math.random() * bool.length);
			int y = (int) (Math.random() * bool[x].length);

			System.out.println(imsi);
			// 블럭에 지뢰가 없고, 테두리가 아니면 지뢰를 추가하고 지뢰의 갯수를 늘림
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

	// s 키를 누르면 나올 메소드를 정의, 누를 시 깃발을 꽂음
	public void putFlag() {
		int xPoint = p.getX() / 40;
		int yPoint = p.getY() / 40;

		System.out.println(flag.isFlag(flagPosition, yPoint, xPoint) == false);
		if (flag.isFlag(flagPosition, yPoint, xPoint) == false) {
			block[yPoint][xPoint].setBlockState(true); // 깃발이 꽂힌블럭은 열어볼 수 없게 방문여부를 true

			flagPosition[yPoint][xPoint] = true;
			flagArr[yPoint][xPoint].setFlagImage(0);

			block[yPoint][xPoint].add(flagArr[yPoint][xPoint], new Integer(2));
		} else { // 깃발을 꽂았는데 다시 눌렀을때
			block[yPoint][xPoint].setBlockState(false);

			flagPosition[yPoint][xPoint] = false;
			flagArr[yPoint][xPoint].setFlagImage(1);

			block[yPoint][xPoint].add(flagArr[yPoint][xPoint], new Integer(2));
		}

	}

	private long prevTime = 0; // 딜레이

	@Override
	public void keyPressed(KeyEvent e) {
		int xPoint = p.getX() / 40;
		int yPoint = p.getY() / 40;

		long curTime = System.currentTimeMillis() - prevTime; // 쿨타임 계산
		if (curTime > 35) { // 쿨타임 0.1초
			move(e.getKeyCode());

			prevTime = System.currentTimeMillis();
		}

		if (e.getKeyCode() == KeyEvent.VK_A && block[yPoint][xPoint].getBlockState() != true) {

			state = 10;
			p.setImage(state);
			hitBlock();

		}

		if (e.getKeyCode() == KeyEvent.VK_S) {
			putFlag();
		}

		// Mine 배열 확인용
		if (e.getKeyCode() == KeyEvent.VK_O)

		{
			for (int i = 0; i < minePosition.length; i++)
				System.out.println(Arrays.toString(minePosition[i]));
		}

		if (e.getKeyCode() == KeyEvent.VK_B) {
			System.out.println("주변 블럭에 있는 지뢰 갯수는 : " + mine.getMineCount(minePosition, yPoint, xPoint));
		}

		if (e.getKeyCode() == KeyEvent.VK_C) {
			int[][] numArr = new int[18][35];

			for (int i = 0; i < block.length; i++)
				for (int j = 0; j < block[i].length ; j++)
					if ((i == 0 || j == 0) || (i == 17 || j == 34))
						numArr[i][j] = 11;
					else if (minePosition[i][j] == false)
						numArr[i][j] = mine.getMineCount(minePosition, i, j);
					else
						numArr[i][j] = 10;

			for (int i = 0; i < block.length; i++)
				System.out.println(Arrays.toString(numArr[i]));
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

	// 블럭 타격 버튼 입력시 호출 될 메소드 정의
	public void hitBlock() {
		int xPoint = p.getX() / 40;
		int yPoint = p.getY() / 40;

		// isMine 메소드로 죽거나, 주변에
		System.out.println("캐릭터 위치의 블럭이 선택 되었는지 ? : " + block[yPoint][xPoint].getBlockState());
		System.out.println("선택된 블럭의 좌표 <" + block[yPoint][xPoint].getX() + ", " + block[yPoint][xPoint].getY() + ">");
		System.out.println("여기에 지뢰가 있는지?" + mine.isMine(minePosition, yPoint, xPoint));

		block[yPoint][xPoint].setImage();

		// 내가 밟은 땅이 지뢰가 아니면 주변에 있는 지뢰의 갯수를 넣고, 아니면 지뢰를 넣는다. 이 경우 게임 패배
		if (mine.isMine(minePosition, yPoint, xPoint) == false) {
			block[yPoint][xPoint].add(new MineNum(mine.getMineCount(minePosition, yPoint, xPoint)), new Integer(2)); // 일단찍은곳
			linkedOpen(yPoint, xPoint);
		} else {
			block[yPoint][xPoint].add(new mine(1), new Integer(2));
			defeatGmae(minePosition, block);
		}
		block[yPoint][xPoint].setBlockState(true);

	}

	public void linkedOpen(int x, int y) {
		int[][] open = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		// -1,0 위로 , 1,0 아래로, 0,-1 왼쪽으로, 0,1 오른쪽으로
		int startX = x;
		int startY = y;

		// 동 서 남 북 순으로 숫자를 만날때 까지 재귀 호출 하자.
		if (x > 1 && (mine.getMineCount(minePosition, x, y) == 0)) {
			linkedOpen(x - 1, y);
			block[x][y].setImage();
			block[x][y].add(new MineNum(mine.getMineCount(minePosition, x, y)), new Integer(2));

		} else if ((x < startX && startX < 16) && (mine.getMineCount(minePosition, x, y) == 0)) {
			linkedOpen(x + 1, y);
			block[x][y].setImage();
			block[x][y].add(new MineNum(mine.getMineCount(minePosition, x, y)), new Integer(2));

		}

		if (mine.getMineCount(minePosition, x, y) != 0) {
			block[x][y].setImage();
			block[x][y].add(new MineNum(mine.getMineCount(minePosition, x, y)), new Integer(2));
			return;
		}
	}

	// 이동후 정지할때 나오는 모션들을 나오게 하는 메소드
	public void stop(int keyType) {
		int prevMotion = 7;
		// 방향키 위쪽 입력시
		if (keyType == KeyEvent.VK_UP) {
			state = 5; // 위
			p.setImage(state);
			prevMotion = state;
		}
		// 방향키 왼쪽 입력시
		if (keyType == KeyEvent.VK_LEFT) {
			state = 6;
			p.setImage(state);
			prevMotion = state;
		}
		// 방향키 아래 입력시
		if (keyType == KeyEvent.VK_DOWN) {
			state = 7;
			p.setImage(state);
			prevMotion = state;
		}
		// 방향키 오른쪽 입력시
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

	// 이동만을 다루는 메소드
	public void move(int keyType) {

		// 방향키 위쪽 입력시
		if (keyType == KeyEvent.VK_UP) {
			state = 1; // 위
			p.setImage(state);

			p.LocationSet(playerX, playerY -= 40);
			p.outOfrange();

		}
		// 방향키 왼쪽 입력시
		if (keyType == KeyEvent.VK_LEFT) {
			state = 2;
			p.setImage(state);

			p.LocationSet(playerX -= 40, playerY);

			p.outOfrange();

		}
		// 방향키 아래 입력시
		if (keyType == KeyEvent.VK_DOWN) {
			state = 3;
			p.setImage(state);

			p.LocationSet(playerX, playerY += 40);

			p.outOfrange();

		}
		// 방향키 오른쪽 입력시
		if (keyType == KeyEvent.VK_RIGHT) {
			state = 4;
			p.setImage(state);

			p.LocationSet(playerX += 40, playerY);
			p.outOfrange();

		}

	}

	// 그저 지뢰의 갯수를 나타낼 이미지를 가지고 있는 패널
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

	// 지뢰를 밟을 경우 나올 메소드
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

}
