import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MainLogin extends JPanel {
	JPanel loginPanel, loginTop, loginBottom;
	JButton loginButton, exitButton, signUpButton;
	
	JLabel idLabel = new JLabel("ID : ");
	JLabel pwLabel = new JLabel("PW : ");
	JTextField idText = new JTextField(10);
	JPasswordField pwText = new JPasswordField(10);
	
	Color panelColor = Color.LIGHT_GRAY;
	
	public MainLogin() {
		setSize(400, 600);
		setLayout(null);

		loginPanel = new JPanel();
		loginPanel.setLayout(null);
		loginPanel.setSize(200, 100);
		loginPanel.setBackground(panelColor);
		loginPanel.setLocation(100, 350);
		
		loginTop = new JPanel();
		loginTop.setLayout(null);
		loginTop.setBackground(panelColor);
		loginTop.setSize(200, 50);
		loginTop.setLocation(0, 0);
		
		idLabel.setSize(40, 20);
		idText.setSize(100, 20);
		pwLabel.setSize(40, 20);
		pwText.setSize(100, 20);
		
		idLabel.setLocation(5, 5);
		idText.setLocation(40, 5);
		pwLabel.setLocation(5, 30);
		pwText.setLocation(40, 30);
		
		loginButton = new JButton();
		loginButton.setSize(40, 45);
		loginButton.setLocation(150, 5);
		
		loginTop.add(idLabel);
		loginTop.add(pwLabel);
		loginTop.add(idText);
		loginTop.add(pwText);
		loginTop.add(loginButton);
		
		// -----------------------------------------------------------
		
		loginBottom = new JPanel();
		loginBottom.setLayout(null);
		loginBottom.setBackground(panelColor);
		loginBottom.setSize(200, 50);
		loginBottom.setLocation(0, 50);
		
		signUpButton = new JButton("SignUp");
		signUpButton.setSize(90, 30);
		signUpButton.setLocation(5, 10);
		
		exitButton = new JButton("Exit");
		exitButton.setSize(90, 30);
		exitButton.setLocation(105, 10);
		
		loginBottom.add(signUpButton);
		loginBottom.add(exitButton);
		
		loginPanel.add(loginTop);
		loginPanel.add(loginBottom);
		add(loginPanel);
		
	}

	public static void main(String[] args) {
		new MainLogin();
	}
}
