package Scenes;

import javax.swing.*;

import Main.Design;

public class Create_Room extends JFrame {
	JLabel roomNum;
	public JTextField roomField;
	public JButton okButton;

	Design de = new Design();

	public Create_Room() {
		setTitle("�� ����");
		setSize(350, 200);
		setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);

		// ����
		roomNum = new JLabel("�� ������ �Է��ϼ���!");
		roomField = new JTextField(20);
		okButton = new JButton("����", new ImageIcon("image/button/90x30.png"));
		okButton.setHorizontalTextPosition(SwingConstants.CENTER);
		okButton.setBorderPainted(false);
		roomNum.setSize(300, 30);
		roomNum.setFont(de.setFont(20)); // ��Ʈ����

		roomField.setSize(200, 30);
		okButton.setSize(90, 30);
		okButton.setFont(de.setFont(15));

		// ��ġ����
		roomNum.setLocation(65, 20);
		roomField.setLocation(65, 60);
		okButton.setLocation(120, 100);

		add(roomNum);
		add(roomField);
		add(okButton);

		setVisible(false);
	}
}