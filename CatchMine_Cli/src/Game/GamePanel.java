package Game;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

class GamePanel extends JPanel {
   final static int FRAMEXSIZE = 1440;
   final static int FRAMEYSIZE = 900;
   static GamePanel GP;
   // ���ӿ�ҵ��� ��� �ִ� �г�
   Game_MenuPanel menu;
   singleGame single;
   
   JLabel windefeat;
   
//   multiGame multi;

   public GamePanel() {
      this.setBackground(Color.BLACK);
      this.setLayout(null);

      System.out.println("���� �г�");
      single = new singleGame(); // �̱� ���� Ŭ����

      single.setBounds(15, 140, single.GAMEXSIZE, single.GAMEYSIZE);
      menu = new Game_MenuPanel();
      add(single);
      add(menu);
      menu.setBounds(15, 20, menu.MENUXSIZE, menu.MENUYSIZE);

   }

}