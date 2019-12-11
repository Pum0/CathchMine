package MyListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Client.Client;
import DB.mariaDB;
import Game.Game;
import Game.singleGame;
import Grahpics.PlayMusic;
import Main.Main;

public class Action implements ActionListener {

	mariaDB db = new mariaDB();

	boolean idCheck = false, nickCheck = false, pwCheck = false;

	private static String IP_Add = "localhost";

	public void actionPerformed(ActionEvent e) {
		// 로그인 액션 리스너 --------------------------------------------------------
		if (e.getSource() == Main.mainLogin.loginButton[0]) {
			db.ConnectSQL();
			if (db.LoginCheck(Main.mainLogin.idText, Main.mainLogin.pwText)) {
				Main.mainLogin.setVisible(false);
				Main.mainMenu.setVisible(true);
				db.disConnectSQL();
			} else {
				Main.mainLogin.pwText.setText("");
				db.disConnectSQL();
			}
		}
		// 회원 가입 창
		if (e.getSource() == Main.mainLogin.loginButton[1]) {
			db.ConnectSQL();
			Main.signUp.reset();
			Main.signUp.setVisible(true);
		}

		if (e.getSource() == Main.mainLogin.loginButton[2])
			System.exit(0);
		// --------------------------------------------------------------------------

		// 회원가입 액션 리스너 ------------------------------------------------------
		// ID 확인 버튼
		if (e.getSource() == Main.signUp.checkButton[0]) {
			if (Main.signUp.idField.getText().equals(""))
				Main.signUp.idCheckLabel.setText(Main.signUp.idChekLabelString[1]);
			else if (idCheck = db.SelectSQL(Main.signUp.idField.getText(), 1)) {
				Main.signUp.idCheckLabel.setText(Main.signUp.idChekLabelString[1]);
				System.out.println(idCheck);
			} else {
				Main.signUp.idCheckLabel.setText(Main.signUp.idChekLabelString[2]);
				System.out.println(idCheck);
			}
		}
		// 닉네임 확인 버튼
		if (e.getSource() == Main.signUp.checkButton[1]) {
			if (Main.signUp.nickField.getText().equals(""))
				Main.signUp.nickCheckLabel.setText(Main.signUp.nickCheckLabelString[0]);
			else if (nickCheck = db.SelectSQL(Main.signUp.nickField.getText(), 4)) {
				Main.signUp.nickCheckLabel.setText(Main.signUp.nickCheckLabelString[1]);
				System.out.println(nickCheck);
			} else {
				Main.signUp.nickCheckLabel.setText(Main.signUp.nickCheckLabelString[2]);
				System.out.println(nickCheck);
			}
		}
		// 비밀번호 확인 버튼
		if (e.getSource() == Main.signUp.checkButton[2]) {
			if (Main.signUp.pwField.getText().equals("") && Main.signUp.pwCheckField.getText().equals(""))
				Main.signUp.pwCheckLabel.setText(Main.signUp.pwCheckLabelString[0]);
			else if (Main.signUp.pwField.getText().equals(Main.signUp.pwCheckField.getText())) {
				Main.signUp.pwCheckLabel.setText(Main.signUp.pwCheckLabelString[1]);
				pwCheck = true;
			} else
				Main.signUp.pwCheckLabel.setText(Main.signUp.pwCheckLabelString[2]);
		}
		// 가입하기 버튼
		if (e.getSource() == Main.signUp.checkButton[3]) {
			if (idCheck && nickCheck && pwCheck && !Main.signUp.nameField.getText().equals("")) {
				db.intsertSQL(Main.signUp.idField.getText(), Main.signUp.pwField.getText(),
						Main.signUp.nameField.getText(), Main.signUp.nickField.getText());
				Main.signUp.setVisible(false);
			}
		}
		// 뒤로가기 버튼
		if (e.getSource() == Main.signUp.checkButton[4]) {
			db.disConnectSQL();
			Main.signUp.setVisible(false);
			Main.signUp.reset();
		}
		// --------------------------------------------------------------------------

		// 메뉴 액션 리스너 ---------------------------------------------------------
		// Single Button
		if (e.getSource() == Main.mainMenu.mainBtn[0]) {
			Main.mainMenu.setVisible(false);
			Main.singleMenu.setVisible(true);
		}
		// Multi button
		if (e.getSource() == Main.mainMenu.mainBtn[1]) {
			Main.cli = new Client(IP_Add);
			Main.cli.NickName = db.getNickName();
			new Thread(Main.cli.chat).start();

			Main.multiMenu.chatArea.setText("");
			Main.multiMenu.chatField.setText("");
			Main.cli.chat.enterChat();
			Main.mainMenu.setVisible(false);
			Main.multiMenu.setVisible(true);
		}

		// Role Button
		if (e.getSource() == Main.mainMenu.mainBtn[2]) {
			Main.mainMenu.setVisible(false);
			Main.ruleMenu.setVisible(true);
		}
		// Option Button
		if (e.getSource() == Main.mainMenu.mainBtn[3]) {
			Main.mainMenu.setVisible(false);
			Main.optionMenu.setVisible(true);
		}
		// -------------------------------------------------------------------------

		// 싱글 액션 리스너 ---------------------------------------------------------
//		Main.backgroundMusic.close();
		// EASY
		if (e.getSource() == Main.singleMenu.modeButton[0]) {
			singleGame.setMineCount(30);
			new Game();
		}
		// NORMAL
		if (e.getSource() == Main.singleMenu.modeButton[1]) {
			singleGame.setMineCount(50);
			new Game();
		}

		// HARD
		if (e.getSource() == Main.singleMenu.modeButton[2]) {
			singleGame.setMineCount(70);
			new Game();
		}
		// BACK
		if (e.getSource() == Main.singleMenu.modeButton[3]) {
			Main.singleMenu.setVisible(false);
			Main.mainMenu.setVisible(true);
		}
		// -------------------------------------------------------------------------

		// 멀티 액션 리스너 ---------------------------------------------------------
		// 방 생성하기 버튼
		if (e.getSource() == Main.multiMenu.multiButton[0]) {
			Main.createRoom.roomField.setText("");
			Main.createRoom.setVisible(true);
		}

		// Multi Chating TextField
		if (e.getSource() == Main.multiMenu.chatField) {
			if (!Main.multiMenu.chatField.getText().equals("")) {
//				Main.multiMenu.chatArea.append(Main.NickName + " : " + Main.multiMenu.chatField.getText()+"\n");
				Main.cli.chat.sendMessage(Main.multiMenu.chatField.getText());
				Main.multiMenu.chatArea.setCaretPosition(Main.multiMenu.chatArea.getDocument().getLength());
				Main.multiMenu.chatField.setText(null);
			}
		}

		// Back
		if (e.getSource() == Main.multiMenu.multiButton[2]) {
			Main.cli.chat.exitChat();
			Main.cli.close();
			Main.multiMenu.setVisible(false);
			Main.mainMenu.setVisible(true);
		}
		// -------------------------------------------------------------------------

		// 방 생성 리스너 -----------------------------------------------------------
		if (e.getSource() == Main.createRoom.okButton) {
			if (!Main.createRoom.roomField.getText().equals("")) {
				Main.createRoom.setVisible(false);
				Main.multiMenu.setVisible(false);
				Main.multiRoom.setVisible(true);
			}
		}
		// -------------------------------------------------------------------------

		// 멀티 방 리스너 -----------------------------------------------------------
		if (e.getSource() == Main.multiRoom.multiRoomButton[1]) {
			Main.multiRoom.setVisible(false);
			Main.multiMenu.setVisible(true);

		}
		// -------------------------------------------------------------------------

		// 게임 방법 리스너 ---------------------------------------------------------
		if (e.getSource() == Main.ruleMenu.backButton) {
			Main.ruleMenu.setVisible(false);
			Main.mainMenu.setVisible(true);

		}
		// -------------------------------------------------------------------------

		// 옵션 액션 리스너 ---------------------------------------------------------
		if (e.getSource() == Main.optionMenu.backButton) {
			Main.optionMenu.setVisible(false);
			Main.mainMenu.setVisible(true);
		}

		if (e.getSource() == Main.optionMenu.music) {
			if (Main.optionMenu.music.getSelectedIndex() == 0) {
				Main.backgroundMusic.close();
				Main.backgroundMusic = new PlayMusic("backgroundMusic1.mp3", true);
				Main.backgroundMusic.start();
			}
			if (Main.optionMenu.music.getSelectedIndex() == 1) {
				Main.backgroundMusic.close();
				Main.backgroundMusic = new PlayMusic("backgroundMusic2.mp3", true);
				Main.backgroundMusic.start();
			}
			if (Main.optionMenu.music.getSelectedIndex() == 2) {
				Main.backgroundMusic.close();
				Main.backgroundMusic = new PlayMusic("backgroundMusic3.mp3", true);
				Main.backgroundMusic.start();
			}
			if (Main.optionMenu.music.getSelectedIndex() == 3) {
				Main.backgroundMusic.close();
				Main.backgroundMusic = new PlayMusic("backgroundMusic4.mp3", true);
				Main.backgroundMusic.start();
			}
		}

		if (e.getSource() == Main.optionMenu.setIP) {
			if (!Main.optionMenu.IPfield.getText().equals("")) {
				System.out.println(Main.optionMenu.IPfield.getText());
				IP_Add = Main.optionMenu.IPfield.getText();
			}
		}
	}

}
