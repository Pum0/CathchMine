package Game;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class singleGame extends JPanel implements KeyListener { // 싱글
	final static int FRAMEXSIZE = 1440;
	final static int FRAMEYSIZE = 900;

	final static int GAMEXSIZE = 1400;
	final static int GAMEYSIZE = 720;

//	singleGame sG = this; // 싱글게임패널 자신
	// Player 객체
	player p = new player();
	// 블럭
	block bl = new block(); // block 클래스가 가지고있는 필드를 사용하기 위해서 생성, 필요에 의해서 삭제할수있음
	block[][] block = new block[18][35]; // 실제 배치될 블럭의 배열

	// ================= 블럭 이미지 ================ //
	ImageIcon teduriImage = new ImageIcon("image/GameObject/teduri.png");
	ImageIcon blockImage = new ImageIcon("image/GameObject/block1.png");
	ImageIcon tileImage = new ImageIcon("image/GameObject/tile.png");
	// ================= 블럭 이미지 ================ //

	static int state;

	// 현재 플레이어의 좌표
	int playerX = p.getX();
	int playerY = p.getY();

	public singleGame() {
		setLayout(null);
		setBackground(Color.RED);

		this.add(p);
//		bl.setBlock(block);
		bl.initBlock(this, block);
//		bl.disposeBlock(this, block);

		p.setBounds(playerX, playerY, 40, 40);

//		for (int i = 0; i < block.length; i++)
//			for (int j = 0; j < block[i].length; j++)
//				add(block[i][j]);

		this.setFocusable(true);

		this.addKeyListener(this);

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
//			state = 10;
//			p.setState(state);
			hitBlock();

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

		state = 10;
		p.setState(state);

		block[yPoint][xPoint].revalidate();
		block[yPoint][xPoint].setImage();
		block[yPoint][xPoint].setBlockState(true);

//		System.out.println("캐릭터 위치의 블럭이 선택 되었는지 ? : " + bl[yPoint][xPoint].getBlockState());
	}

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

}
