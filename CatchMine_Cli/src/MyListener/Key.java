package MyListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Main.Main;
import Scenes.PlayMusic;

public class Key implements KeyListener {
	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// 로그인 패널 부분 ----------------------------------------------
		if (e.getSource() == Main.mainLogin.idText && e.getKeyCode() == 10)
			Main.mainLogin.pwText.grabFocus();

		if (e.getSource() == Main.mainLogin.pwText && e.getKeyCode() == 10) {
			PlayMusic buttonPressedMusic = new PlayMusic("buttonPressedMusic.mp3", false);
			buttonPressedMusic.start();
			Main.mainLogin.loginButton[0].doClick();
		}
		
		
		
		// 회원가입 프레임 부분 -------------------------------------------
		// 이름 필드
		if (e.getSource() == Main.signUp.nameField && e.getKeyCode() == 10)
			Main.signUp.idField.grabFocus();
		// ID 필드
		if (e.getSource() == Main.signUp.idField && e.getKeyCode() == 10) {
			Main.signUp.checkButton[0].doClick();
			if (Main.signUp.idCheckLabel.getText().equals(Main.signUp.idChekLabelString[1]))
				Main.signUp.nickField.grabFocus();
		}
		// 닉네임 필드
		if (e.getSource() == Main.signUp.nickField && e.getKeyCode() == 10) {
			Main.signUp.checkButton[1].doClick();
			if (Main.signUp.nickCheckLabel.getText().equals(Main.signUp.nickCheckLabelString[1]))
				Main.signUp.pwField.grabFocus();
		}
		// PW 필드
		if (e.getSource() == Main.signUp.pwField && e.getKeyCode() == 10)
			Main.signUp.pwCheckField.grabFocus();
		// PW 확인 필드
		if (e.getSource() == Main.signUp.pwCheckField && e.getKeyCode() == 10)
			Main.signUp.checkButton[2].doClick();
		System.out.println("keypressed : " + e.getKeyChar());
		System.out.println(e.getKeyCode());

		
		
		
		// 멀티 채팅 ---------------------------------------------------------
		if (e.getSource() == Main.multiMenu.chatField && e.getKeyCode() == 10) {
			if (!Main.multiMenu.chatField.getText().equals("")) {
				Main.multiMenu.chatArea.append(Main.NickName + " : " + Main.multiMenu.chatField.getText() + "\n");
				Main.multiMenu.chatArea.setCaretPosition(Main.multiMenu.chatArea.getDocument().getLength());
				Main.multiMenu.chatField.setText("");
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("keyReleased : " + e.getKeyChar());
		System.out.println(e.getKeyCode());

	}
}
