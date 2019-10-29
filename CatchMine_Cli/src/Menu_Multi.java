import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Menu_Multi extends JPanel {
	JTextArea StandbyRoom = new JTextArea();
	JScrollPane StandbyRoomS = new JScrollPane(StandbyRoom);

	JButton backButton;

	public Menu_Multi() {
		setSize(400, 600);
		setLayout(null);

		StandbyRoomS.setSize(365, 150);
		StandbyRoomS.setLocation(10, 10);
//		StandbyRoom.setEditable(false);

		add(StandbyRoomS);
		
		backButton = new JButton("Back");
		backButton.setSize(200, 50);
		backButton.setLocation(90, 400);
		
		add(backButton);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
