package Main;

import javax.swing.*;

public class Create_Room extends JFrame {
   JLabel roomNum;
   JTextField roomField;
   JButton okButton;
   
   Design de = new Design();
   
   public Create_Room() {
      setTitle("�� ����");
      setSize(400, 250);
      setResizable(false);
      setLayout(null);
      setLocationRelativeTo(null);
      
      //����
      roomNum = new JLabel("�� ������ �Է��ϼ���!");
      roomField = new JTextField(20);
      okButton = new JButton("����");
      
      roomNum.setSize(300, 30);
      roomNum.setFont(de.roomLabelFont);   //��Ʈ����
      
      roomField.setSize(300, 30);
      okButton.setSize(80, 50);
      okButton.setFont(de.roomLabelFont);
      
      //��ġ����
      roomNum.setLocation(100, 30);
      roomField.setLocation(50, 100);
      okButton.setLocation(160, 150);
      
      add(roomNum);
      add(roomField);
      add(okButton);
      
      setVisible(true);
   }

}