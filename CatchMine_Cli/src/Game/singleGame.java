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

public class singleGame extends JPanel implements KeyListener { // 싱글
	final static int FRAMEXSIZE = 1440;
	final static int FRAMEYSIZE = 900;
	final static int GAMEXSIZE = 1400;
	final static int GAMEYSIZE = 720;

	final static int GAMEXPoint = 35;
	final static int GAMEYPoint = 18;

//   singleGame sG = this; // 싱글게임패널 자신
	PlayMusic playBGM;

	// Player 객체
	player p = new player(1, 40, 40);
//   player p2 = new player(2, 1320, 40);

	int playerX = p.getX(); // 현재 플레이어의 좌표 - 세로축
	int playerY = p.getY(); // 현재 플레이어의 좌표 - 가로축
	static int state; // 플레이어의 상태 (모션)

	// 블럭
	block bl = new block(); // block 클래스가 가지고있는 필드를 사용하기 위해서 생성, 필요에 의해서 삭제할수있음
	block[][] block = new block[GAMEYPoint][GAMEXPoint]; // 실제 블럭이 만들어질 배열
	// 지뢰
	mine mine = new mine(); // mine 클래스에 있는 메소드를 사용하기 위해 생성
	boolean[][] minePosition = new boolean[GAMEYPoint][GAMEXPoint]; // 지뢰가 배치될 위치를 선정해주기 위해 만든 2차원배열
	static int mineCount = 30; // 지뢰가 들어갈 갯수, 차후 Mune_Single 에서 난이도 설정을 통해 다른 값을 받게할 예정

	// 깃발 생성
	flag[][] flagArr = new flag[GAMEYPoint][GAMEXPoint];
	boolean[][] flagPosition = new boolean[GAMEYPoint][GAMEXPoint]; // 깃발이 꽂혔는지 안꽂혔는지 확인
	int flagCount = mineCount; // 깃발은 지뢰의 갯수만큼만 제공해야 한다.

	int[][] blockPlan = new int[GAMEYPoint][GAMEXPoint]; // 전체맵의 배치된 요소들의 현황을 담아 둠

	result result = new result();
//   result result;

