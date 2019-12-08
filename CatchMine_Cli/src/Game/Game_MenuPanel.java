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

	private static ImageIcon p_hp0 = new ImageIcon("image/GameObject/Heart 0.png");
	private static ImageIcon p_hp1 = new ImageIcon("image/GameObject/Heart 1.png");
	private static ImageIcon p_hp2 = new ImageIcon("image/GameObject/Heart 2.png");
	private static ImageIcon p_hp3 = new ImageIcon("image/GameObject/Heart 3.png");
	private static ImageIcon[] hpImageList = { p_hp0, p_hp1, p_hp2, p_hp3 };

	// ���� ���� �޴� UI �г�
	private JPanel menuPanel; // �޴� ��ü�� ������Ʈ�� ���� �г�
	private JLabel timeLabel; // �ð��� ��µǴ� ���̺�
	private JLabel mineLabel; // �� ���ӿ� �ִ� ������ ������ ����س��� ���̺�
	private JLabel itemPocketLabel; // ���� �������� �޴�â�� ǥ������ �̹����� �׸� ���̺�
	private static JLabel flagLabel;
	private static JLabel hpLabel; // player�� Hp�� ǥ�����ִ� �̹���

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

		flagLabel = new JLabel(sG.getFlagCount() + "");
		flagLabel.setFont(new Font("���׷�ü", Font.BOLD, 40));
		flagLabel.setBounds(353, 2, 200, 100);

		menuPanel.add(flagLabel);

		hpLabel = new JLabel();
		hpLabel.setIcon(p_hp3);
		hpLabel.setBounds(30, 26, 174, 60);

		menuPanel.add(hpLabel);

		new timerThread().start(); // ������ ���ÿ� Ÿ�̸Ӹ� �����Ų��.

		menuPanel.setLocation(0, 0);

		setOpaque(false);
		add(menuPanel);
		add(statIcon);
		statIcon.setBounds(0, 0, MENUXSIZE, MENUYSIZE);

	}

	public static void sethpImage(int i) {
		hpLabel.setIcon(hpImageList[i]);
	}

	public static void setFlagCount(int i) {
		flagLabel.setText(i + "");
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
