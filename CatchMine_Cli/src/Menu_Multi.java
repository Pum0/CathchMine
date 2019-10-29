import javax.swing.*;

public class Menu_Multi extends JPanel {
	JList standbyRoom, UserList;
	JTextArea chatArea;
	JTextField chatField;
	JButton[] multiButton;
	String[] multiButtonString = { "�� �����ϱ�", "�� �����ϱ�", "������" };
	JPanel standbyPanel, buttonPanel, chatAreaPanel, chatPanel;

	public Menu_Multi() {
		setSize(400, 600);
		setLayout(null);

		// ------------------------�г� ����,���� ------------------------

		standbyPanel = new JPanel(); // �̸� �г�
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

		// -------------------------����Ʈ ����-----------------------------
		standbyRoom = new JList();
		standbyRoom.setSize(385, 245);

		UserList = new JList();
		UserList.setSize(125, 220);

		// --------------------------��ư ����------------------------------
		multiButton = new JButton[3];
		for (int i = 0; i < multiButton.length; i++) {
			multiButton[i] = new JButton(multiButtonString[i]);
		}
		for(int i=0;i<2;i++) {
			multiButton[i].setSize(190,45);
		}
		multiButton[2].setSize(125,30);
		
		
		// ----------------------�ؽ�Ʈ�Ƹ��� ����--------------------------
		chatArea = new JTextArea();
		chatArea.setSize(255, 220);
		chatArea.setEditable(false);
		
		// -----------------------�ؽ�Ʈ �ʵ� ����--------------------------
		chatField = new JTextField(20);
		chatField.setSize(255,30);
		
		// --------------------���Ĺ����г� ����Ʈ �߰�---------------------
		standbyRoom.setLocation(5, 5);
		standbyPanel.add(standbyRoom);
		
		// -------------------------��ư�г� ��ư�߰� ----------------------
		multiButton[0].setLocation(5,5);
		multiButton[1].setLocation(200, 5);
		
		buttonPanel.add(multiButton[0]);
		buttonPanel.add(multiButton[1]);
		
		//--------------ê�Ƹ����г� ����Ʈ, �ؽ�Ʈ �Ƹ��� �߰�-------------
		chatArea.setLocation(5, 5);
		UserList.setLocation(265,5);
		chatAreaPanel.add(chatArea);
		chatAreaPanel.add(UserList);		
		
		//---------------------ê�г� �ʵ�,��ư �߰�-----------------------
		chatField.setLocation(5, 5);
		multiButton[2].setLocation(265, 5);
		chatPanel.add(chatField);
		chatPanel.add(multiButton[2]);
		
		//---------------�г� �߰�-----------------------------------------
		
		add(standbyPanel);
		add(buttonPanel);
		add(chatAreaPanel);
		add(chatPanel);
		
		this.repaint();
		
	}
}
