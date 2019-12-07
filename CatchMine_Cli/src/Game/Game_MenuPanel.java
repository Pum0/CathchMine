package Game;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game_MenuPanel extends JPanel {
	// �޴��� �־�� �� ��� ���� ������, ��밡���� ��� ����, ��Ƽ�� ���� ���
	final static int MENUXSIZE = 1400;
	final static int MENUYSIZE = 100;

	// ================= ���� �ɼ� �̹��� ================ //

	// ���� ���� �޴� UI �г�
	private JPanel timerPanel; // Ÿ�̸� �г�
	private JLabel timeLabel; // �ð��� ��µǴ� ���̺�

	// ���� �÷��� �ð�
	final static int time = 0;

	// ���� �޴� �ʱ�ȭ
	// �޴� �г� �ʱⱸ��
	public Game_MenuPanel() {
		setLayout(null);
		setSize(MENUXSIZE, MENUYSIZE);
		this.setBackground(Color.BLUE);

		timerPanel = new JPanel();

		timeLabel = new JLabel(timer(time));
		timeLabel.setFont(new Font("���׷�ü", Font.BOLD, 20));
		timeLabel.setLocation(1000, 40);

		timerPanel.setSize(180, 50);
		timerPanel.setOpaque(false);

		timerPanel.add(timeLabel);

		new timerThread().start();

		timerPanel.setLocation(1000, 15);
//		setLocation(20, 20);

		setOpaque(false);
		add(timerPanel);

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
