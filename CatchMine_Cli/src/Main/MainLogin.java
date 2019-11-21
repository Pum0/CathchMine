package Main;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class MainLogin extends JPanel {
	JPanel loginPanel, loginBottom;
//	JButton loginButton, exitButton, signUpButton;

	JButton loginButton[];
	private String button[] = { "", "회원가입", "나가기" };

	JLabel logoLabel;
	JLabel idLabel = new JLabel("ID : ");
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
		loginPanel.setLayout(null);
		loginPanel.setBounds(100, 350, 200, 100);
		loginPanel.setBackground(panelColor);
		loginPanel.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		
		idLabel.setFont(de.font);
		idText.setFont(de.font);
		pwLabel.setFont(de.font);
		pwText.setFont(de.font);

		idLabel.setBounds(5, 5, 40, 20);
		idText.setBounds(40, 5, 100, 20);
		pwLabel.setBounds(5, 30, 40, 20);
		pwText.setBounds(40, 30, 100, 20);


		loginButton = new JButton[3];
		loginButton[0] = new JButton(new ImageIcon("image/button/40x45.png"));
		loginButton[0].setBounds(150, 5, 40, 45);

		loginPanel.add(idLabel);
		loginPanel.add(pwLabel);
		loginPanel.add(idText);
		loginPanel.add(pwText);
		loginPanel.add(loginButton[0]);

		// -----------------------------------------------------------


		// loginButton[0]은 사이즈랑 설정 달라서 따로 뺐음
		for (int i = 1; i < loginButton.length; i++) {
			loginButton[i] = new JButton(button[i], de.setButton());
			loginButton[i].setHorizontalTextPosition(SwingConstants.CENTER);
			loginButton[i].setFont(de.font);
			loginButton[i].setSize(90, 30);
			loginPanel.add(loginButton[i]);
		}
		loginButton[1].setLocation(5, 60);
		loginButton[2].setLocation(105, 60);

		add(loginPanel);

		add(de.setBackground());

	}
}
