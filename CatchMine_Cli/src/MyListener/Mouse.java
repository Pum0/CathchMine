package MyListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

import Grahpics.PlayMusic;
import Main.Main;

public class Mouse implements MouseListener {
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		PlayMusic buttonPressedMusic = new PlayMusic("buttonPressedMusic.mp3", false);
		buttonPressedMusic.start();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		PlayMusic buttonEnteredMusic = new PlayMusic("buttonEnteredMusic.mp3", false);
		buttonEnteredMusic.start();

		for (int i = 0; i < Main.singleMenu.modeButton.length; i++)
			if (e.getSource() == Main.singleMenu.modeButton[i]) {
				Main.singleMenu.modeButton[i].setText(Main.singleMenu.modeEn[i]);
				Main.singleMenu.modeButton[i].setIcon(new ImageIcon("image/button/200x50_2.png"));
			}

		// 메인로그인 버튼
		if (e.getSource() == Main.mainLogin.loginButton[0])
			Main.mainLogin.loginButton[0].setIcon(new ImageIcon("image/button/40x50_2.png"));
		if (e.getSource() == Main.mainLogin.loginButton[1])
			Main.mainLogin.loginButton[1].setIcon(new ImageIcon("image/button/90x30_2.png"));
		if (e.getSource() == Main.mainLogin.loginButton[2])
			Main.mainLogin.loginButton[2].setIcon(new ImageIcon("image/button/90x30_2.png"));

		// 메인메뉴 버튼
		for (int i = 0; i < Main.mainMenu.mainBtn.length; i++)
			if (e.getSource() == Main.mainMenu.mainBtn[i])
				Main.mainMenu.mainBtn[i].setIcon(new ImageIcon("image/button/200x50_2.png"));

		// 멀티메뉴 버튼
		if (e.getSource() == Main.multiMenu.multiButton[0])
			Main.multiMenu.multiButton[0].setIcon(new ImageIcon("image/button/180x45_2.png"));
		if (e.getSource() == Main.multiMenu.multiButton[1])
			Main.multiMenu.multiButton[1].setIcon(new ImageIcon("image/button/180x45_2.png"));
		if (e.getSource() == Main.multiMenu.multiButton[2])
			Main.multiMenu.multiButton[2].setIcon(new ImageIcon("image/button/115x30_2.png"));

		// 게임방법 버튼
		if (e.getSource() == Main.ruleMenu.backButton)
			Main.ruleMenu.backButton.setIcon(new ImageIcon("image/button/100x40_2.png"));

		// 옵션 버튼
		if (e.getSource() == Main.optionMenu.backButton)
			Main.optionMenu.backButton.setIcon(new ImageIcon("image/button/100x40_2.png"));

		// 회원가입 버튼
		if (e.getSource() == Main.signUp.checkButton[0])
			Main.signUp.checkButton[0].setIcon(new ImageIcon("image/button/60x25_2.png"));
		if (e.getSource() == Main.signUp.checkButton[1])
			Main.signUp.checkButton[1].setIcon(new ImageIcon("image/button/60x25_2.png"));
		if (e.getSource() == Main.signUp.checkButton[2])
			Main.signUp.checkButton[2].setIcon(new ImageIcon("image/button/60x25_2.png"));
		if (e.getSource() == Main.signUp.checkButton[3])
			Main.signUp.checkButton[3].setIcon(new ImageIcon("image/button/120x40_2.png"));
		if (e.getSource() == Main.signUp.checkButton[4])
			Main.signUp.checkButton[4].setIcon(new ImageIcon("image/button/120x40_2.png"));

		// 방생성 버튼
		if (e.getSource() == Main.createRoom.okButton)
			Main.createRoom.okButton.setIcon(new ImageIcon("image/button/90x30_2.png"));

