import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;

public class Main extends JFrame implements ActionListener {
	MainLogin mainLogin = new MainLogin();
	SignUp signUp = new SignUp();
	Menu_Main mainMenu = new Menu_Main();
	Menu_Single singleMenu = new Menu_Single();
	Menu_Multi multiMenu = new Menu_Multi();
	Menu_Option optionMenu = new Menu_Option();

	public Main() {
		setTitle("Catch-Mine");
		setSize(400, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);

		// �޴� �߰� �κ�
		add(mainLogin);
		add(signUp);
		signUp.setVisible(false);
		add(mainMenu);
		mainMenu.setVisible(false);
		add(singleMenu);
		singleMenu.setVisible(false);
		add(multiMenu);
		multiMenu.setVisible(false);
		add(optionMenu);
		optionMenu.setVisible(false);

		// �α��� �г�
		mainLogin.loginButton.addActionListener(this);
		mainLogin.signUpButton.addActionListener(this);
		mainLogin.exitButton.addActionListener(this);

		// �޴� �г�
		mainMenu.mainBtn[0].addActionListener(this);
		mainMenu.mainBtn[1].addActionListener(this);
		mainMenu.mainBtn[2].addActionListener(this);
		mainMenu.mainBtn[3].addActionListener(this);

		// �̱� �г�
		singleMenu.modeButton[0].addActionListener(this);
		singleMenu.modeButton[1].addActionListener(this);
		singleMenu.modeButton[2].addActionListener(this);
		singleMenu.modeButton[3].addActionListener(this);

		// ��Ƽ �г�
	
		
		// ȸ������ �г�
		signUp.checkButton[0].addActionListener(this);
		signUp.checkButton[1].addActionListener(this);
		signUp.checkButton[2].addActionListener(this);
		signUp.checkButton[3].addActionListener(this);
		signUp.checkButton[4].addActionListener(this);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// �α��� �׼� ������ -------------------------------
		if (e.getSource() == mainLogin.loginButton || LoginCheck()) {
			mainLogin.setVisible(false);
			mainMenu.setVisible(true);
		}

		if (e.getSource() == mainLogin.signUpButton) {
			mainLogin.setVisible(false);
			signUp.setVisible(true);
		}

		if (e.getSource() == mainLogin.exitButton)
			System.exit(0);
		// -------------------------------------------------

		// ȸ������ �׼� ������ -----------------------------
		if (e.getSource() == signUp.checkButton[4]) {
			signUp.setVisible(false);
			mainLogin.setVisible(true);
		}
		// -------------------------------------------------

		// �޴� �׼� ������ --------------------------------
		// Single Button
		if (e.getSource() == mainMenu.mainBtn[0]) {
			mainMenu.setVisible(false);
			singleMenu.setVisible(true);
		}
		
		// Multi Button -----------------------------------
		if (e.getSource() == mainMenu.mainBtn[1]) {
			mainMenu.setVisible(false);
			multiMenu.setVisible(true);
		}
		
		
		// Role Button
		if (e.getSource() == mainMenu.mainBtn[2]) {
			mainMenu.setVisible(false);
//				.setVisible(true);
		}
		// Option Button
		if (e.getSource() == mainMenu.mainBtn[3]) {
			mainMenu.setVisible(false);
			optionMenu.setVisible(true);
		}
		// ------------------------------------------------

		// �̱� �׼� ������ --------------------------------
		// EASY

		// NORMAL

		// HARD

		// BACK
		if (e.getSource() == singleMenu.modeButton[3]) {
			singleMenu.setVisible(false);
			mainMenu.setVisible(true);
		}
		// ------------------------------------------------

		// ��Ƽ �׼� ������ --------------------------------
		
		// ------------------------------------------------

		// �ɼ� �׼� ������ --------------------------------
		// ------------------------------------------------
	}

	public boolean LoginCheck() {
		if (mainLogin.idText.getText().equals("admin") && mainLogin.pwText.getText().equals("admin"))
			return true;

		return false;
	}

	public static void main(String[] args) {
		new Main();
		
		
	}

}
