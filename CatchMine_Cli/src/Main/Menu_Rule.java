package Main;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Menu_Rule extends JPanel {
	
	Design de = new Design();

	public Menu_Rule() {
		setSize(400, 600);
		setLayout(null);

		add(de.setBackground());
	}
}
