package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;

public class Main extends JFrame implements ActionListener, KeyListener, MouseListener {
	MainLogin mainLogin = new MainLogin();
	Menu_Main mainMenu = new Menu_Main();
	Menu_Single singleMenu = new Menu_Single();
	Menu_Multi multiMenu = new Menu_Multi();
	Menu_Rule ruleMenu = new Menu_Rule();
	Menu_Option optionMenu = new Menu_Option();
	SignUp signUp = new SignUp();
	Create_Room createRoom = new Create_Room();
	Multi_Room multiRoom = new Multi_Room();

	static String NickName = null;

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

		// 로그인창 추가 부분
		add(mainLogin);

		// 메인 배경음악 재생
		PlayMusic backgroundMusic = new PlayMusic("BackgroundMusic(Blurry).mp3", true);
		backgroundMusic.start();

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
		add(multiRoom);
		multiRoom.setVisible(false);

		// 로그인 패널
		for (int i = 0; i < mainLogin.loginButton.length; i++) {
			mainLogin.loginButton[i].addActionListener(this);
			mainLogin.loginButton[i].addMouseListener(this);
		}
		mainLogin.idText.addKeyListener(this);
		mainLogin.pwText.addKeyListener(this);

		// 회원가입 패널
		for (int i = 0; i < signUp.checkButton.length; i++) {
			signUp.checkButton[i].addActionListener(this);
			signUp.checkButton[i].addMouseListener(this);
		}
		signUp.nameField.addKeyListener(this);
		signUp.idField.addKeyListener(this);
		signUp.pwField.addKeyListener(this);
		signUp.pwCheckField.addKeyListener(this);
		signUp.nickField.addKeyListener(this);

		// 메뉴 패널
		for (int i = 0; i < mainMenu.mainBtn.length; i++) {
			mainMenu.mainBtn[i].addActionListener(this);
			mainMenu.mainBtn[i].addMouseListener(this);
		}

		// 싱글 패널
		for (int i = 0; i < singleMenu.modeButton.length; i++) {
			singleMenu.modeButton[i].addActionListener(this);
			singleMenu.modeButton[i].addMouseListener(this);
		}

		// 멀티 패널
		for (int i = 0; i < multiMenu.multiButton.length; i++) {
			multiMenu.multiButton[i].addActionListener(this);
			multiMenu.multiButton[i].addMouseListener(this);
		}
		multiMenu.chatField.addKeyListener(this);

		// 게임 룰 패널
		ruleMenu.backButton.addActionListener(this);
		ruleMenu.backButton.addMouseListener(this);

		// 게임 옵션 패널
		optionMenu.backButton.addActionListener(this);
		optionMenu.backButton.addMouseListener(this);

		// 게임 생성 프레임
		createRoom.roomField.addKeyListener(this);
		createRoom.okButton.addActionListener(this);
		createRoom.okButton.addMouseListener(this);

		// 멀티 방 패널
		for (int i = 0; i < multiRoom.multiRoomButton.length; i++) {
			multiRoom.multiRoomButton[i].addActionListener(this);
			multiRoom.multiRoomButton[i].addMouseListener(this);
		}

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// 로그인 액션 리스너 -------------------------------
		if (e.getSource() == mainLogin.loginButton[0]) {
			ConnectSQL();
			if (LoginCheck()) {
				mainLogin.setVisible(false);
				mainMenu.setVisible(true);
				disConnectSQL();
			} else {
				mainLogin.pwText.setText("");
				disConnectSQL();
			}
		}
		// 회원 가입 창
		if (e.getSource() == mainLogin.loginButton[1]) {
			ConnectSQL();
			signUp.setVisible(true);
		}

		if (e.getSource() == mainLogin.loginButton[2])
			System.exit(0);
		// -------------------------------------------------

