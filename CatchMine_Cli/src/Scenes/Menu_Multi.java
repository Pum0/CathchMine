package Scenes;

import java.awt.Color;
import java.awt.Point;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Grahpics.Design;
import MyListener.Action;
import MyListener.Key;
import MyListener.Mouse;

public class Menu_Multi extends JPanel {
	JLabel roomLabel, chatLabel, userLabel;
	JList standbyRoom;
	public JTextArea chatArea;
	JTable userTable;
	DefaultListModel roomModel;
	DefaultTableModel userTm;
	public JScrollPane userSPane, chatSPane;
	Vector userColumn = new Vector(); // ���� �ݷ���
	Vector userData = new Vector(); // ���� �����Ͱ�

	public JTextField chatField;
	public JButton[] multiButton;
	String[] multiButtonString = { "�� �����ϱ�", "�� �����ϱ�", "�ڷΰ���" };

//	public JOptionPane createRoom;

	Action al = new Action();
	Key kl = new Key();
	Mouse ml = new Mouse();
	Design de = new Design();

	Action ac = new Action();

	public Menu_Multi() {
		setSize(400, 600);
		setLayout(null);

		// ����
		roomLabel = new JLabel("����");
		roomLabel.setFont(de.setFont(20)); // ��Ʈ����
		roomLabel.setForeground(Color.white);

		standbyRoom = new JList(new DefaultListModel<Roomlist>());
		roomModel = (DefaultListModel) standbyRoom.getModel();
		roomModel.addElement(new Roomlist("�ù�waerwerrwewer", 1));
		roomModel.addElement(new Roomlist("��", 1));

		multiButton = new JButton[3];
		for (int i = 0; i < multiButton.length; i++) {
			if (i < 2)
				multiButton[i] = new JButton(multiButtonString[i], new ImageIcon("image/button/180x45.png"));
			else
				multiButton[i] = new JButton(multiButtonString[i], new ImageIcon("image/button/115x30.png"));
			multiButton[i].setBorderPainted(false);
			multiButton[i].setHorizontalTextPosition(SwingConstants.CENTER);
			multiButton[i].setFont(de.setFont(14));
		}
		chatLabel = new JLabel("ä�ù�"); // ��Ʈ����
		chatLabel.setFont(de.setFont(20));
		chatLabel.setForeground(Color.white);

		chatArea = new JTextArea(10, 10);
		chatSPane = new JScrollPane(chatArea);
		chatSPane.getViewport().setViewPosition(new Point(0, 0));

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

		// ��Ƽ �г�
		for (int i = 0; i < multiButton.length; i++) {
			multiButton[i].addActionListener(al);
			multiButton[i].addMouseListener(ml);
		}
		chatField.addActionListener(al);

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

class Roomlist {
	String name;
	int num;

	public Roomlist(String name, int num) {
		this.name = name;
		this.num = num;
	}

	@Override
	public String toString() {
		return String.format("      %-90s%d/2", name, num);
	}
}