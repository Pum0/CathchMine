package Game;

import javax.swing.JFrame;

public class Game extends JFrame {
	singleGame single;
	Game_MenuPanel menu;

	public Game() {

		single = new singleGame(); // 싱글 게임 클래스

		single.setBounds(20, 160, single.FRAMEXSIZE, single.FRAMEYSIZE);
		menu = new Game_MenuPanel();
		add(single);
		add(menu);
		menu.setBounds(20, 20, menu.MENUXSIZE, menu.MENUYSIZE);

		setTitle("Catch-Mine Game");
		setSize(single.FRAMEXSIZE, single.FRAMEYSIZE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

	}

	public static void main(String[] args) {
		new Game();
	}

}
