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
	private boolean isAlive; // 산지 죽은지 ?
	Queue<String> itemPocket; // 먼저 얻은 아이템을 사용하기 위해서 Queue 자료구조 활용

	private int playerHP;
	// ======================= 캐릭터 이미지 ============================ //
	ImageIcon BackImage = new ImageIcon(
			"image/Game_Character/" + player_num + "P_Motion/" + player_num + "P_Back_Move.gif");
	ImageIcon FrontImage = new ImageIcon(
			"image/Game_Character/" + player_num + "P_Motion/" + player_num + "P_Front_Move.gif");
	ImageIcon LeftImage = new ImageIcon(
			"image/Game_Character/" + player_num + "P_Motion/" + player_num + "P_Left_Move.gif");
	ImageIcon RightImage = new ImageIcon(
			"image/Game_Character/" + player_num + "P_Motion/" + player_num + "P_Right_Move.gif");

	// 블럭 부시기
	ImageIcon Check = new ImageIcon(
			"image/Game_Character/" + player_num + "P_Motion/" + player_num + "P_Jump_Motion.png");

	// 가만히 있는 모션
	ImageIcon F_StandBy = new ImageIcon(
			"image/Game_Character/" + player_num + "P_Motion/" + player_num + "P_Front_Standby.gif");
	ImageIcon B_StandBy = new ImageIcon(
			"image/Game_Character/" + player_num + "P_Motion/" + player_num + "P_Back_Standby.gif");
	ImageIcon L_StandBy = new ImageIcon(
			"image/Game_Character/" + player_num + "P_Motion/" + player_num + "P_Left_Standby.gif");
	ImageIcon R_StandBy = new ImageIcon(
			"image/Game_Character/" + player_num + "P_Motion/" + player_num + "P_Right_Standby.gif");
	// ======================= 캐릭터 이미지 ============================ //

	JLabel playerlabel;
	public player() {
		// TODO Auto-generated constructor stub
	}
	public player(int p_n, int x, int y) {
		System.out.println("P" + p_n + "생성");
		setPlayer_num(p_n);

		playerlabel = new JLabel();
		this.x = x;
		this.y = y;
		this.charState = 3; // 처음 캐릭터가 생성되면 정면을 바라보고있음
		this.playerHP = 3;

		this.setLayout(new GridLayout(0, 1));
		this.setSize(40, 40);

		this.isAlive = true; // 기본적으로 생성되면 살아있다

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

	// 게임창 바깥으로 못나가게하는 부분
	public void outOfrange() {

		if (getX() < 40) { // 캐릭터의 현재 x 좌표가 벽을 지나려고 하면 벽한칸 크기 만큼 좌표조정
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
