package Game;

import java.awt.Color;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	// ���ӿ�ҵ��� ��� �ִ� �г�
	Game_MenuPanel menu;
	singleGame single;

	public GamePanel() {
		this.setBackground(Color.darkGray);
		this.setLayout(null);

		setSize(single.FRAMEXSIZE, single.FRAMEYSIZE);

		single = new singleGame(); // �̱� ���� Ŭ����

		single.setBounds(20, 140, single.GAMEXSIZE, single.GAMEYSIZE);
		menu = new Game_MenuPanel();
		add(single);
		add(menu);
		menu.setBounds(20, 20, menu.MENUXSIZE, menu.MENUYSIZE);

	}

}
