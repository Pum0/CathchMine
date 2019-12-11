package Game;

import javax.swing.JFrame;

public class Game extends JFrame {
	// 게임이 실행 될 프레임
	GamePanel game_Panel;

	public Game() {
		game_Panel = new GamePanel();

		setTitle("Catch-Mine Game");
		setSize(singleGame.FRAMEXSIZE, singleGame.FRAMEYSIZE);
		System.out.println("게임 프레임");
		add(game_Panel);

		setBounds(0, 0, singleGame.FRAMEXSIZE, singleGame.FRAMEYSIZE);

		setResizable(false);
		setVisible(true);

	}

}
