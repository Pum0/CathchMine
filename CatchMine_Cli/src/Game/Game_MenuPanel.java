package Game;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game_MenuPanel extends JPanel {
	// �޴��� �־�� �� ��� ���� ������, ��밡���� ��� ����, ��Ƽ�� ���� ���
	final static int MENUXSIZE = 1400;
	final static int MENUYSIZE = 100;

	private ImageIcon statusImage = new ImageIcon("image/status.png");
	private JLabel statIcon;

	// ���� ���� �޴� UI �г�
	private JPanel menuPanel; // Ÿ�̸� �г�
	private JLabel timeLabel; // �ð��� ��µǴ� ���̺�

	// ���� �÷��� �ð�
	final static int time = 0;

	singleGame sG = new singleGame(); // �̱۰��� Ŭ������ �ʵ带 ����ϱ����ؼ� ���

	JLabel mineLabel;

	public Game_MenuPanel() {
		setLayout(null);
		setSize(MENUXSIZE, MENUYSIZE);
		this.setBackground(Color.BLUE);
		statIcon = new JLabel();
		statIcon.setIcon(statusImage);

		menuPanel = new JPanel();
		menuPanel.setLayout(null);
		menuPanel.setBounds(0, 0, MENUXSIZE, MENUYSIZE);
		menuPanel.setOpaque(false);

		timeLabel = new JLabel(timer(time));
		menuPanel.add(timeLabel);

		timeLabel.setFont(new Font("���׷�ü", Font.BOLD, 50));
		timeLabel.setBounds(650, 0, 200, 100);

		mineLabel = new JLabel(sG.getMineCount() + "");
		menuPanel.add(mineLabel);
		
		mineLabel.setFont(new Font("���׷�ü", Font.BOLD, 38));
		mineLabel.setBounds(540, 0, 200, 100);

		new timerThread().start();

		menuPanel.setLocation(0, 0);
//		setLocation(20, 20);

		setOpaque(false);

		add(menuPanel);
		add(statIcon);
		statIcon.setBounds(0, 0, MENUXSIZE, MENUYSIZE);

	}

	// �÷��� Ÿ���� 00:00 �������� ���
	public String timer(int time) {
		int min = time / 60;
		int sec = time % 60;

		return String.format("%d : %02d", min, sec);
	}

	// �ð��� �귯���� ����
	class timerThread extends Thread {

		@Override
		public void run() {
			int count = 0;
			while (true) {
				count++;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("timerThread");
					System.out.println(e.toString());
				}
				timeLabel.setText("");
				timeLabel.setText(timer(count));

			}
		}
	}

}