		// 대기방 버튼
		if (e.getSource() == Main.multiRoom.multiRoomButton[0])
			Main.multiRoom.multiRoomButton[0].setIcon(new ImageIcon("image/button/115x30_2.png"));
		if (e.getSource() == Main.multiRoom.multiRoomButton[1])
			Main.multiRoom.multiRoomButton[1].setIcon(new ImageIcon("image/button/115x30_2.png"));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		for (int i = 0; i < Main.singleMenu.modeButton.length; i++)
			if (e.getSource() == Main.singleMenu.modeButton[i]) {
				Main.singleMenu.modeButton[i].setText(Main.singleMenu.mode[i]);
				Main.singleMenu.modeButton[i].setIcon(new ImageIcon("image/button/200x50.png"));
			}
		// 메인로그인 버튼
		if (e.getSource() == Main.mainLogin.loginButton[0])
			Main.mainLogin.loginButton[0].setIcon(new ImageIcon("image/button/40x50.png"));
		if (e.getSource() == Main.mainLogin.loginButton[1])
			Main.mainLogin.loginButton[1].setIcon(new ImageIcon("image/button/90x30.png"));
		if (e.getSource() == Main.mainLogin.loginButton[2])
			Main.mainLogin.loginButton[2].setIcon(new ImageIcon("image/button/90x30.png"));

		// 메인메뉴 버튼
		for (int i = 0; i < Main.mainMenu.mainBtn.length; i++)
			if (e.getSource() == Main.mainMenu.mainBtn[i])
				Main.mainMenu.mainBtn[i].setIcon(new ImageIcon("image/button/200x50.png"));

		// 멀티메뉴 머튼
		if (e.getSource() == Main.multiMenu.multiButton[0])
			Main.multiMenu.multiButton[0].setIcon(new ImageIcon("image/button/180x45.png"));
		if (e.getSource() == Main.multiMenu.multiButton[1])
			Main.multiMenu.multiButton[1].setIcon(new ImageIcon("image/button/180x45.png"));
		if (e.getSource() == Main.multiMenu.multiButton[2])
			Main.multiMenu.multiButton[2].setIcon(new ImageIcon("image/button/115x30.png"));

		// 게임방법 버튼
		if (e.getSource() == Main.ruleMenu.backButton)
			Main.ruleMenu.backButton.setIcon(new ImageIcon("image/button/100x40.png"));

		// 옵션 버튼
		if (e.getSource() == Main.optionMenu.backButton)
			Main.optionMenu.backButton.setIcon(new ImageIcon("image/button/100x40.png"));

		// 회원가입 버튼
		if (e.getSource() == Main.signUp.checkButton[0])
			Main.signUp.checkButton[0].setIcon(new ImageIcon("image/button/60x25.png"));
		if (e.getSource() == Main.signUp.checkButton[1])
			Main.signUp.checkButton[1].setIcon(new ImageIcon("image/button/60x25.png"));
		if (e.getSource() == Main.signUp.checkButton[2])
			Main.signUp.checkButton[2].setIcon(new ImageIcon("image/button/60x25.png"));
		if (e.getSource() == Main.signUp.checkButton[3])
			Main.signUp.checkButton[3].setIcon(new ImageIcon("image/button/120x40.png"));
		if (e.getSource() == Main.signUp.checkButton[4])
			Main.signUp.checkButton[4].setIcon(new ImageIcon("image/button/120x40.png"));

		// 방생성 버튼
		if (e.getSource() == Main.createRoom.okButton)
			Main.createRoom.okButton.setIcon(new ImageIcon("image/button/90x30.png"));

		// 대기방 버튼

		if (e.getSource() == Main.multiRoom.multiRoomButton[0])
			Main.multiRoom.multiRoomButton[0].setIcon(new ImageIcon("image/button/115x30.png"));
		if (e.getSource() == Main.multiRoom.multiRoomButton[1])
			Main.multiRoom.multiRoomButton[1].setIcon(new ImageIcon("image/button/115x30.png"));
	}
}
