package MyListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DB.mariaDB;
import Main.Main;
import Scenes.PlayMusic;

public class Action implements ActionListener {

	mariaDB db = new mariaDB();

	boolean idCheck = false, nickCheck = false, pwCheck = false;

	public void actionPerformed(ActionEvent e) {
		// �α��� �׼� ������ --------------------------------------------------------
		if (e.getSource() == Main.mainLogin.loginButton[0]) {
			db.ConnectSQL();
			if (db.LoginCheck(Main.mainLogin.idText, Main.mainLogin.pwText)) {
				Main.mainLogin.setVisible(false);
				Main.mainMenu.setVisible(true);
				Main.NickName = db.getNickName();
				db.disConnectSQL();
			} else {
				Main.mainLogin.pwText.setText("");
				db.disConnectSQL();
			}
		}
		// ȸ�� ���� â
		if (e.getSource() == Main.mainLogin.loginButton[1]) {
			db.ConnectSQL();
			Main.signUp.reset();
			Main.signUp.setVisible(true);
		}

		if (e.getSource() == Main.mainLogin.loginButton[2])
			System.exit(0);
		// --------------------------------------------------------------------------

		
		
		
		// ȸ������ �׼� ������ ------------------------------------------------------
		// ID Ȯ�� ��ư
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
		// �г��� Ȯ�� ��ư
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
		// ��й�ȣ Ȯ�� ��ư
		if (e.getSource() == Main.signUp.checkButton[2]) {
			if (Main.signUp.pwField.getText().equals("") && Main.signUp.pwCheckField.getText().equals(""))
				Main.signUp.pwCheckLabel.setText(Main.signUp.pwCheckLabelString[0]);
			else if (Main.signUp.pwField.getText().equals(Main.signUp.pwCheckField.getText())) {
				Main.signUp.pwCheckLabel.setText(Main.signUp.pwCheckLabelString[1]);
				pwCheck = true;
			} else
				Main.signUp.pwCheckLabel.setText(Main.signUp.pwCheckLabelString[2]);
		}
		// �����ϱ� ��ư
		if (e.getSource() == Main.signUp.checkButton[3]) {
			if (idCheck && nickCheck && pwCheck && !Main.signUp.nameField.getText().equals("")) {
				db.intsertSQL(Main.signUp.idField.getText(), Main.signUp.pwField.getText(),
						Main.signUp.nameField.getText(), Main.signUp.nickField.getText());
				Main.signUp.setVisible(false);
			}
		}
		// �ڷΰ��� ��ư
		if (e.getSource() == Main.signUp.checkButton[4]) {
			db.disConnectSQL();
			Main.signUp.setVisible(false);
			Main.signUp.reset();
		}
		// --------------------------------------------------------------------------

		
		
		
		// �޴� �׼� ������ ---------------------------------------------------------
		// Single Button
		if (e.getSource() == Main.mainMenu.mainBtn[0]) {
			Main.mainMenu.setVisible(false);
			Main.singleMenu.setVisible(true);
		}
		// Multi button
		if (e.getSource() == Main.mainMenu.mainBtn[1]) {
			db.ConnectSQL();
			Main.mainMenu.setVisible(false);
			Main.multiMenu.chatArea.setText("");
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

		
		
		
		// �̱� �׼� ������ ---------------------------------------------------------
		// EASY

		// NORMAL

		// HARD

		// BACK
		if (e.getSource() == Main.singleMenu.modeButton[3]) {
			Main.singleMenu.setVisible(false);
			Main.mainMenu.setVisible(true);
		}
		// -------------------------------------------------------------------------

		
		
		
		// ��Ƽ �׼� ������ ---------------------------------------------------------
		// �� �����ϱ� ��ư
		if (e.getSource() == Main.multiMenu.multiButton[0]) {
			Main.createRoom.roomField.setText("");
			Main.createRoom.setVisible(true);
		}

		// Back
		if (e.getSource() == Main.multiMenu.multiButton[2]) {
			db.disConnectSQL();
			Main.multiMenu.setVisible(false);
			Main.mainMenu.setVisible(true);
		}
		// -------------------------------------------------------------------------

		
		
		
		// �� ���� ������ -----------------------------------------------------------
		if (e.getSource() == Main.createRoom.okButton) {
			Main.createRoom.setVisible(false);
			Main.multiMenu.setVisible(false);
			Main.multiRoom.setVisible(true);
		}
		// -------------------------------------------------------------------------

		
		
		
		// ��Ƽ �� ������ -----------------------------------------------------------
		if (e.getSource() == Main.multiRoom.multiRoomButton[1]) {
			Main.multiRoom.setVisible(false);
			Main.multiMenu.setVisible(true);

		}
		// -------------------------------------------------------------------------

		
		
		
		// ���� ��� ������ ---------------------------------------------------------
		if (e.getSource() == Main.ruleMenu.backButton) {
			Main.ruleMenu.setVisible(false);
			Main.mainMenu.setVisible(true);

		}
		// -------------------------------------------------------------------------

		
		
		
		// �ɼ� �׼� ������ ---------------------------------------------------------
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
	}

}
