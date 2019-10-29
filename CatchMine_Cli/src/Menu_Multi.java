import javax.swing.*;

public class Menu_Multi extends JPanel {
	JList standbyRoom, UserList;
	JTextArea chatArea;
	JTextField chatField;
	JButton[] multiButton;
	String[] multiButtonString = { "방 생성하기", "방 입장하기", "나가기" };
	JPanel standbyPanel, buttonPanel, chatAreaPanel, chatPanel;

	public Menu_Multi() {
		setSize(400, 600);
		setLayout(null);

		// ------------------------패널 설정,생성 ------------------------

		standbyPanel = new JPanel(); // 이름 패널
		standbyPanel.setLayout(null);
		standbyPanel.setSize(400, 250);
		standbyPanel.setLocation(0, 0);

		buttonPanel = new JPanel();
		buttonPanel.setLayout(null);
		buttonPanel.setSize(400, 50);
		buttonPanel.setLocation(0, 250);

		chatAreaPanel = new JPanel();
		chatAreaPanel.setLayout(null);
		chatAreaPanel.setSize(400,225);
		chatAreaPanel.setLocation(0, 300);
		
		chatPanel = new JPanel();
		chatPanel.setLayout(null);
		chatPanel.setSize(400, 40);
		chatPanel.setLocation(0, 525);

		// -------------------------리스트 생성-----------------------------
		standbyRoom = new JList();
		standbyRoom.setSize(385, 245);

		UserList = new JList();
		UserList.setSize(125, 220);

		// --------------------------버튼 생성------------------------------
		multiButton = new JButton[3];
		for (int i = 0; i < multiButton.length; i++) {
			multiButton[i] = new JButton(multiButtonString[i]);
		}
		for(int i=0;i<2;i++) {
			multiButton[i].setSize(190,45);
		}
		multiButton[2].setSize(125,30);
		
		
		// ----------------------텍스트아리아 생성--------------------------
		chatArea = new JTextArea();
		chatArea.setSize(255, 220);
		chatArea.setEditable(false);
		
		// -----------------------텍스트 필드 생성--------------------------
		chatField = new JTextField(20);
		chatField.setSize(255,30);
		
		// --------------------스탠바이패널 리스트 추가---------------------
		standbyRoom.setLocation(5, 5);
		standbyPanel.add(standbyRoom);
		
		// -------------------------버튼패널 버튼추가 ----------------------
		multiButton[0].setLocation(5,5);
		multiButton[1].setLocation(200, 5);
		
		buttonPanel.add(multiButton[0]);
		buttonPanel.add(multiButton[1]);
		
		//--------------챗아리아패널 리스트, 텍스트 아리아 추가-------------
		chatArea.setLocation(5, 5);
		UserList.setLocation(265,5);
		chatAreaPanel.add(chatArea);
		chatAreaPanel.add(UserList);		
		
		//---------------------챗패널 필드,버튼 추가-----------------------
		chatField.setLocation(5, 5);
		multiButton[2].setLocation(265, 5);
		chatPanel.add(chatField);
		chatPanel.add(multiButton[2]);
		
		//---------------패널 추가-----------------------------------------
		
		add(standbyPanel);
		add(buttonPanel);
		add(chatAreaPanel);
		add(chatPanel);
		
		this.repaint();
		
	}
}
