package Game;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Game extends JFrame {
	// 게임이 실행 될 프레임
	GamePanel game_Panel;

	public Game() {
		game_Panel = new GamePanel();

		setTitle("Catch-Mine Game");
		setSize(singleGame.FRAMEXSIZE, singleGame.FRAMEYSIZE);

		add(game_Panel);

		setBounds(0, 0, singleGame.FRAMEXSIZE, singleGame.FRAMEYSIZE);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

	}

	public static void main(String[] args) {
		new Game();
	}

}
