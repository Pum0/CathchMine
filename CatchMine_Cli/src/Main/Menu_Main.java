package Main;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Menu_Main extends JPanel {
	JButton[] mainBtn;
	private String menu[] = { "�̱۰���", "��Ƽ����", "���ӹ��", "�ɼ�" };

	Design de = new Design();
	
	public Menu_Main() {
		setSize(400, 600);
		setLayout(null);
		
		mainBtn = new JButton[4];
		for (int i = 0; i < mainBtn.length; i++) {
			mainBtn[i] = new JButton(menu[i], de.setButton());
			mainBtn[i].setHorizontalTextPosition(SwingConstants.CENTER);
			mainBtn[i].setFont(de.setFont(14));
			mainBtn[i].setSize(200, 50);
			add(mainBtn[i]);
		}

		// ��ư ��ġ ����
		mainBtn[0].setLocation(90, 100);
		mainBtn[1].setLocation(90, 200);
		mainBtn[2].setLocation(90, 300);
		mainBtn[3].setLocation(90, 400);
		
		add(de.setBackground());
	}
}