	public singleGame() {
		setLayout(null);
		this.add(p);

//		Main.backgroundMusic = new PlayMusic("gameMusic.mp3", true);
//		Main.backgroundMusic.start();

		// player의 초기 위치를 잡아줌
		p.setBounds(playerX, playerY, 40, 40);

		// block에 대한 모든 초기 상태를 정의하고 패널에 입력해줌
		bl.initBlock(this, block);
		initFlag();

		// 지뢰의 위치를 선정해주는 메소드
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

	public int getFlagCount() { // 기본은 지뢰의 갯수만큼 이지 만 맵에서 꽂힌 깃발수를 제외해야함.
		int usingFlag = 0; // 사용한 갯수를 flagPosition을 검사하면서 증가시킬예정

		for (int i = 0; i < 18; i++)
			for (int j = 0; j < 35; j++)
				if (flagPosition[i][j] == true)
					usingFlag++;

		return this.flagCount - usingFlag; // 주어진 깃발의 갯수 - 사용한 갯수
	}

	// 지뢰가 있는 위치를 2차원배열에 정해준 지뢰의 갯수만큼 랜덤하게 담는다.
	public void generateMine(boolean[][] bool) {
		int count = 0;
		int imsi = 0;
		while (count < mineCount) {
			int x = (int) (Math.random() * bool.length);
			int y = (int) (Math.random() * bool[x].length);

			// 블럭에 지뢰가 없고, 테두리가 아니면 지뢰를 추가하고 지뢰의 갯수를 늘림
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
					block[i][j].add(flagArr[i][j], new Integer(100)); // 생성하면서 블럭마다 깃발을가지게함
			}

	}

	public void genMap() {
		for (int i = 0; i < block.length; i++)
			for (int j = 0; j < block[i].length; j++)
				if ((i == 0 || j == 0) || (i == 17 || j == 34)) // 벽
					blockPlan[i][j] = 11;
				else if (minePosition[i][j] == false)
					blockPlan[i][j] = mine.getMineCount(minePosition, i, j); // 지뢰의 갯수
				else
					blockPlan[i][j] = 10; // 지뢰
	}

	// s 키를 누르면 나올 메소드를 정의, 누를 시 깃발을 꽂음
	public void putFlag() {
		int xPoint = p.getX() / 40;
		int yPoint = p.getY() / 40;

		System.out.println(flagPosition[yPoint][xPoint]);

		if (flagPosition[yPoint][xPoint] == false && block[yPoint][xPoint].getBlockState() != true
				&& (flagArr[yPoint][xPoint].getFlagShape() == 0)) {
			block[yPoint][xPoint].setBlockState(true); // 깃발이 꽂힌블럭은 열어볼 수 없게 방문여부를 true

			flagPosition[yPoint][xPoint] = true; // 깃발이 있음
			flagArr[yPoint][xPoint].setFlagShape(1);
			flagArr[yPoint][xPoint].setFlagImage(1);

		} else if (flagArr[yPoint][xPoint].getFlagShape() == 1 && flagPosition[yPoint][xPoint] == true) {// 깃발을 꽂았는데 다시
			// 눌렀을때 -> ?
			// 표시로 바뀜
			// 이때는 블럭을
			// 건들일 수 있다.
			block[yPoint][xPoint].setBlockState(false);

			flagPosition[yPoint][xPoint] = false;

			flagArr[yPoint][xPoint].setFlagShape(2);
			flagArr[yPoint][xPoint].setFlagImage(2); // ? 이미지로 변경

		} else { // ?상태도 없앰
			flagPosition[yPoint][xPoint] = false;

			flagArr[yPoint][xPoint].setFlagShape(0);
			flagArr[yPoint][xPoint].setFlagImage(0);

		}

	}

	private long prevTime = 0; // 딜레이

	@Override
	public void keyPressed(KeyEvent e) {
		int xPoint = p.getX() / 40;
		int yPoint = p.getY() / 40;

		long curTime = System.currentTimeMillis() - prevTime; // 쿨타임 계산용

		if (curTime > 35) { // 쿨타임 0.035초 , 아주 잠깐의 끊기는 느낌만 주면 된다.
			move(e.getKeyCode());

			prevTime = System.currentTimeMillis();
		}

		// A키를 입력 + 그 위치 블럭이 선택되지 않았다면, 블럭을 부심
		if (e.getKeyCode() == KeyEvent.VK_A && block[yPoint][xPoint].getBlockState() != true) {
			state = 10;
			p.setImage(state);
			hitBlock();
		}

		// S키는 블럭에 깃발 or ? 를 놓을 수 있다.
		if (e.getKeyCode() == KeyEvent.VK_S) {
			if (getFlagCount() > 0) // 사용 가능한 깃발이 남아 있으면
				putFlag();

			if (isWin(minePosition, flagPosition)) {
				System.out.println("게임에 승리하셨습니다!");
				result = new result(0);

				this.add(result);
				this.remove(p);
				removeKeyListener(this);
				result.setBounds(0, 0, 1400, 720);
				Game_MenuPanel.timerT.stop(); // 승리시에도 클리어타임 체크를 위해 타이머를 종료
			}

			Game_MenuPanel.setFlagCount(getFlagCount()); // 메뉴패널에 숫자를 띄울 수 있게
		}

		if (e.getKeyCode() == KeyEvent.VK_M)
			for (int i = 0; i < block.length; i++)
				System.out.println(Arrays.toString(blockPlan[i])); // 블럭 배치도를 확인해보는 용도로 만듬
		// 나중엔 지울 예정

	} // KeyPressed

	@Override
	public void keyReleased(KeyEvent e) {
		stop(e.getKeyCode());
	}

	// 블럭 타격 버튼 입력시 호출 될 메소드 정의
	public void hitBlock() {
		int xPoint = p.getX() / 40;
		int yPoint = p.getY() / 40;

		block[yPoint][xPoint].setImage();
		flagArr[yPoint][xPoint].setFlagImage(0);
		// 내가 밟은 땅이 지뢰가 아니면 주변에 있는 지뢰의 갯수를 넣고, 아니면 지뢰를 넣는다. 이 경우 라이프 소모
		if (mine.isMine(minePosition, yPoint, xPoint) == false) {
			playBGM = new PlayMusic("Object/stone_break.mp3", false);
			playBGM.start();
			block[yPoint][xPoint].add(new MineNum(mine.getMineCount(minePosition, yPoint, xPoint)), new Integer(2)); // 일단찍은곳

			if (mine.getMineCount(minePosition, yPoint, xPoint) == 0)
				linkedOpen(yPoint, xPoint);

		} else { // 지뢰를 밟았을 시 ?
			playBGM = new PlayMusic("Object/boom.mp3", false);
			playBGM.start();
			flagCount--;
			Game_MenuPanel.setFlagCount(getFlagCount());
			block[yPoint][xPoint].add(new mine(1), new Integer(2));
			p.setPlayerHP(p.getPlayerHP() - 1);
			Game_MenuPanel.sethpImage(p.getPlayerHP());

			if (isDefeat()) {
				System.out.println("게임 패배");
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

	// 선택한 블럭주변에 지뢰가 없으면 인접 블럭을 같이 여는 메소드
	public void linkedOpen(int x, int y) {
		// x,y는 타격한 내 현재 위치를 가진다, 반복은 x-1~x+1 까지 , y-1 ~ y+1 까지 해야한다..
		// x에 높이(yPoint) , y에 너비(xPoint)를 넣었다.

		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				if ((i == x && j == y) || (i < 1 || j < 1 || i > 16 || j > 33) || mine.isMine(minePosition, i, j)
						|| block[i][j].getBlockState()) { // 좌표는 테두리, 기준점이거나 , 위치에 지뢰가 있으면
					continue;
				} else if (mine.getMineCount(minePosition, i, j) == 0) { // 선택된 블럭주변에 지뢰가 없을때 이부분에서 재귀적으로 함수를 호출
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
		// 아이템 드랍
		List<String> item = new ArrayList<>();
		
		
		
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
		playBGM = new PlayMusic("Object/footstep.mp3", false);
		playBGM.start();
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

	// 승리와 패배 여부를 판단 해 주는 메소드 둘
	public boolean isWin(boolean[][] mine, boolean[][] flag) {
		for (int i = 0; i < mine.length; i++)
			for (int j = 0; j < mine[i].length; j++)
				if (mine[i][j] != flag[i][j]) // 지뢰의 위치와 깃발의 위치가 같지 않다면?
					return false;
		// 모든 배열이의 배치요소가 매치가 되었을 때 true 를 반환
		return true;
	} // win메소드는 모든 flag를 다 사용 하였을때 정확하게 놓았는지

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

		// 패배
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