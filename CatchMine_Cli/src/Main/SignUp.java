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
	String[] signUpString = { "사용자 이름", "ID", "닉네임", "비밀번호", "비밀번호 확인" };

	JLabel idCheckLabel, nickCheckLabel, pwCheckLabel;
	String[] idChekLabelString = {"ID를 입력해주세요", "사용 가능한 ID입니다.", "사용 불가능한 ID입니다." };
	String[] nickCheckLabelString = {"닉네임을 입력해주세요", "사용가능한 닉네임입니다.", "사용 불가능한 닉네임입니다." };
	String[] pwCheckLabelString = { "비밀번호를 입력해주세요.", "비밀번호가 일치합니다.", "비밀번호가 일치하지 않습니다." };
	JButton[] checkButton;
	String[] buttonString = { "확인", "확인", "확인", "가입하기", "뒤로가기" };
	
	Design de = new Design();

	public SignUp() {
		setTitle("회원가입");
		setSize(400, 450);
		setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);

		// ------------------------패널 설정,생성 ------------------------

		namePanel = new JPanel(); // 이름 패널
		namePanel.setLayout(null);
		namePanel.setSize(400, 60);
		namePanel.setLocation(0, 20);
		idPanel = new JPanel(); // ID 패널
		idPanel.setLayout(null);
		idPanel.setSize(400, 60);
		idPanel.setLocation(0, 80);

		nickPanel = new JPanel(); // 닉네임 패널
		nickPanel.setLayout(null);
		nickPanel.setSize(400, 60);
		nickPanel.setLocation(0, 140);

		pwPanel = new JPanel(); // 비밀번호 패널
		pwPanel.setLayout(null);
		pwPanel.setSize(400, 60);
		pwPanel.setLocation(0, 200);

		pwCheckPanel = new JPanel(); // 비밀번호 확인 패널
		pwCheckPanel.setLayout(null);
		pwCheckPanel.setSize(400, 60);
		pwCheckPanel.setLocation(0, 260);

		submitPanel = new JPanel(); // 제출버튼 패널
		submitPanel.setLayout(null);
		submitPanel.setSize(400, 60);
		submitPanel.setLocation(0, 330);

		namePanel.setOpaque(false);
		idPanel.setOpaque(false);
		nickPanel.setOpaque(false);
		pwPanel.setOpaque(false);
		pwCheckPanel.setOpaque(false);
		submitPanel.setOpaque(false);
		
		// -----------------------라벨 생성--------------------------
		signUpLabel = new JLabel[5];
		for (int i = 0; i < signUpLabel.length; i++) {
			signUpLabel[i] = new JLabel(signUpString[i]);
			signUpLabel[i].setFont(de.setFont(14));
			signUpLabel[i].setSize(100, 25);
		}

		// -----------------------확인 라벨 생성----------------------
		idCheckLabel = new JLabel();
		idCheckLabel.setSize(200, 25);

		nickCheckLabel = new JLabel();
		nickCheckLabel.setSize(200, 25);

		pwCheckLabel = new JLabel();
		pwCheckLabel.setSize(200, 25);

		// ------------------------텍스트 필드생성--------------------------
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

		// ------------------------비밀번호 필드 생성 -----------------------
		pwField = new JPasswordField(10);
		pwField.setFont(de.setFont(14));
		pwField.setSize(200, 25);
		pwField.setBorder(de.setTextBorder());
		pwCheckField = new JPasswordField(10);
		pwCheckField.setFont(de.setFont(14));
		pwCheckField.setSize(200, 25);
		pwCheckField.setBorder(de.setTextBorder());

		// ------------------------버튼 생성 --------------------------------
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

		// -----------------------이름 패널에 라벨,필드 추가-----------------
		signUpLabel[0].setLocation(20, 10);
		nameField.setLocation(100, 10);

		namePanel.add(signUpLabel[0]);
		namePanel.add(nameField);

		// -------------Id 패널에 라벨,필드,확인 라벨,버튼 추가--------------
		signUpLabel[1].setLocation(40, 10);
		idField.setLocation(100, 10);
		checkButton[0].setLocation(310, 10);
		idCheckLabel.setLocation(100, 35);

		idPanel.add(signUpLabel[1]);
		idPanel.add(idField);
		idPanel.add(checkButton[0]);
		idPanel.add(idCheckLabel);

		// -----------닉네임 패널에 라벨,필드,확인 라벨,버튼 추가------------
		signUpLabel[2].setLocation(30, 10);
		nickField.setLocation(100, 10);
		checkButton[1].setLocation(310, 10);
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
		checkButton[2].setLocation(310, 10);
		pwCheckLabel.setLocation(100, 35);

		pwCheckPanel.add(signUpLabel[4]);
		pwCheckPanel.add(pwCheckField);
		pwCheckPanel.add(checkButton[2]);
		pwCheckPanel.add(pwCheckLabel);

		// ------------------제출버튼 패널에 버튼 추가-----------------------
		checkButton[3].setLocation(70, 10);
		checkButton[4].setLocation(200, 10);

		submitPanel.add(checkButton[3]);
		submitPanel.add(checkButton[4]);

		// ------------------------패널 추가----------------------------------

		add(namePanel);
		add(idPanel);
		add(nickPanel);
		add(pwPanel);
		add(pwCheckPanel);
		add(submitPanel);
		add(de.setSignUpBackground());

		setVisible(false);
	}

	// 가입하기나 뒤로하기 입력시 초기화
	public void reset() {
		nameField.setText("");
		idField.setText("");
		nickField.setText("");
		pwField.setText("");
		pwCheckField.setText("");
	}

}
