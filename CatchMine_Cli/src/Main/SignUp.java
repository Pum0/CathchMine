package Main;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SignUp extends JFrame  {
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

		namePanel.setOpaque(false);
		idPanel.setOpaque(false);
		nickPanel.setOpaque(false);
		pwPanel.setOpaque(false);
		pwCheckPanel.setOpaque(false);
		submitPanel.setOpaque(false);
		
		// -----------------------�� ����--------------------------
		signUpLabel = new JLabel[5];
		for (int i = 0; i < signUpLabel.length; i++) {
			signUpLabel[i] = new JLabel(signUpString[i]);
			signUpLabel[i].setFont(de.setFont(14));
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
		nameField.setFont(de.setFont(14));
		nameField.setSize(200, 25);
		nameField.setBorder(de.setTextBorder());
		idField = new JTextField(10);
		idField.setFont(de.setFont(14));
		idField.setSize(200, 25);
		idField.setBorder(de.setTextBorder());
		nickField = new JTextField(10);
		nickField.setFont(de.setFont(14));
		nickField.setSize(200, 25);
		nickField.setBorder(de.setTextBorder());

		// ------------------------��й�ȣ �ʵ� ���� -----------------------
		pwField = new JPasswordField(10);
		pwField.setFont(de.setFont(14));
		pwField.setSize(200, 25);
		pwField.setBorder(de.setTextBorder());
		pwCheckField = new JPasswordField(10);
		pwCheckField.setFont(de.setFont(14));
		pwCheckField.setSize(200, 25);
		pwCheckField.setBorder(de.setTextBorder());

		// ------------------------��ư ���� --------------------------------
		checkButton = new JButton[5];
		for (int i = 0; i < checkButton.length; i++) {
			if(i < 3) {
				checkButton[i] = new JButton(buttonString[i], new ImageIcon("image/button/60x25.png"));
				checkButton[i].setSize(60, 25);
				checkButton[i].setFont(de.setFont(12));
			} else {
				checkButton[i] = new JButton(buttonString[i], new ImageIcon("image/button/120x40.png"));
				checkButton[i].setSize(120, 40); 
				checkButton[i].setFont(de.setFont(12));
			}
			checkButton[i].setHorizontalTextPosition(SwingConstants.CENTER);
			checkButton[i].setBorderPainted(false);
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
		add(de.setSignUpBackground());

		setVisible(false);
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
