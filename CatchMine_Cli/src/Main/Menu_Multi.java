package Main;

import java.awt.Color;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Menu_Multi extends JPanel {
	JLabel roomLabel, chatLabel, userLabel;
	JList standbyRoom;
	JTextArea chatArea;
	JTable userTable;
	DefaultTableModel userTm;
	JScrollPane userSPane, chatSPane;
	Vector userColumn = new Vector(); // ���� �ݷ���
	Vector userData = new Vector(); // ���� �����Ͱ�

	JTextField chatField;
	JButton[] multiButton;
	String[] multiButtonString = { "�� �����ϱ�", "�� �����ϱ�", "�ڷΰ���" };

	Design de = new Design();

	public void addUserInfo(String userNick, String userID) {
		userData.addElement(userNick);
		userData.addElement(userID);
		
	} // ���� ��� ���� �޼ҵ�

	public void removeUserInfo(String userNick, String userID) {
		userData.removeElement(userNick);
		userData.removeElement(userID);
	}

	public Menu_Multi() {
		setSize(400, 600);
		setLayout(null);

		// ����
		roomLabel = new JLabel("����");
		roomLabel.setFont(de.setFont(20)); // ��Ʈ����
		roomLabel.setForeground(Color.white);

		standbyRoom = new JList();
		multiButton = new JButton[3];
		for (int i = 0; i < multiButton.length; i++) {
			multiButton[i] = new JButton(multiButtonString[i], de.setButton());
			multiButton[i].setHorizontalTextPosition(SwingConstants.CENTER);
			multiButton[i].setFont(de.setFont(14));
		}
		chatLabel = new JLabel("ä�ù�"); // ��Ʈ����
		chatLabel.setFont(de.setFont(20));
		chatLabel.setForeground(Color.white);

		chatArea = new JTextArea(10, 10);
		chatSPane = new JScrollPane(chatArea);

		userLabel = new JLabel("�����"); // ��Ʈ����
		userLabel.setFont(de.setFont(20));
		userLabel.setForeground(Color.white);

		// ���� ���̺� ����
		userColumn.add("�г���");
		userColumn.add("ID");

		userTm = new DefaultTableModel(userColumn, 0);
		userTable = new JTable(userTm);
		userSPane = new JScrollPane(userTable);
		userTable.getTableHeader().setReorderingAllowed(false); // ��� �̵�(�巡��)�Ұ�
		userTable.setDragEnabled(false); // ���� �巡�� �Ұ�
		userTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// �̱� ���� ���
		userTable.setShowGrid(false);
		userTable.getColumnModel().getColumn(0).setPreferredWidth(180);
		userTable.setRowHeight(20);
		userSPane.getViewport().setBackground(Color.white);
		
		// �׵θ� ����
		standbyRoom.setBorder(de.setBorder());
		chatSPane.setBorder(de.setBorder());
		userSPane.setBorder(de.setBorder());

		// ���̺� ���� ��� �����ϱ�
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = userTable.getColumnModel();

		// ��ü ���� ����
		for (int j = 0; j < tcm.getColumnCount(); j++)
			tcm.getColumn(j).setCellRenderer(dtcr);

		addUserInfo("1234323413424", "122");
		addUserInfo("12343341342", "2");
		addUserInfo("123", "3");
		addUserInfo("123", "4");
		addUserInfo("123", "5");
		addUserInfo("123", "6");
		addUserInfo("123", "7");
		addUserInfo("123", "8");
		addUserInfo("123", "9");
		addUserInfo("123", "10");

		userTm.addRow(userData);
		userTm.addRow(userData);
		userTm.addRow(userData);
		userTm.addRow(userData);
		userTm.addRow(userData);
		userTm.addRow(userData);
		userTm.addRow(userData);
		userTm.addRow(userData);
		userTm.addRow(userData);
		userTm.addRow(userData);
		userTable.setEnabled(false);
		
		// -----------------------���� ���̺� ���� ��----------

		chatField = new JTextField(20);
		chatField.setBorder(new LineBorder(Color.DARK_GRAY, 3));

		// ������ ����
		roomLabel.setBounds(165, 10, 80, 30);
		standbyRoom.setBounds(10, 50, 370, 165);
		multiButton[0].setBounds(10, 225, 180, 45);
		multiButton[1].setBounds(200, 225, 180, 45);
		chatLabel.setBounds(105, 275, 80, 30);
		userLabel.setBounds(295, 275, 80, 30);
		chatSPane.setBounds(10, 310, 250, 210);
		userSPane.setBounds(265, 310, 115, 210);
		chatField.setBounds(10, 525, 250, 30);
		multiButton[2].setBounds(265, 525, 115, 30);

		chatArea.setEditable(false); // ä�� ������ ����Ʈ ����

		// �߰�
		add(roomLabel);
		add(standbyRoom);
		add(multiButton[0]);
		add(multiButton[1]);
		add(chatLabel);
		add(userLabel);
		add(chatSPane);
		add(userSPane);
		add(chatField);
		add(multiButton[2]);
		add(de.setBackground());
	}
}