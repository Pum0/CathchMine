import javax.swing.*;

public class SignUp extends JPanel {
	JTextField nameField, idField, nickField;
	JPasswordField pwField;
	JPasswordField pwCheckField;
	JPanel namePanel, idPanel, nickPanel, pwPanel, pwCheckPanel, submitPanel;

	JLabel[] signUpLabel;
	String[] signUpString = { "사용자 이름", "ID", "닉네임", "비밀번호", "비밀번호 확인" };

	JLabel idCheckLabel, nickCheckLabel, pwCheckLabel;
	String[] idChekLabelString = { "사용 가능한 ID입니다.", "사용 불가능한 ID입니다." };
	String[] nickCheckLabelString = { "사용가능한 닉네임입니다.", "사용 불가능한 닉네임입니다." };
	String[] pwCheckLabelString = { "비밀번호가 일치합니다.", "비밀번호가 일치하지 않습니다." };
	JButton[] checkButton;
	String[] buttonString = { "확인", "확인","확인", "제출","뒤로가기" };

	public SignUp() {

		setSize(400, 600);
		setLayout(null);

		// ------------------------패널 설정,생성 ------------------------

		namePanel = new JPanel(); // 이름 패널
		namePanel.setLayout(null);
		namePanel.setSize(400, 60);
		namePanel.setLocation(0, 90);

		idPanel = new JPanel(); // ID 패널
		idPanel.setLayout(null);
		idPanel.setSize(400, 60);
		idPanel.setLocation(0, 150);

		nickPanel = new JPanel(); // 닉네임 패널
		nickPanel.setLayout(null);
		nickPanel.setSize(400, 60);
		nickPanel.setLocation(0, 210);

		pwPanel = new JPanel(); // 비밀번호 패널
		pwPanel.setLayout(null);
		pwPanel.setSize(400, 60);
		pwPanel.setLocation(0, 270);

		pwCheckPanel = new JPanel(); // 비밀번호 확인 패널
		pwCheckPanel.setLayout(null);
		pwCheckPanel.setSize(400, 60);
		pwCheckPanel.setLocation(0, 330);

		submitPanel = new JPanel(); // 제출버튼 패널
		submitPanel.setLayout(null);
		submitPanel.setSize(400, 60);
		submitPanel.setLocation(0, 390);

		// -----------------------라벨 생성--------------------------
		signUpLabel = new JLabel[5];
		for (int i = 0; i < signUpLabel.length; i++) {
			signUpLabel[i] = new JLabel(signUpString[i]);
			signUpLabel[i].setSize(100, 25);
		}

		// -----------------------확인 라벨 생성----------------------
		idCheckLabel = new JLabel();
		idCheckLabel.setSize(200, 25);

		nickCheckLabel = new JLabel();
		nickCheckLabel.setSize(200, 25);

		pwCheckLabel = new JLabel();
	//	pwCheckLabel.setText(pwCheckLabelString[0]);
		pwCheckLabel.setSize(200, 25);

		// ------------------------텍스트 필드생성--------------------------
		nameField = new JTextField(10);
		nameField.setSize(200, 25);
		idField = new JTextField(10);
		idField.setSize(200, 25);
		nickField = new JTextField(10);
		nickField.setSize(200, 25);

		// ------------------------비밀번호 필드 생성 -----------------------
		pwField = new JPasswordField(10);
		pwField.setSize(200, 25);
		pwCheckField = new JPasswordField(10);
		pwCheckField.setSize(200, 25);

		// ------------------------버튼 생성 --------------------------------
		checkButton = new JButton[5];
		for (int i = 0; i < checkButton.length; i++) {
			checkButton[i] = new JButton(buttonString[i]);

		}
		checkButton[0].setSize(60, 25);
		checkButton[1].setSize(60, 25);
		checkButton[2].setSize(60, 25);
		checkButton[3].setSize(120, 50);
		checkButton[4].setSize(120, 50);

		// -----------------------이름 패널에 라벨,필드 추가-----------------
		signUpLabel[0].setLocation(20, 10);
		nameField.setLocation(100, 10);

		namePanel.add(signUpLabel[0]);
		namePanel.add(nameField);

		// -------------Id 패널에 라벨,필드,확인 라벨,버튼 추가--------------
		signUpLabel[1].setLocation(40, 10);
		idField.setLocation(100, 10);
		checkButton[0].setLocation(320, 10);
		idCheckLabel.setLocation(100, 35);

		idPanel.add(signUpLabel[1]);
		idPanel.add(idField);
		idPanel.add(checkButton[0]);
		idPanel.add(idCheckLabel);

		// -----------닉네임 패널에 라벨,필드,확인 라벨,버튼 추가------------
		signUpLabel[2].setLocation(30, 10);
		nickField.setLocation(100, 10);
		checkButton[1].setLocation(320, 10);
		nickCheckLabel.setLocation(100, 35);

		nickPanel.add(signUpLabel[2]);
		nickPanel.add(nickField);
		nickPanel.add(checkButton[1]);
		nickPanel.add(nickCheckLabel);

		// -------------------비밀번호 패널에 라벨,필드추가------------------
		signUpLabel[3].setLocation(25, 10);
		pwField.setLocation(100, 10);

		pwPanel.add(signUpLabel[3]);
		pwPanel.add(pwField);

		// ----------비밀번호 확인 패널에 라벨,필드,버튼,확인 라벨 추가-----------
		signUpLabel[4].setLocation(10, 10);
		pwCheckField.setLocation(100, 10);
		checkButton[2].setLocation(320, 10);
		pwCheckLabel.setLocation(100, 35);
		

		pwCheckPanel.add(signUpLabel[4]);
		pwCheckPanel.add(pwCheckField);
		pwCheckPanel.add(checkButton[2]);
		pwCheckPanel.add(pwCheckLabel);

		// ------------------제출버튼 패널에 버튼 추가-----------------------
		checkButton[3].setLocation(70, 10);
		checkButton[4].setLocation(200,10);
		
		submitPanel.add(checkButton[3]);
		submitPanel.add(checkButton[4]);
		// ------------------------패널 추가----------------------------------

		add(namePanel);
		add(idPanel);
		add(nickPanel);
		add(pwPanel);
		add(pwCheckPanel);
		add(submitPanel);
	}

	public static void main(String[] args) {
		new SignUp();
	}

}
