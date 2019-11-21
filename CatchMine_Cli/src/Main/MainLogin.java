package Main;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MainLogin extends JPanel {
	JPanel loginPanel, loginBottom;
//	JButton loginButton, exitButton, signUpButton;

	JButton loginButton[];
	String button[] = { "", "회원가입", "종료" };

	JLabel logoLabel, panelLabel;
	JLabel idLabel = new JLabel("ID   : ");
	JLabel pwLabel = new JLabel("PW : ");
	JTextField idText = new JTextField(10);
	JPasswordField pwText = new JPasswordField(10);

	Color panelColor = Color.LIGHT_GRAY;

	Design de = new Design();

	public MainLogin() {
		setSize(400, 600);
		setLayout(null);

		logoLabel = new JLabel(new ImageIcon("image/mainLogo.png"));
		logoLabel.setBounds(5, 110, 378, 92);
		add(logoLabel);

		loginPanel = new JPanel();
		panelLabel = new JLabel(new ImageIcon("image/300x150.png"));
		panelLabel.setBounds(0, 0, 300, 150);

		loginPanel.setLayout(null);
		loginPanel.setBounds(50, 300, 300, 150);
		loginPanel.setOpaque(false);
		loginPanel.setBorder(de.setBorder());

		idLabel.setFont(de.setFont(14));
		idText.setFont(de.setFont(14));
		pwLabel.setFont(de.setFont(14));
		pwText.setFont(de.setFont(14));

		idText.setBorder(de.setTextBorder());
		pwText.setBorder(de.setTextBorder());

		idLabel.setBounds(50, 25, 40, 20);
		idText.setBounds(85, 25, 100, 20);
		pwLabel.setBounds(50, 55, 40, 20);
		pwText.setBounds(85, 55, 100, 20);

		loginButton = new JButton[3];
		loginButton[0] = new JButton(new ImageIcon("image/button/40x50.png"));
		loginButton[0].setBorderPainted(false);
		loginButton[0].setBounds(195, 25, 45, 50);
		
		
		loginPanel.add(idLabel);
		loginPanel.add(pwLabel);
		loginPanel.add(idText);
		loginPanel.add(pwText);
		loginPanel.add(loginButton[0]);

		for (int i = 1; i < loginButton.length; i++) {
			loginButton[i] = new JButton(button[i], new ImageIcon("image/button/90x30.png"));
			loginButton[i].setHorizontalTextPosition(SwingConstants.CENTER);
			loginButton[i].setFont(de.setFont(14));
			loginButton[i].setSize(90, 30);
			loginButton[i].setBorderPainted(false);
			loginPanel.add(loginButton[i]);
		}
		loginButton[1].setLocation(50, 90);
		loginButton[2].setLocation(150, 90);
		loginPanel.add(panelLabel);

		// -----------------------------------------------------------

		add(loginPanel);

		add(de.setBackground());

	}
}
