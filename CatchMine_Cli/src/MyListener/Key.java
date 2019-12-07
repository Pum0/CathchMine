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
		// �α��� �г� �κ� ----------------------------------------------
		if (e.getSource() == Main.mainLogin.idText && e.getKeyCode() == 10)
			Main.mainLogin.pwText.grabFocus();

		if (e.getSource() == Main.mainLogin.pwText && e.getKeyCode() == 10) {
			PlayMusic buttonPressedMusic = new PlayMusic("buttonPressedMusic.mp3", false);
			buttonPressedMusic.start();
			Main.mainLogin.loginButton[0].doClick();
		}
		
		
		
		// ȸ������ ������ �κ� -------------------------------------------
		// �̸� �ʵ�
		if (e.getSource() == Main.signUp.nameField && e.getKeyCode() == 10)
			Main.signUp.idField.grabFocus();
		// ID �ʵ�
		if (e.getSource() == Main.signUp.idField && e.getKeyCode() == 10) {
			Main.signUp.checkButton[0].doClick();
			if (Main.signUp.idCheckLabel.getText().equals(Main.signUp.idChekLabelString[1]))
				Main.signUp.nickField.grabFocus();
		}
		// �г��� �ʵ�
		if (e.getSource() == Main.signUp.nickField && e.getKeyCode() == 10) {
			Main.signUp.checkButton[1].doClick();
			if (Main.signUp.nickCheckLabel.getText().equals(Main.signUp.nickCheckLabelString[1]))
				Main.signUp.pwField.grabFocus();
		}
		// PW �ʵ�
		if (e.getSource() == Main.signUp.pwField && e.getKeyCode() == 10)
			Main.signUp.pwCheckField.grabFocus();
		// PW Ȯ�� �ʵ�
		if (e.getSource() == Main.signUp.pwCheckField && e.getKeyCode() == 10)
			Main.signUp.checkButton[2].doClick();
		System.out.println("keypressed : " + e.getKeyChar());
		System.out.println(e.getKeyCode());

		
		
		
		// ��Ƽ ä�� ---------------------------------------------------------
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
