package Game;

import java.awt.Color;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	// 게임요소들을 담고 있는 패널
	Game_MenuPanel menu;
	singleGame single;

	public GamePanel() {
		this.setBackground(Color.darkGray);
		this.setLayout(null);

		setSize(single.FRAMEXSIZE, single.FRAMEYSIZE);

		single = new singleGame(); // 싱글 게임 클래스

		single.setBounds(20, 140, single.GAMEXSIZE, single.GAMEYSIZE);
		menu = new Game_MenuPanel();
		add(single);
		add(menu);
		menu.setBounds(20, 20, menu.MENUXSIZE, menu.MENUYSIZE);

	}

}
