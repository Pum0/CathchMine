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
	JPanel loginPanel, loginTop, loginBottom;
//	JButton loginButton, exitButton, signUpButton;
	
	JButton loginButton[];
	private String button[] = { "1", "SingUp", "나가기" };
	
	JLabel idLabel = new JLabel("ID : ");
	JLabel pwLabel = new JLabel("PW : ");
	JTextField idText = new JTextField(10);
	JPasswordField pwText = new JPasswordField(10);
	
	Color panelColor = Color.LIGHT_GRAY;
	
	Design de = new Design();
	
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
		
		idLabel.setFont(de.font);
		idText.setFont(de.font);
		pwLabel.setFont(de.font);
		pwText.setFont(de.font);
		
		idLabel.setSize(40, 20);
		idText.setSize(100, 20);
		pwLabel.setSize(40, 20);
		pwText.setSize(100, 20);
		
		idLabel.setLocation(5, 5);
		idText.setLocation(40, 5);
		pwLabel.setLocation(5, 30);
		pwText.setLocation(40, 30);
		
		loginButton = new JButton[3];
		loginButton[0] = new JButton(button[0], de.setButton());
		loginButton[0].setIcon(de.setButton());
		loginButton[0].setSize(40, 45);
		loginButton[0].setLocation(150, 5);
		
		loginTop.add(idLabel);
		loginTop.add(pwLabel);
		loginTop.add(idText);
		loginTop.add(pwText);
		loginTop.add(loginButton[0]);
		
		// -----------------------------------------------------------
		
		loginBottom = new JPanel();
		loginBottom.setLayout(null);
		loginBottom.setBackground(panelColor);
		loginBottom.setSize(200, 50);
		loginBottom.setLocation(0, 50);
		
		// loginButton[0]은 사이즈랑 설정 달라서 따로 뺐음
		for(int i = 1 ; i < loginButton.length ; i++) {
			loginButton[i] = new JButton(button[i], de.setButton());
			loginButton[i].setHorizontalAlignment(SwingConstants.CENTER);
			loginButton[i].setFont(de.font);
			loginButton[i].setSize(90, 30);
			loginBottom.add(loginButton[i]);
		}
		
		loginButton[1].setLocation(5, 10);
		loginButton[2].setLocation(105, 10);
//		signUpButton = new JButton("SignUp", de.setButton());
//		signUpButton.setHorizontalTextPosition(SwingConstants.CENTER);
//		signUpButton.setFont(de.font);
//		signUpButton.setContentAreaFilled(false);
//		signUpButton.setSize(90, 30);
//		
//		exitButton = new JButton("나가기", de.setButton());
//		exitButton.setHorizontalTextPosition(SwingConstants.CENTER);
//		exitButton.setFont(de.font);
//		exitButton.setSize(90, 30);
//		loginBottom.add(signUpButton);
//		loginBottom.add(exitButton);
		
		loginPanel.add(loginTop);
		loginPanel.add(loginBottom);
		add(loginPanel);
		
		add(de.setBackground());
		
	}
}
