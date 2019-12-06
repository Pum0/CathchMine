package Game;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
// 게임요소 집어 넣는 패널
	Game_MenuPanel menu;
	singleGame single;

	public GamePanel() {
		this.setLayout(null);

		setSize(single.FRAMEXSIZE, single.FRAMEYSIZE);

		single = new singleGame(); // 싱글 게임 클래스

		single.setBounds(20, 160, single.GAMEXSIZE, single.GAMEYSIZE);
		menu = new Game_MenuPanel();
		add(single);
		add(menu);
		menu.setBounds(20, 20, menu.MENUXSIZE, menu.MENUYSIZE);

	}

}
