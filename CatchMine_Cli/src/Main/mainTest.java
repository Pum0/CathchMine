package Main;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import ScenesGame.SingleGame;

public class mainTest extends StateBasedGame {

	public final static int Screen_Width = 1280;
	public final static int Screen_Height = 720;

	public static final int GAME_SINGLE = 0;

	public mainTest(String name) {
		super(name);
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {

		addState(new SingleGame(GAME_SINGLE));
	}

	class Main extends JFrame implements ActionListener {
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

			if (e.getSource() == mainLogin.signUpButton) {
//				signUp = new SignUp();
				signUp.setVisible(true);
			}

			if (e.getSource() == mainLogin.exitButton)
				System.exit(0);
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
			if (e.getSource() == singleMenu.modeButton[0]) {
				try {
					AppGameContainer appgc;
					appgc = new AppGameContainer(new mainTest("Catch-Mine"));
					appgc.setDisplayMode(Screen_Width, Screen_Height, false);
					appgc.setTargetFrameRate(240);
					appgc.start();

				} catch (SlickException ex) {
					ex.printStackTrace();
				}
			}
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
	}

	public static void main(String[] args) {
		new mainTest("").new Main();
		
		String url = "jdbc:mysql://45.119.145.165:3306/catchmine";
		String id = "root";
		String pass = "daehwan";
		try {
			Connection conn = DriverManager.getConnection(url, id, pass);
			System.out.println("연결 성공");

		} catch (SQLException ee) {
			System.err.println("SQL Error = " + ee.toString());
		}
	}
}
