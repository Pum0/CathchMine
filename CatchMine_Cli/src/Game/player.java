package Game;

import java.awt.GridLayout;
import java.awt.Image;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class player extends JPanel {
	private int player_num = 1 + getPlayer_num();
	private int charState;
	game_item item;
	private int x;
	private int y;
	private boolean isAlive; // ���� ������ ?
	Queue<String> itemPocket; // ���� ���� �������� ����ϱ� ���ؼ� Queue �ڷᱸ�� Ȱ��

	private int playerHP;
	// ======================= ĳ���� �̹��� ============================ //
	ImageIcon BackImage = new ImageIcon(
			"image/Game_Character/" + player_num + "P_Motion/" + player_num + "P_Back_Move.gif");
	ImageIcon FrontImage = new ImageIcon(
			"image/Game_Character/" + player_num + "P_Motion/" + player_num + "P_Front_Move.gif");
	ImageIcon LeftImage = new ImageIcon(
			"image/Game_Character/" + player_num + "P_Motion/" + player_num + "P_Left_Move.gif");
	ImageIcon RightImage = new ImageIcon(
			"image/Game_Character/" + player_num + "P_Motion/" + player_num + "P_Right_Move.gif");

	// �� �νñ�
	ImageIcon Check = new ImageIcon(
			"image/Game_Character/" + player_num + "P_Motion/" + player_num + "P_Jump_Motion.png");

	// ������ �ִ� ���
	ImageIcon F_StandBy = new ImageIcon(
			"image/Game_Character/" + player_num + "P_Motion/" + player_num + "P_Front_Standby.gif");
	ImageIcon B_StandBy = new ImageIcon(
			"image/Game_Character/" + player_num + "P_Motion/" + player_num + "P_Back_Standby.gif");
	ImageIcon L_StandBy = new ImageIcon(
			"image/Game_Character/" + player_num + "P_Motion/" + player_num + "P_Left_Standby.gif");
	ImageIcon R_StandBy = new ImageIcon(
			"image/Game_Character/" + player_num + "P_Motion/" + player_num + "P_Right_Standby.gif");
	// ======================= ĳ���� �̹��� ============================ //

	JLabel playerlabel;
	public player() {
		// TODO Auto-generated constructor stub
	}
	public player(int p_n, int x, int y) {
		System.out.println("P" + p_n + "����");
		setPlayer_num(p_n);

		playerlabel = new JLabel();
		this.x = x;
		this.y = y;
		this.charState = 3; // ó�� ĳ���Ͱ� �����Ǹ� ������ �ٶ󺸰�����
		this.playerHP = 3;

		this.setLayout(new GridLayout(0, 1));
		this.setSize(40, 40);

		this.isAlive = true; // �⺻������ �����Ǹ� ����ִ�

		this.setOpaque(false);

		playerlabel.setIcon(F_StandBy);
		this.add(playerlabel);

		this.itemPocket = new LinkedList<>();

	}

	public void setPlayer_num(int player_num) {
		this.player_num = player_num;
	}

	public int getPlayer_num() {
		return player_num;
	}

	public void LocationSet(int x, int y) {
		setX(x);
		setY(y);

		this.setLocation(x, y);

	}

	// ����â �ٱ����� ���������ϴ� �κ�
	public void outOfrange() {

		if (getX() < 40) { // ĳ������ ���� x ��ǥ�� ���� �������� �ϸ� ����ĭ ũ�� ��ŭ ��ǥ����
			LocationSet(40, getY());
			repaint();
		}
		if (getX() + getWidth() > multiGame.GAMEXSIZE - 40) {
			LocationSet(multiGame.GAMEXSIZE - 80, getY());
			repaint();
		}
		if (getY() < 40) {
			LocationSet(getX(), 40);
			repaint();
		}
		if (getY() + getHeight() > multiGame.GAMEYSIZE - 40) {
			LocationSet(getX(), multiGame.GAMEYSIZE - 80);
			repaint();
		}

	}

	public void setState(int state) {
		charState = state;

	}

	public void setImage(int State) {

		if (State == 1)
			playerlabel.setIcon(BackImage);
		if (State == 2)
			playerlabel.setIcon(LeftImage);
		if (State == 3)
			playerlabel.setIcon(FrontImage);
		if (State == 4)
			playerlabel.setIcon(RightImage);

		if (State == 5)
			playerlabel.setIcon(B_StandBy);
		if (State == 6)
			playerlabel.setIcon(L_StandBy);
		if (State == 7)
			playerlabel.setIcon(F_StandBy);
		if (State == 8)
			playerlabel.setIcon(R_StandBy);
		if (State == 10)
			playerlabel.setIcon(Check);

	}

	public int getX() {
		return x;
	}

	public void setX(int locationX) {
		this.x = locationX;
	}

	public int getY() {
		return y;
	}

	public void setY(int locationY) {
		this.y = locationY;
	}

	public int getPlayerHP() {
		return playerHP;
	}

	public void setPlayerHP(int playerHP) {
		this.playerHP = playerHP;
	}

}
