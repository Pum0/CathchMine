package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;

import org.mariadb.jdbc.internal.util.dao.PrepareStatementCacheKey;

public class Main extends JFrame implements ActionListener {
	MainLogin mainLogin = new MainLogin();
	Menu_Main mainMenu = new Menu_Main();
	Menu_Single singleMenu = new Menu_Single();
	Menu_Multi multiMenu = new Menu_Multi();
	Menu_Rule ruleMenu = new Menu_Rule();
	Menu_Option optionMenu = new Menu_Option();
	SignUp signUp = new SignUp();

	boolean idCheck = false, nickCheck = false, pwCheck = false;

	// SQL ���� �κ�
	static String url = "jdbc:mysql://45.119.145.165:3306/catchmine";
	static String id = "root";
	static String pass = "daehwan";
	static Connection conn = null;
	static PreparedStatement pstmt = null;

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
		signUp.checkButton[0].addActionListener(this);
		signUp.checkButton[1].addActionListener(this);
		signUp.checkButton[2].addActionListener(this);
		signUp.checkButton[3].addActionListener(this);
		signUp.checkButton[4].addActionListener(this);

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

		// ȸ�� ���� �׼� ������ -----------------------------
		if (e.getSource() == mainLogin.signUpButton) {
			try {
				conn = DriverManager.getConnection(url, id, pass);
				System.out.println("���� ����");
			} catch (SQLException ee) {
				System.out.println("Insert Connection Error : " + ee);
			}
			signUp.setVisible(true);
		}

		if (e.getSource() == mainLogin.exitButton)
			System.exit(0);
		// -------------------------------------------------

		// ȸ������ �׼� ������ -----------------------------
		// ID Ȯ�� ��ư
		if (e.getSource() == signUp.checkButton[0]) {
			if (signUp.idField.getText().equals(""))
				signUp.idCheckLabel.setText(signUp.idChekLabelString[0]);
			else {
				idCheck = true;
			}
		}
		// �г��� Ȯ�� ��ư
		if (e.getSource() == signUp.checkButton[1]) {
			if (signUp.nickField.getText().equals(""))
				signUp.nickCheckLabel.setText(signUp.nickCheckLabelString[0]);
			else {
				nickCheck = true;
			}
		}
		// ��й�ȣ Ȯ�� ��ư
		if (e.getSource() == signUp.checkButton[2]) {
			if (signUp.pwField.getText().equals("") && signUp.pwCheckField.getText().equals(""))
				signUp.pwCheckLabel.setText(signUp.pwCheckLabelString[0]);
			else if (signUp.pwField.getText().equals(signUp.pwCheckField.getText())) {
				signUp.pwCheckLabel.setText(signUp.pwCheckLabelString[1]);
				pwCheck = true;
			} else
				signUp.pwCheckLabel.setText(signUp.pwCheckLabelString[2]);
		}
		// �����ϱ� ��ư
		if (e.getSource() == signUp.checkButton[3]) {
			if (idCheck && nickCheck && pwCheck) {
				intsertSQL(signUp.idField.getText(), signUp.pwField.getText(), signUp.nameField.getText(),
						signUp.nickField.getText());
				signUp.setVisible(false);
				signUp.reset();
			}
		}
		// �ڷΰ��� ��ư
		if (e.getSource() == signUp.checkButton[4]) {
			signUp.setVisible(false);
			signUp.reset();
		}
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

	public void intsertSQL(String id, String pw, String name, String nick) {
		try {
			String sql = "insert into CatchMine(ID, PW, NAME, NICK_NAME) values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, nick);

			pstmt.executeUpdate(); // ���� ����

			System.out.println("Insert ����");

		} catch (SQLException e) {
			System.out.println("insert Error : " + e);
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException sqle) {

				}
			}
			if (conn != null) {
				try {
					conn.close();
					System.out.println("���� ����");
				} catch (SQLException sqle) {

				}
			}
		}
	}

	public static void main(String[] args) {
		new Main();

//		try {
//			conn = DriverManager.getConnection(url, id, pass);
//			System.out.println("���� ����");
//
//		} catch (SQLException ee) {
//			System.err.println("SQL Error = " + ee.toString());
//		}
	}
}
