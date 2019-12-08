package Scenes;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Grahpics.Design;
import MyListener.Action;
import MyListener.Key;
import MyListener.Mouse;

public class Menu_Main extends JPanel {
	public JButton[] mainBtn;
	private String menu[] = { "싱글게임", "멀티게임", "게임방법", "옵션" };

	Action al = new Action();
	Key kl = new Key();
	Mouse ml = new Mouse();
	Design de = new Design();

	public Menu_Main() {
		setSize(400, 600);
		setLayout(null);

		mainBtn = new JButton[4];
		for (int i = 0; i < mainBtn.length; i++) {
			mainBtn[i] = new JButton(menu[i], new ImageIcon("image/button/200x50.png"));
			mainBtn[i].setHorizontalTextPosition(SwingConstants.CENTER);
			mainBtn[i].setFont(de.setFont(14));
			mainBtn[i].setSize(200, 50);
			mainBtn[i].setBorderPainted(false);
			add(mainBtn[i]);
		}

		// 버튼 위치 지정
		mainBtn[0].setLocation(90, 100);
		mainBtn[1].setLocation(90, 200);
		mainBtn[2].setLocation(90, 300);
		mainBtn[3].setLocation(90, 400);

		add(de.setBackground());

		// 메뉴 패널
		for (int i = 0; i < mainBtn.length; i++) {
			mainBtn[i].addActionListener(al);
			mainBtn[i].addMouseListener(ml);
		}
	}
}
