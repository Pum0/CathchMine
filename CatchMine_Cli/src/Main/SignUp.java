package Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SignUp extends JFrame implements ActionListener {
	JTextField nameField, idField, nickField;
	JPasswordField pwField;
	JPasswordField pwCheckField;
	JPanel namePanel, idPanel, nickPanel, pwPanel, pwCheckPanel, submitPanel;

	JLabel[] signUpLabel;
	String[] signUpString = { "����� �̸�", "ID", "�г���", "��й�ȣ", "��й�ȣ Ȯ��" };

	JLabel idCheckLabel, nickCheckLabel, pwCheckLabel;
	String[] idChekLabelString = {"ID�� �Է����ּ���", "��� ������ ID�Դϴ�.", "��� �Ұ����� ID�Դϴ�." };
	String[] nickCheckLabelString = {"�г����� �Է����ּ���", "��밡���� �г����Դϴ�.", "��� �Ұ����� �г����Դϴ�." };
	String[] pwCheckLabelString = { "��й�ȣ�� �Է����ּ���.", "��й�ȣ�� ��ġ�մϴ�.", "��й�ȣ�� ��ġ���� �ʽ��ϴ�." };
	JButton[] checkButton;
	String[] buttonString = { "Ȯ��", "Ȯ��", "Ȯ��", "�����ϱ�", "�ڷΰ���" };
	
	Design de = new Design();

	public SignUp() {
		setTitle("ȸ������");
		setSize(400, 450);
		setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);

		// ------------------------�г� ����,���� ------------------------

		namePanel = new JPanel(); // �̸� �г�
		namePanel.setLayout(null);
		namePanel.setSize(400, 60);
		namePanel.setLocation(0, 20);

		idPanel = new JPanel(); // ID �г�
		idPanel.setLayout(null);
		idPanel.setSize(400, 60);
		idPanel.setLocation(0, 80);

		nickPanel = new JPanel(); // �г��� �г�
		nickPanel.setLayout(null);
		nickPanel.setSize(400, 60);
		nickPanel.setLocation(0, 140);

		pwPanel = new JPanel(); // ��й�ȣ �г�
		pwPanel.setLayout(null);
		pwPanel.setSize(400, 60);
		pwPanel.setLocation(0, 200);

		pwCheckPanel = new JPanel(); // ��й�ȣ Ȯ�� �г�
		pwCheckPanel.setLayout(null);
		pwCheckPanel.setSize(400, 60);
		pwCheckPanel.setLocation(0, 260);

		submitPanel = new JPanel(); // �����ư �г�
		submitPanel.setLayout(null);
		submitPanel.setSize(400, 60);
		submitPanel.setLocation(0, 330);

		// -----------------------�� ����--------------------------
		signUpLabel = new JLabel[5];
		for (int i = 0; i < signUpLabel.length; i++) {
			signUpLabel[i] = new JLabel(signUpString[i]);
			signUpLabel[i].setSize(100, 25);
		}

		// -----------------------Ȯ�� �� ����----------------------
		idCheckLabel = new JLabel();
		idCheckLabel.setSize(200, 25);

		nickCheckLabel = new JLabel();
		nickCheckLabel.setSize(200, 25);

		pwCheckLabel = new JLabel();
		pwCheckLabel.setSize(200, 25);

		// ------------------------�ؽ�Ʈ �ʵ����--------------------------
		nameField = new JTextField(10);
		nameField.setFont(de.font);
		nameField.setSize(200, 25);
		idField = new JTextField(10);
		idField.setFont(de.font);
		idField.setSize(200, 25);
		nickField = new JTextField(10);
		nickField.setFont(de.font);
		nickField.setSize(200, 25);

		// ------------------------��й�ȣ �ʵ� ���� -----------------------
		pwField = new JPasswordField(10);
		pwField.setFont(de.font);
		pwField.setSize(200, 25);
		pwCheckField = new JPasswordField(10);
		pwCheckField.setFont(de.font);
		pwCheckField.setSize(200, 25);

		// ------------------------��ư ���� --------------------------------
		checkButton = new JButton[5];
		for (int i = 0; i < checkButton.length; i++) {
			checkButton[i] = new JButton(buttonString[i], de.setButton());
			checkButton[i].setHorizontalTextPosition(SwingConstants.CENTER);
			
			if(i < 3) {
				checkButton[i].setSize(60, 25);
				checkButton[i].setFont(de.sfont);
			} else {
				checkButton[i].setSize(120, 40); 
				checkButton[i].setFont(de.font);
			}
		}

		// -----------------------�̸� �гο� ��,�ʵ� �߰�-----------------
		signUpLabel[0].setLocation(20, 10);
		nameField.setLocation(100, 10);

		namePanel.add(signUpLabel[0]);
		namePanel.add(nameField);

		// -------------Id �гο� ��,�ʵ�,Ȯ�� ��,��ư �߰�--------------
		signUpLabel[1].setLocation(40, 10);
		idField.setLocation(100, 10);
		checkButton[0].setLocation(310, 10);
		idCheckLabel.setLocation(100, 35);

		idPanel.add(signUpLabel[1]);
		idPanel.add(idField);
		idPanel.add(checkButton[0]);
		idPanel.add(idCheckLabel);

		// -----------�г��� �гο� ��,�ʵ�,Ȯ�� ��,��ư �߰�------------
		signUpLabel[2].setLocation(30, 10);
		nickField.setLocation(100, 10);
		checkButton[1].setLocation(310, 10);
		nickCheckLabel.setLocation(100, 35);

		nickPanel.add(signUpLabel[2]);
		nickPanel.add(nickField);
		nickPanel.add(checkButton[1]);
		nickPanel.add(nickCheckLabel);

		// -------------------��й�ȣ �гο� ��,�ʵ��߰�------------------
		signUpLabel[3].setLocation(25, 10);
		pwField.setLocation(100, 10);

		pwPanel.add(signUpLabel[3]);
		pwPanel.add(pwField);

		// ----------��й�ȣ Ȯ�� �гο� ��,�ʵ�,��ư,Ȯ�� �� �߰�-----------
		signUpLabel[4].setLocation(10, 10);
		pwCheckField.setLocation(100, 10);
		checkButton[2].setLocation(310, 10);
		pwCheckLabel.setLocation(100, 35);

		pwCheckPanel.add(signUpLabel[4]);
		pwCheckPanel.add(pwCheckField);
		pwCheckPanel.add(checkButton[2]);
		pwCheckPanel.add(pwCheckLabel);

		// ------------------�����ư �гο� ��ư �߰�-----------------------
		checkButton[3].setLocation(70, 10);
		checkButton[4].setLocation(200, 10);

		submitPanel.add(checkButton[3]);
		submitPanel.add(checkButton[4]);

		// ------------------------�г� �߰�----------------------------------

		add(namePanel);
		add(idPanel);
		add(nickPanel);
		add(pwPanel);
		add(pwCheckPanel);
		add(submitPanel);

		// ---------------------- ������ �߰� ----------------------------------
		checkButton[0].addActionListener(this);
		checkButton[1].addActionListener(this);
		checkButton[2].addActionListener(this);
		checkButton[3].addActionListener(this);
		checkButton[4].addActionListener(this);

		setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		// ID Ȯ�� ��ư
//		if (e.getSource() == checkButton[0]) {
//			if(idField.getText().equals(""))
//				idCheckLabel.setText(idChekLabelString[0]);
//		}
//		
//		// �г��� Ȯ�� ��ư
//		if (e.getSource() == checkButton[1]) {
//			if(nickField.getText().equals(""))
//				nickCheckLabel.setText(nickCheckLabelString[0]);
//		}
//
//		// ��й�ȣ Ȯ�� ��ư
//		if (e.getSource() == checkButton[2]) {
//			if (pwField.getText().equals("") && pwCheckField.getText().equals(""))
//				pwCheckLabel.setText(pwCheckLabelString[0]);
//			else if (pwField.getText().equals(pwCheckField.getText()))
//				pwCheckLabel.setText(pwCheckLabelString[1]);
//			else
//				pwCheckLabel.setText(pwCheckLabelString[2]);
//
//		}
//
//		// �����ϱ� ��ư
//		if (e.getSource() == checkButton[3]) {
//			reset();
//		}
//
//		// �ڷΰ��� ��ư
//		if (e.getSource() == checkButton[4]) {
//			this.setVisible(false);
//			reset();
//		}
	}

	// �����ϱ⳪ �ڷ��ϱ� �Է½� �ʱ�ȭ
	public void reset() {
		nameField.setText("");
		idField.setText("");
		nickField.setText("");
		pwField.setText("");
		pwCheckField.setText("");
	}

}
