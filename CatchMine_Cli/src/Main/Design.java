package Main;
import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Design {
   Font font = new Font("한컴 윤체 L", Font.BOLD, 14);
   Font sfont = new Font("한컴 윤체 L", Font.BOLD, 12);
   Font roomLabelFont = new Font("한컴 윤체 L", Font.BOLD, 20);
   
   
   // 버튼 이미지 지정
   public ImageIcon setButton() {
      return new ImageIcon("image/sample.png");
   }
   
   
   // 배경 이미지 지정
   public Component setBackground() {
      JLabel back = new JLabel();
      
      back.setIcon(new ImageIcon("image/backgroundImage.png"));
      back.setSize(400, 600);
      back.setLocation(0, 0);
      return back;
   }
}