package Graphics;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import Control.GameObject;

class point {

	private int x, y;

	public point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return String.format("<%d , %d>", x, y);
	}
}

public class Player extends GameObject {

	private int state = 0;

	private Animation back;
	private Animation b_standby;
	private Animation left;
	private Animation l_standby;
	private Animation right;
	private Animation r_standby;
	private Animation down;
	private Animation down_standby;

	public Player(float x, float y) throws SlickException {
		super(x, y);
	}

	@Override
	public void init() throws SlickException {
		// S Ű �Է½�
		down = new Animation(new SpriteSheet(new Image("image/Game_Character/1P_Front_Move.png"), 35, 35), 300);
		down_standby = new Animation(new SpriteSheet(new Image("image/Game_Character/1P_Front_Standby.png"), 35, 35),
				300);
		// A Ű �Է½�
		left = new Animation(new SpriteSheet(new Image("image/Game_Character/1P_Left_Move.png"), 35, 35), 300);
		l_standby = new Animation(new SpriteSheet(new Image("image/Game_Character/1P_Left_Standby.png"), 35, 35), 300);

		// D Ű �Է½�
		right = new Animation(new SpriteSheet(new Image("image/Game_Character/1P_Right_Move.png"), 35, 35), 300);
		r_standby = new Animation(new SpriteSheet(new Image("image/Game_Character/1P_Right_Standby.png"), 35, 35), 300);

		// W Ű �Է½�
		back = new Animation(new SpriteSheet(new Image("image/Game_Character/1P_Back_move.png"), 35, 35), 300);
		b_standby = new Animation(new SpriteSheet(new Image("image/Game_Character/1P_Back_Standby.png"), 35, 35), 300);

	}

	public int hitBlock(boolean[] keys) throws SlickException {
		// UP
		if (keys[4]) {
			return 1;
		}
		// Down
		if (keys[5]) {
			return 2;
		}
		// Left
		if (keys[6]) {
			return 3;
		}
		// Right
		if (keys[7]) {
			return 4;
		}
		else
			return 0;
		
		
		// ���� �� ���ǿ� state �� �߰��ϸ� ����� �ϴ� ��� ������ ������
		
	}

	public void move(boolean[] keys) throws SlickException {

		outOfrange();

		if (keys[0]) {
			this.setY(this.getY() - 1f);
			state = 1;
		} else if (state == 1) {
			state = 5;
			back.restart();
		}
		if (keys[1]) {
			this.setY(this.getY() + 1f);
			state = 2;
		} else if (state == 2) {
			state = 6;
			down.restart();
		}
		if (keys[2]) {
			state = 3;
			this.setX(this.getX() - 1f);
		} else if (state == 3) {
			state = 7;
			left.restart();
		}
		if (keys[3]) {
			this.setX(this.getX() + 1f);
			state = 4;
		} else if (state == 4) {
			state = 8;
			right.restart();
		}

	}

	// ����â �ٱ����� ���������ϴ� �κ�
	public void outOfrange() {

		if (this.getX() < 0) {
			this.setX(0);
		}
		if (this.getX() + down_standby.getWidth() > mainTest.Screen_Width) {
			this.setX(mainTest.Screen_Width - down_standby.getWidth());
		}
		if (this.getY() < 0) {
			this.setY(0);
		}
		if (this.getY() + down_standby.getHeight() > mainTest.Screen_Height) {
			this.setY(mainTest.Screen_Height - down_standby.getHeight());
		}

	}

	Animation currentAni = new Animation(
			new SpriteSheet(new Image("image/Game_Character/1P_Front_Standby.png"), 35, 35), 500);;

	// ���¿� �´� ����� ���ϰ� ��
	public Animation getCurrentAnimation() {

		if (state == 1) {
			currentAni = back;
			return back;
		} else if (state == 2) {
			currentAni = down;
			return down;
		} else if (state == 3) {
			currentAni = left;
			return left;
		} else if (state == 4) {
			currentAni = right;
			return right;
		} else if (state == 5) {
			currentAni = b_standby;
			return b_standby;
		} else if (state == 6) {
			currentAni = down_standby;
			return down_standby;
		} else if (state == 7) {
			currentAni = l_standby;
			return l_standby;
		} else if (state == 8) {
			currentAni = r_standby;
			return r_standby;
		} else
			return currentAni;

	}

	// ������ ���¸� ���ڷ� ��ȯ
	public int getState() {
		return state;
	}

	public int myXpoint() {
		return (int) (this.getX()+20) / 40;
	}

	public int myYpoint() {
		return (int) (this.getY()+20) / 40;
	}

}