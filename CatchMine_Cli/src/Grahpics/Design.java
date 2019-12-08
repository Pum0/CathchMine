package Grahpics;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class Design {

	// 버튼 이미지 지정
	public ImageIcon setButton() {
		return new ImageIcon("image/sample.png");
	}

	public Font setFont(int i) {
		Font font = new Font("한컴 윤체 L", Font.BOLD, i);

		return font;
	}

	// 배경 이미지 지정
	public Component setBackground() {
		JLabel back = new JLabel();

		back.setIcon(new ImageIcon("image/backgroundImage.png"));
		back.setSize(400, 600);
		back.setLocation(0, 0);
		return back;
	}

	public Component setSignUpBackground() {
		JLabel back = new JLabel();

		back.setIcon(new ImageIcon("image/SignUp.png"));
		back.setSize(400, 450);
		back.setLocation(0, 0);
		return back;
	}

	public LineBorder setBorder() {
		LineBorder border = new LineBorder(Color.DARK_GRAY, 3);

		return border;
	}

	public LineBorder setTextBorder() {
		LineBorder border = new LineBorder(Color.DARK_GRAY, 2);

		return border;
	}
}