package Scenes;

import javax.swing.*;

import Main.Design;

public class Create_Room extends JFrame {
	JLabel roomNum;
	public JTextField roomField;
	public JButton okButton;

	Design de = new Design();

	public Create_Room() {
		setTitle("방 생성");
		setSize(350, 200);
		setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);

		// 생성
		roomNum = new JLabel("방 제목을 입력하세요!");
		roomField = new JTextField(20);
		okButton = new JButton("생성", new ImageIcon("image/button/90x30.png"));
		okButton.setHorizontalTextPosition(SwingConstants.CENTER);
		okButton.setBorderPainted(false);
		roomNum.setSize(300, 30);
		roomNum.setFont(de.setFont(20)); // 폰트지정

		roomField.setSize(200, 30);
		okButton.setSize(90, 30);
		okButton.setFont(de.setFont(15));

		// 위치지정
		roomNum.setLocation(65, 20);
		roomField.setLocation(65, 60);
		okButton.setLocation(120, 100);

		add(roomNum);
		add(roomField);
		add(okButton);

		setVisible(false);
	}
}