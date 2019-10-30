import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Menu_Single extends JPanel {
	JButton modeButton[];
	private String[] mode = { "쉬움", "보통", "어려움", "뒤로가기" };

	Design de = new Design();
	
	public Menu_Single() {
		setSize(400, 600);
		setLayout(null);

		modeButton = new JButton[4];
		for (int i = 0; i < modeButton.length; i++) {
			modeButton[i] = new JButton(mode[i], de.setButton());
			modeButton[i].setHorizontalTextPosition(SwingConstants.CENTER);
			modeButton[i].setFont(de.font);
			modeButton[i].setSize(200, 50);
			add(modeButton[i]);
		}

		modeButton[0].setLocation(90, 100);
		modeButton[1].setLocation(90, 200);
		modeButton[2].setLocation(90, 300);
		modeButton[3].setLocation(90, 400);
		
		add(de.setBackground());
	}

}
