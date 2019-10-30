package Graphics;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

class position {
	private int x, y;

	public position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getXposition() {
		return this.x;
	}

	public int getYposition() {
		return this.y;

	}

	@Override
	public String toString() {
		return String.format("<%d, %d>", x, y);
	}
}

public class blockBase {

	private int blockHP[][];
	private position[][] blockPosition;

	public blockBase() {

	}

	// 두 좌표를 기준으로 블럭이 살아있는지 , HP가 0이면 없는걸로 판단.
	public boolean isBlock(int i, int j) {
		if (this.blockHP[i][j] > 0)
			return true;

		return false;

	}

	// 블럭을 초기화
	public void initBlock(Image[][] b) throws SlickException {
		blockHP = new int[b.length][b[0].length];
		this.blockPosition = new position[b.length][b[0].length];

		for (int i = 0; i < b.length; i++) {
			int sizeX = 0;
			int sizeY = 0;

			for (int j = 0; j < b[i].length; j++) {
				b[i][j] = new Image("image/imsiBlock.png");

				if (i > 1 || j > 1)
					blockHP[i][j] = 3;
				else {
					blockHP[i][j] = 0;
					b[i][j] = new Image("image/Gray.png");
				}
			}
		}
	}

	// 블럭을 배치
	public void disposeBlock(Image[][] b) throws SlickException {
		int sizeX = 0;
		int sizeY = 0;

		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {

				b[i][j].draw(sizeX, sizeY);

				this.blockPosition[i][j] = new position(sizeX, sizeY);
				sizeX += 40;
			}
			sizeY += 40;
			sizeX = 0;
		}
	}

	public int getX(int i, int j) {
		return (blockPosition[i][j].getXposition());
	}

	public int getY(int i, int j) {
		return (blockPosition[i][j].getYposition());
	}

	private long prevTime = 0; // 딜레이

	public void decHp(int i, int j) {
		long curTime = System.currentTimeMillis() - prevTime; // 쿨타임 계산
		if (curTime > 300) { // 쿨타임 0.3초

			if (blockHP[i][j] > 0)
				--blockHP[i][j];

			prevTime = System.currentTimeMillis();
		}
	}

	public int getBlockStack(int i, int j) {

		return blockHP[i][j];
	}

}
