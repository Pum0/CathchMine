package Main;
import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Design {
   Font font = new Font("���� ��ü L", Font.BOLD, 14);
   Font sfont = new Font("���� ��ü L", Font.BOLD, 12);
   Font roomLabelFont = new Font("���� ��ü L", Font.BOLD, 20);
   
   
   // ��ư �̹��� ����
   public ImageIcon setButton() {
      return new ImageIcon("image/sample.png");
   }
   
   
   // ��� �̹��� ����
   public Component setBackground() {
      JLabel back = new JLabel();
      
      back.setIcon(new ImageIcon("image/backgroundImage.png"));
      back.setSize(400, 600);
      back.setLocation(0, 0);
      return back;
   }
}