		// 회원가입 액션 리스너 -----------------------------
		// ID 확인 버튼
		if (e.getSource() == signUp.checkButton[0]) {
			if (signUp.idField.getText().equals(""))
				signUp.idCheckLabel.setText(signUp.idChekLabelString[1]);
			else if (idCheck = SelectSQL(signUp.idField.getText(), 1)) {
				signUp.idCheckLabel.setText(signUp.idChekLabelString[1]);
				System.out.println(idCheck);
			} else {
				signUp.idCheckLabel.setText(signUp.idChekLabelString[2]);
				System.out.println(idCheck);
			}
		}
		// 닉네임 확인 버튼
		if (e.getSource() == signUp.checkButton[1]) {
			if (signUp.nickField.getText().equals(""))
				signUp.nickCheckLabel.setText(signUp.nickCheckLabelString[0]);
			else if (nickCheck = SelectSQL(signUp.nickField.getText(), 4)) {
				signUp.nickCheckLabel.setText(signUp.nickCheckLabelString[1]);
				System.out.println(nickCheck);
			} else {
				signUp.nickCheckLabel.setText(signUp.nickCheckLabelString[2]);
				System.out.println(nickCheck);
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
			if (idCheck && nickCheck && pwCheck && !signUp.nameField.getText().equals("")) {
				intsertSQL(signUp.idField.getText(), signUp.pwField.getText(), signUp.nameField.getText(),
						signUp.nickField.getText());
				signUp.setVisible(false);
				signUp.reset();
			}
		}
		// 뒤로가기 버튼
		if (e.getSource() == signUp.checkButton[4]) {
			disConnectSQL();
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
			ConnectSQL();
			mainMenu.setVisible(false);
			multiMenu.chatArea.setText("");
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
		// 방 생성하기 버튼
		if (e.getSource() == multiMenu.multiButton[0])
			createRoom.setVisible(true);

		// Back
		if (e.getSource() == multiMenu.multiButton[2]) {
			disConnectSQL();
			multiMenu.setVisible(false);
			mainMenu.setVisible(true);
		}
		// ------------------------------------------------

		// 방 생성 리스너 ----------------------------------
		if (e.getSource() == createRoom.okButton) {
			createRoom.setVisible(false);
			multiMenu.setVisible(false);
			multiRoom.setVisible(true);
			createRoom.roomField.setText("");
		}
		// ------------------------------------------------

		// 멀티 방 리스너 ----------------------------------
		if (e.getSource() == multiRoom.multiRoomButton[1]) {
			multiRoom.setVisible(false);
			multiMenu.setVisible(true);

		}
		// ------------------------------------------------

		// 게임 방법 리스너 --------------------------------
		if (e.getSource() == ruleMenu.backButton) {
			ruleMenu.setVisible(false);
			mainMenu.setVisible(true);

		}
		// ------------------------------------------------

		// 옵션 액션 리스너 --------------------------------
		if (e.getSource() == optionMenu.backButton) {
			optionMenu.setVisible(false);
			mainMenu.setVisible(true);
		}
	}

	// ------------------------------------------------

	// SQL
	// --------------------------------------------------------------------------------------
	public boolean LoginCheck() {
		if (!mainLogin.idText.getText().isEmpty() && !mainLogin.idText.getText().isEmpty())
			try {
				pstmt = null;
				String selectSql = "select * from CatchMine";
				pstmt = conn.prepareStatement(selectSql);
				ResultSet rs = pstmt.executeQuery();

				while (rs.next()) {
					if (mainLogin.idText.getText().equals(rs.getString(1)))
						if (mainLogin.pwText.getText().equals(rs.getString(2))) {
							NickName = rs.getString(4);
							return true;
						}
				}

			} catch (SQLException ssql) {
				System.out.println("ssql error : " + ssql);
			}

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
			disConnectSQL();
		}
	}

	public boolean SelectSQL(String str, int i) {
		try {
			pstmt = null;
			String selectSql = "select * from CatchMine";
			pstmt = conn.prepareStatement(selectSql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				if (str.equals(rs.getString(i))) {
					return false;
				}
			}
		} catch (SQLException ssql) {
			System.out.println("ssql error : " + ssql);
		}

		return true;
	}

	public void ConnectSQL() {
		try {
			conn = DriverManager.getConnection(url, id, pass);
			System.out.println("연결 성공");
		} catch (SQLException ee) {
			System.out.println("Insert Connection Error : " + ee);
		}
	}

	public void disConnectSQL() {
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException sqle) {
			} // PreparedStatement 객체 해제

		if (conn != null)
			try {
				conn.close();
				System.out.println("연결 종료");
			} catch (SQLException sqle) {
			} // Connection 해제
	}
// -------------------------------------------------------------------

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getSource() == mainLogin.idText && e.getKeyCode() == 10)
			mainLogin.pwText.grabFocus();

		if (e.getSource() == mainLogin.pwText && e.getKeyCode() == 10) {
			PlayMusic buttonPressedMusic = new PlayMusic("buttonPressedMusic.mp3", false);
			buttonPressedMusic.start();
			mainLogin.loginButton[0].doClick();
		}
		// 회원가입 프레임 부분 -------------------------------------------
		// 이름 필드
		if (e.getSource() == signUp.nameField && e.getKeyCode() == 10)
			signUp.idField.grabFocus();
		// ID 필드
		if (e.getSource() == signUp.idField && e.getKeyCode() == 10) {
			signUp.checkButton[0].doClick();
			if (signUp.idCheckLabel.getText().equals(signUp.idChekLabelString[1]))
				signUp.nickField.grabFocus();
		}
		// 닉네임 필드
		if (e.getSource() == signUp.nickField && e.getKeyCode() == 10) {
			signUp.checkButton[1].doClick();
			if (signUp.nickCheckLabel.getText().equals(signUp.nickCheckLabelString[1]))
				signUp.pwField.grabFocus();
		}
		// PW 필드
		if (e.getSource() == signUp.pwField && e.getKeyCode() == 10)
			signUp.pwCheckField.grabFocus();
		// PW 확인 필드
		if (e.getSource() == signUp.pwCheckField && e.getKeyCode() == 10)
			signUp.checkButton[2].doClick();
		System.out.println("keypressed : " + e.getKeyChar());
		System.out.println(e.getKeyCode());

		// 멀티 채팅
		if (e.getSource() == multiMenu.chatField && e.getKeyCode() == 10) {
			if (!multiMenu.chatField.getText().equals("")) {
				multiMenu.chatArea.append(NickName + " : " + multiMenu.chatField.getText() + "\n");
				multiMenu.chatArea.setCaretPosition(multiMenu.chatArea.getDocument().getLength());
				multiMenu.chatField.setText("");
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
//		System.out.println("keyReleased : "+ e.getKeyChar());
//		System.out.println(e.getKeyCode());

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		PlayMusic buttonPressedMusic = new PlayMusic("buttonPressedMusic.mp3", false);
		buttonPressedMusic.start();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		for (int i = 0; i < singleMenu.modeButton.length - 1; i++)
			if (e.getSource() == singleMenu.modeButton[i]) {
				singleMenu.modeButton[i].setText(singleMenu.modeEn[i]);
			}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		for (int i = 0; i < singleMenu.modeButton.length - 1; i++)
			if (e.getSource() == singleMenu.modeButton[i]) {
				singleMenu.modeButton[i].setText(singleMenu.mode[i]);
			}
	}

	public static void main(String[] args) {
		new Main();
	}
}
