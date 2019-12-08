package Game;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game_MenuPanel extends JPanel {
	// �޴��� �־�� �� ��� ���� ������, ��밡���� ��� ����, ��Ƽ�� ���� ���
	// �� Ŭ���������� ����ǰ� �ִ� ���ӿ��� ���� �޾ƿ� �ܼ��� ���൵(������ ����, ����� ����)�� ĳ������ ����(ü��, ������)�� �˷��ش�.
	final static int MENUXSIZE = 1400;
	final static int MENUYSIZE = 100;

	private ImageIcon statusImage = new ImageIcon("image/status.png");
	private JLabel statIcon;

	// ���� ���� �޴� UI �г�
	private JPanel menuPanel; // �޴� ��ü�� ������Ʈ�� ���� �г�
	private JLabel timeLabel; // �ð��� ��µǴ� ���̺�
	private JLabel mineLabel; // �� ���ӿ� �ִ� ������ ������ ����س��� ���̺�
	private JLabel itemPocketLabel; // ���� �������� �޴�â�� ǥ������ �̹����� �׸� ���̺�
	private JLabel flagLabel;

	// ���� �÷��� �ð�
	final static int time = 0;

	singleGame sG = new singleGame(); // �̱۰��� Ŭ������ �ʵ带 ����ϱ����ؼ� ���

	public Game_MenuPanel() {
		setLayout(null);
		setSize(MENUXSIZE, MENUYSIZE);
		this.setBackground(Color.BLUE);
		statIcon = new JLabel();
		statIcon.setIcon(statusImage);

		menuPanel = new JPanel(); // �޴� �г� ����
		menuPanel.setLayout(null); // ������ǥ�� ���� ���� ���̾ƿ��� null�� ������
		menuPanel.setBounds(0, 0, MENUXSIZE, MENUYSIZE);
		menuPanel.setOpaque(false);

		timeLabel = new JLabel(timer(time)); // ��:�� �������� Label�� �ؽ�Ʈ�� ����
		menuPanel.add(timeLabel); // �޴� �гο� �߰�

		timeLabel.setFont(new Font("���׷�ü", Font.BOLD, 50));
		timeLabel.setBounds(850, 5, 200, 100);

		mineLabel = new JLabel(sG.getMineCount() + "");
		menuPanel.add(mineLabel);

		mineLabel.setFont(new Font("���׷�ü", Font.BOLD, 40));
		mineLabel.setBounds(560, 2, 200, 100);

		flagLabel = new JLabel();
		flagLabel.setFont(new Font("���׷�ü", Font.BOLD, 40));
		flagLabel.setBounds(343, 2, 200, 100);

		menuPanel.add(flagLabel);

		new Thread() {
			@Override
			public void run() {
				while (true) {
					flagLabel.setText(sG.getFlagCount() + "");
				}
			}

		}.start();

		new timerThread().start(); // ������ ���ÿ� Ÿ�̸Ӹ� �����Ų��.

		menuPanel.setLocation(0, 0);

		setOpaque(false);
		add(menuPanel);
		add(statIcon);
		statIcon.setBounds(0, 0, MENUXSIZE, MENUYSIZE);

	}

	public Game_MenuPanel(int i) {

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
				timeLabel.setText(timer(count));

			}
		}
	}

}
