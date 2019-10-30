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

	// SQL 연결 부분
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

		// 메뉴 추가 부분
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

		// 로그인 패널
		mainLogin.loginButton.addActionListener(this);
		mainLogin.signUpButton.addActionListener(this);
		mainLogin.exitButton.addActionListener(this);

		// 회원가입 패널
		signUp.checkButton[0].addActionListener(this);
		signUp.checkButton[1].addActionListener(this);
		signUp.checkButton[2].addActionListener(this);
		signUp.checkButton[3].addActionListener(this);
		signUp.checkButton[4].addActionListener(this);

		// 메뉴 패널
		mainMenu.mainBtn[0].addActionListener(this);
		mainMenu.mainBtn[1].addActionListener(this);
		mainMenu.mainBtn[2].addActionListener(this);
		mainMenu.mainBtn[3].addActionListener(this);

		// 싱글 패널
		singleMenu.modeButton[0].addActionListener(this);
		singleMenu.modeButton[1].addActionListener(this);
		singleMenu.modeButton[2].addActionListener(this);
		singleMenu.modeButton[3].addActionListener(this);

		// 멀티 패널
		multiMenu.multiButton[0].addActionListener(this);
		multiMenu.multiButton[1].addActionListener(this);
		multiMenu.multiButton[2].addActionListener(this);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// 로그인 액션 리스너 -------------------------------
		if (e.getSource() == mainLogin.loginButton || LoginCheck()) {
			mainLogin.setVisible(false);
			mainMenu.setVisible(true);
		}

		// 회원 가입 액션 리스너 -----------------------------
		if (e.getSource() == mainLogin.signUpButton) {
			try {
				conn = DriverManager.getConnection(url, id, pass);
				System.out.println("연결 성공");
			} catch (SQLException ee) {
				System.out.println("Insert Connection Error : " + ee);
			}
			signUp.setVisible(true);
		}

		if (e.getSource() == mainLogin.exitButton)
			System.exit(0);
		// -------------------------------------------------

		// 회원가입 액션 리스너 -----------------------------
		// ID 확인 버튼
		if (e.getSource() == signUp.checkButton[0]) {
			if (signUp.idField.getText().equals(""))
				signUp.idCheckLabel.setText(signUp.idChekLabelString[0]);
			else {
				idCheck = true;
			}
		}
		// 닉네임 확인 버튼
		if (e.getSource() == signUp.checkButton[1]) {
			if (signUp.nickField.getText().equals(""))
				signUp.nickCheckLabel.setText(signUp.nickCheckLabelString[0]);
			else {
				nickCheck = true;
			}
		}
		// 비밀번호 확인 버튼
		if (e.getSource() == signUp.checkButton[2]) {
			if (signUp.pwField.getText().equals("") && signUp.pwCheckField.getText().equals(""))
				signUp.pwCheckLabel.setText(signUp.pwCheckLabelString[0]);
			else if (signUp.pwField.getText().equals(signUp.pwCheckField.getText())) {
				signUp.pwCheckLabel.setText(signUp.pwCheckLabelString[1]);
				pwCheck = true;
			} else
				signUp.pwCheckLabel.setText(signUp.pwCheckLabelString[2]);
		}
		// 가입하기 버튼
		if (e.getSource() == signUp.checkButton[3]) {
			if (idCheck && nickCheck && pwCheck) {
				intsertSQL(signUp.idField.getText(), signUp.pwField.getText(), signUp.nameField.getText(),
						signUp.nickField.getText());
				signUp.setVisible(false);
				signUp.reset();
			}
		}
		// 뒤로가기 버튼
		if (e.getSource() == signUp.checkButton[4]) {
			signUp.setVisible(false);
			signUp.reset();
		}
		// -------------------------------------------------

		// 메뉴 액션 리스너 --------------------------------
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

		// 싱글 액션 리스너 --------------------------------
		// EASY

		// NORMAL

		// HARD

		// BACK
		if (e.getSource() == singleMenu.modeButton[3]) {
			singleMenu.setVisible(false);
			mainMenu.setVisible(true);
		}
		// ------------------------------------------------

		// 멀티 액션 리스너 --------------------------------
		// Back
		if (e.getSource() == multiMenu.multiButton[2]) {
			multiMenu.setVisible(false);
			mainMenu.setVisible(true);
		}
		// ------------------------------------------------

		// 옵션 액션 리스너 --------------------------------
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

			pstmt.executeUpdate(); // 쿼리 실행

			System.out.println("Insert 성공");

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
					System.out.println("연결 종료");
				} catch (SQLException sqle) {

				}
			}
		}
	}

	public static void main(String[] args) {
		new Main();

//		try {
//			conn = DriverManager.getConnection(url, id, pass);
//			System.out.println("연결 성공");
//
//		} catch (SQLException ee) {
//			System.err.println("SQL Error = " + ee.toString());
//		}
	}
}
