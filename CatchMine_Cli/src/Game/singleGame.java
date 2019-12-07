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
	int mineCount = 250; // 지뢰가 들어갈 갯수, 차후 Mune_Single 에서 난이도 설정을 통해 다른 값을 받게할 예정

	public singleGame() {
		setLayout(null);

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

	// 실제 지뢰의 이미지를 넣는 메소드를 여기서 만듬
	public void disposeMine(JPanel pan) {

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

		if (e.getKeyCode() == KeyEvent.VK_Q && block[yPoint][xPoint].getBlockState() != true) {

			state = 10;
			p.setState(state);
			hitBlock();

		}

		// Mine 배열 확인용
		if (e.getKeyCode() == KeyEvent.VK_O) {
			for (int i = 0; i < minePosition.length; i++)
				System.out.println(Arrays.toString(minePosition[i]));
		}

		if (e.getKeyCode() == KeyEvent.VK_B) {
			System.out.println("주변 블럭에 있는 지뢰 갯수는 : " + mine.getMineCount(minePosition, yPoint, xPoint));
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

	// 블럭 타격 버튼 입력시 호출 될 메소드 정의
	public void hitBlock() {
		int xPoint = p.getX() / 40;
		int yPoint = p.getY() / 40;

		// isMine 메소드로 죽거나, 주변에
		System.out.println("캐릭터 위치의 블럭이 선택 되었는지 ? : " + block[yPoint][xPoint].getBlockState());
		System.out.println("선택된 블럭의 좌표 <" + block[yPoint][xPoint].getX() + ", " + block[yPoint][xPoint].getY() + ">");
		System.out.println("여기에 지뢰가 있는지?" + mine.isMine(minePosition, yPoint, xPoint));

//		block[yPoint][xPoint].revalidate();
		block[yPoint][xPoint].setImage();
		// 내가 밟은 땅이 지뢰가 아니면 주변에 있는 지뢰의 갯수를 넣고 아니면 지뢰를 넣는다
		if (mine.isMine(minePosition, yPoint, xPoint) == false)
			block[yPoint][xPoint].add(new MineNum(mine.getMineCount(minePosition, yPoint, xPoint)), new Integer(2));
		else
			block[yPoint][xPoint].add(new mine(), new Integer(2));

		block[yPoint][xPoint].setBlockState(true);

	}

	// 이동후 정지할때 나오는 모션들을 나오게 하는 메소드
	public void stop(int keyType) {
		// 방향키 위쪽 입력시
		if (keyType == KeyEvent.VK_UP) {
			state = 5; // 위
			p.setImage(state);
		}
		// 방향키 왼쪽 입력시
		if (keyType == KeyEvent.VK_LEFT) {
			state = 6;
			p.setImage(state);
		}
		// 방향키 아래 입력시
		if (keyType == KeyEvent.VK_DOWN) {
			state = 7;
			p.setImage(state);

		}
		// 방향키 오른쪽 입력시
		if (keyType == KeyEvent.VK_RIGHT) {
			state = 8;
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
	
	
	
	
	// 마찬가지로 그저, 깃발을 보여주기 위한 깃발 클래스
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
