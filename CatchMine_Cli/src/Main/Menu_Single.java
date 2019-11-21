package Main;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Menu_Single extends JPanel {
	JButton modeButton[];
	public String[] mode = { "½¬¿ò", "º¸Åë", "¾î·Á¿ò", "µÚ·Î°¡±â" };
	public String[] modeEn = { "ÆøÅº 30°³", "ÆøÅº 50°³", "ÆøÅº 70°³", "µÚ·Î°¡±â" };

	Design de = new Design();
	
	public Menu_Single() {
		setSize(400, 600);
		setLayout(null);

		modeButton = new JButton[4];
		for (int i = 0; i < modeButton.length; i++) {
			modeButton[i] = new JButton(mode[i], new ImageIcon("image/button/200x50.png"));
			modeButton[i].setHorizontalTextPosition(SwingConstants.CENTER);
			modeButton[i].setFont(de.setFont(14));
			modeButton[i].setSize(200, 50);
			modeButton[i].setBorderPainted(false);
			add(modeButton[i]);
		}

		modeButton[0].setLocation(90, 100);
		modeButton[1].setLocation(90, 200);
		modeButton[2].setLocation(90, 300);
		modeButton[3].setLocation(90, 400);
		
		add(de.setBackground());
	}

}
