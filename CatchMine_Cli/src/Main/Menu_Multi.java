package Main;

import java.awt.Color;

import javax.swing.*;

public class Menu_Multi extends JPanel {
   JLabel roomLabel, chatLabel, userLabel;
   JList standbyRoom, UserList;
   JTextArea chatArea;
   JTextField chatField;
   JButton[] multiButton;
   String[] multiButtonString = { "�� �����ϱ�", "�� �����ϱ�", "�ڷΰ���" };

   Design de = new Design();

   public Menu_Multi() {
      setSize(400, 600);
      setLayout(null);

      // ����
      roomLabel = new JLabel("����");
      roomLabel.setFont(de.roomLabelFont); // ��Ʈ����
      roomLabel.setForeground(Color.white);

      standbyRoom = new JList();
      multiButton = new JButton[3];
      for (int i = 0; i < multiButton.length; i++) {
         multiButton[i] = new JButton(multiButtonString[i], de.setButton());
         multiButton[i].setHorizontalTextPosition(SwingConstants.CENTER);
         multiButton[i].setFont(de.font);
      }
      chatLabel = new JLabel("ä�ù�"); // ��Ʈ����
      chatLabel.setFont(de.roomLabelFont);
      chatLabel.setForeground(Color.white);

      chatArea = new JTextArea();

      userLabel = new JLabel("�����"); // ��Ʈ����
      userLabel.setFont(de.roomLabelFont);
      userLabel.setForeground(Color.white);

      UserList = new JList();
      chatField = new JTextField(20);

      // ������ ����
      roomLabel.setSize(80, 30);
      standbyRoom.setSize(375, 165);
      multiButton[0].setSize(185, 45);
      multiButton[1].setSize(185, 45);
      chatLabel.setSize(80, 30);
      userLabel.setSize(80, 30);
      chatArea.setSize(250, 210);
      UserList.setSize(115, 210);
      chatField.setSize(250, 30);
      multiButton[2].setSize(115, 30);

      // ��ġ����
      roomLabel.setLocation(165, 10);
      standbyRoom.setLocation(10, 50);
      multiButton[0].setLocation(10, 225);
      multiButton[1].setLocation(200, 225);
      chatLabel.setLocation(105, 275);
      userLabel.setLocation(295, 275);
      chatArea.setLocation(10, 310);
      UserList.setLocation(270, 310);
      chatField.setLocation(10, 530);
      multiButton[2].setLocation(270, 530);

      chatArea.setEditable(false); // ä�� ������ ����Ʈ ����

      // �߰�
      add(roomLabel);
      add(standbyRoom);
      add(multiButton[0]);
      add(multiButton[1]);
      add(chatLabel);
      add(userLabel);
      add(chatArea);
      add(UserList);
      add(chatField);
      add(multiButton[2]);
      add(de.setBackground());
   }
}