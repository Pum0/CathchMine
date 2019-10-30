package Main;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;

public class Main extends JFrame implements ActionListener {
	MainLogin mainLogin = new MainLogin();
	Menu_Main mainMenu = new Menu_Main();
	Menu_Single singleMenu = new Menu_Single();
	Menu_Multi multiMenu = new Menu_Multi();
	Menu_Rule ruleMenu = new Menu_Rule();
	Menu_Option optionMenu = new Menu_Option();
	SignUp signUp = new SignUp();

	public Main() {
		setTitle("Catch-Mine");
		setSize(400, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);

		// �޴� �߰� �κ�
		add(mainLogin);
		
		signUp.setVisible(false);
		
		add(mainMenu);
		mainMenu.setVisible(false);
		add(singleMenu);
		singleMenu.setVisible(false);
		add(multiMenu);
		multiMenu.setVisible(false);
		add(ruleMenu);
		ruleMenu.setVisible(false);
		add(optionMenu);
		optionMenu.setVisible(false);

		// �α��� �г�
		mainLogin.loginButton.addActionListener(this);
		mainLogin.signUpButton.addActionListener(this);
		mainLogin.exitButton.addActionListener(this);
		
		// ȸ������ �г�

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
		multiMenu.multiButton[0].addActionListener(this);
		multiMenu.multiButton[1].addActionListener(this);
		multiMenu.multiButton[2].addActionListener(this);

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
//			signUp = new SignUp();
			signUp.setVisible(true);
		}

		if (e.getSource() == mainLogin.exitButton)
			System.exit(0);
		// -------------------------------------------------

		// �޴� �׼� ������ --------------------------------
		// Single Button
		if (e.getSource() == mainMenu.mainBtn[0]) {
			mainMenu.setVisible(false);
			singleMenu.setVisible(true);
		}
		// Multi button
		if (e.getSource() == mainMenu.mainBtn[1]) {
			mainMenu.setVisible(false);
			multiMenu.setVisible(true);
		}
		// Role Button
		if (e.getSource() == mainMenu.mainBtn[2]) {
			mainMenu.setVisible(false);
			ruleMenu.setVisible(true);
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
		// Back
		if (e.getSource() == multiMenu.multiButton[2]) {
			multiMenu.setVisible(false);
			mainMenu.setVisible(true);
		}
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
		String url = "jdbc:mysql://45.119.145.165:3306/catchmine";
		String id = "root";
		String pass = "daehwan";
		try {
			Connection conn = DriverManager.getConnection(url, id, pass);
			System.out.println("���� ����");

		} catch (SQLException ee) {
			System.err.println("SQL Error = " + ee.toString());
		}
	}
}
