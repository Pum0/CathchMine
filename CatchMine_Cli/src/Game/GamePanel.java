package Game;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
// ���ӿ�� ���� �ִ� �г�
	Game_MenuPanel menu;
	singleGame single;

	public GamePanel() {
		this.setLayout(null);

		setSize(single.FRAMEXSIZE, single.FRAMEYSIZE);

		single = new singleGame(); // �̱� ���� Ŭ����

		single.setBounds(20, 160, single.GAMEXSIZE, single.GAMEYSIZE);
		menu = new Game_MenuPanel();
		add(single);
		add(menu);
		menu.setBounds(20, 20, menu.MENUXSIZE, menu.MENUYSIZE);

	}

}
