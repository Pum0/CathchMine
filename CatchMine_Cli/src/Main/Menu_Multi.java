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
	Vector userColumn = new Vector(); // 유저 콜륨값
	Vector userData = new Vector(); // 유저 데이터값

	JTextField chatField;
	JButton[] multiButton;
	String[] multiButtonString = { "방 생성하기", "방 입장하기", "뒤로가기" };

	Design de = new Design();

	public void addUserInfo(String userNick, String userID) {
		userData.addElement(userNick);
		userData.addElement(userID);
		
	} // 유저 목록 생성 메소드

	public void removeUserInfo(String userNick, String userID) {
		userData.removeElement(userNick);
		userData.removeElement(userID);
	}

	public Menu_Multi() {
		setSize(400, 600);
		setLayout(null);

		// 생성
		roomLabel = new JLabel("방목록");
		roomLabel.setFont(de.setFont(20)); // 폰트지정
		roomLabel.setForeground(Color.white);

		standbyRoom = new JList();
		multiButton = new JButton[3];
		for (int i = 0; i < multiButton.length; i++) {
			multiButton[i] = new JButton(multiButtonString[i], de.setButton());
			multiButton[i].setHorizontalTextPosition(SwingConstants.CENTER);
			multiButton[i].setFont(de.setFont(14));
		}
		chatLabel = new JLabel("채팅방"); // 폰트지정
		chatLabel.setFont(de.setFont(20));
		chatLabel.setForeground(Color.white);

		chatArea = new JTextArea(10, 10);
		chatSPane = new JScrollPane(chatArea);

		userLabel = new JLabel("사용자"); // 폰트지정
		userLabel.setFont(de.setFont(20));
		userLabel.setForeground(Color.white);

		// 유저 테이블 생성
		userColumn.add("닉네임");
		userColumn.add("ID");

		userTm = new DefaultTableModel(userColumn, 0);
		userTable = new JTable(userTm);
		userSPane = new JScrollPane(userTable);
		userTable.getTableHeader().setReorderingAllowed(false); // 헤드 이동(드래그)불가
		userTable.setDragEnabled(false); // 선택 드래그 불가
		userTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// 싱글 선택 모드
		userTable.setShowGrid(false);
		userTable.getColumnModel().getColumn(0).setPreferredWidth(180);
		userTable.setRowHeight(20);
		userSPane.getViewport().setBackground(Color.white);
		
		// 테두리 설정
		standbyRoom.setBorder(de.setBorder());
		chatSPane.setBorder(de.setBorder());
		userSPane.setBorder(de.setBorder());

		// 테이블 내용 가운데 정렬하기
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = userTable.getColumnModel();

		// 전체 열에 지정
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
		
		// -----------------------유저 테이블 설정 끝----------

		chatField = new JTextField(20);
		chatField.setBorder(new LineBorder(Color.DARK_GRAY, 3));

		// 사이즈 설정
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

		chatArea.setEditable(false); // 채팅 에리아 에디트 금지

		// 추가
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