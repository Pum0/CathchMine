import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu_Single extends JPanel {
	JButton modeButton[];
	private String[] mode = { "Easy", "Normal", "Hard", "Back" };

	public Menu_Single() {
		setSize(400, 600);
		setLayout(null);

		modeButton = new JButton[4];
		for (int i = 0; i < modeButton.length; i++) {
			modeButton[i] = new JButton(mode[i]);
			modeButton[i].setSize(200, 50);
			add(modeButton[i]);
		}

		modeButton[0].setLocation(90, 100);
		modeButton[1].setLocation(90, 200);
		modeButton[2].setLocation(90, 300);
		modeButton[3].setLocation(90, 400);
	}

	public static void main(String[] args) {
		new Menu_Single();
	}

}
