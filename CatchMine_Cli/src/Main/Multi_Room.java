package Main;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Multi_Room extends JPanel {
   JLabel roomNumber, userLabel, chatLabel;
   JList userList;
   JTextArea chatArea;
   JTextField chatField;

   JButton[] multiRoomButton;
   private String[] multiButtonStr = { "����", "������" };

   Design de = new Design();

   public Multi_Room() {
      setSize(400, 600);
      setLayout(null);

      // ����
      roomNumber = new JLabel("N�� ��");
      roomNumber.setSize(80, 30);
      roomNumber.setLocation(165, 10);
      roomNumber.setFont(de.setFont(20));
      roomNumber.setForeground(Color.white);
      add(roomNumber);

      // ä�ù� ��
      chatLabel = new JLabel("ä�ù�");
      chatLabel.setSize(80, 30);
      chatLabel.setLocation(100, 50);
      chatLabel.setFont(de.setFont(20));
      chatLabel.setForeground(Color.white);
      add(chatLabel);

      // ���� ��� ��
      userLabel = new JLabel("�����");
      userLabel.setSize(80, 30);
      userLabel.setLocation(290, 50);
      userLabel.setFont(de.setFont(20));
      userLabel.setForeground(Color.white);
      add(userLabel);

      // ä��â
      chatArea = new JTextArea();
      chatArea.setSize(245, 420);
      chatArea.setLocation(10, 90);
      add(chatArea);
      
      // ������ ���� ���
      userList = new JList();
      userList.setSize(115, 380);
      userList.setLocation(265, 90);
      add(userList);

      // ä�� �Է�â
      chatField = new JTextField(20);
      chatField.setSize(245, 30);
      chatField.setLocation(10, 520);
      add(chatField);

      // ��ư
      multiRoomButton = new JButton[2];
      for (int i = 0; i < multiRoomButton.length; i++) {
         multiRoomButton[i] = new JButton(multiButtonStr[i], de.setButton());
         multiRoomButton[i].setHorizontalTextPosition(SwingConstants.CENTER);
         multiRoomButton[i].setFont(de.setFont(14));
         multiRoomButton[i].setSize(115, 30);
         add(multiRoomButton[i]);
      }
      multiRoomButton[0].setLocation(265, 480);
      multiRoomButton[1].setLocation(265, 520);

      add(de.setBackground());
   }
}