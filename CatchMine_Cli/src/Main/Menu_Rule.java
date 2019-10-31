package Main;


import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class Menu_Rule extends JPanel {
	JPanel mainPanel;
	JButton backButton;
	Design de = new Design();

	public Menu_Rule() {
		setSize(400, 600);
		setLayout(null);

		mainPanel = new JPanel();
		mainPanel.setBounds(40, 40, 300, 400);

		backButton = new JButton("뒤로가기", de.setButton());
		backButton.setHorizontalTextPosition(SwingConstants.CENTER);
		backButton.setFont(de.font);
		backButton.setBounds(140, 460, 100, 40);
		
		add(backButton);
		add(mainPanel);
		add(de.setBackground());
	}
}
