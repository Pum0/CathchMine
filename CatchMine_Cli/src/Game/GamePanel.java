package Game;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

class GamePanel extends JPanel {
   final static int FRAMEXSIZE = 1440;
   final static int FRAMEYSIZE = 900;
   static GamePanel GP;
   // 게임요소들을 담고 있는 패널
   Game_MenuPanel menu;
   singleGame single;
   
   JLabel windefeat;
   
//   multiGame multi;

   public GamePanel() {
      this.setBackground(Color.BLACK);
      this.setLayout(null);

      System.out.println("꼐임 패널");
      single = new singleGame(); // 싱글 게임 클래스

      single.setBounds(15, 140, single.GAMEXSIZE, single.GAMEYSIZE);
      menu = new Game_MenuPanel();
      add(single);
      add(menu);
      menu.setBounds(15, 20, menu.MENUXSIZE, menu.MENUYSIZE);

   }

}