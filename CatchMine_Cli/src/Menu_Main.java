import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu_Main extends JPanel {
	JButton[] mainBtn;
	private String menu[] = { "Single", "Multi", "Rule", "Option" };

	public Menu_Main() {
		setSize(400, 600);
		setLayout(null);
		
		mainBtn = new JButton[4];
		for (int i = 0; i < mainBtn.length; i++) {
			mainBtn[i] = new JButton(menu[i]);
			mainBtn[i].setSize(200, 50);
			add(mainBtn[i]);
		}

		// 버튼 위치 지정
		mainBtn[0].setLocation(90, 100);
		mainBtn[1].setLocation(90, 200);
		mainBtn[2].setLocation(90, 300);
		mainBtn[3].setLocation(90, 400);
		
	}
}
