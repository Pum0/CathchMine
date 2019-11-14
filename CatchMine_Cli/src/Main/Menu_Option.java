package Main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Menu_Option extends JPanel /* implements ActionListener */ {
	JComboBox<String> music;
	JLabel selectMusic, volumeValue;
	JSlider musicVolume; // �����̴�
	JPanel box;

	private String musics[] = { "����� 1", "����� 2", "����� 3", "����� 4" };

	Design de = new Design();

	public Menu_Option() {
		setSize(400, 600);
		setLayout(null);

		selectMusic = new JLabel("���� ����"); // ���Ǽ��� ���̺�
		selectMusic.setForeground(Color.WHITE); // ��Ʈ�� ȭ��Ʈ
		selectMusic.setFont(de.font);
		add(selectMusic); // �߰�
		selectMusic.setBounds(50, 100, 100, 20); // setBounds() ũ�� ��ġ ����

		music = new JComboBox<String>(musics); // ����� ���� �޺��ڽ�
		music.setSelectedIndex(0); // �� ó�� ���õȰ� 0�� �ε���
//		music.setBackground(Color.LIGHT_GRAY);
		add(music);
		music.setBounds(130, 100, 200, 20);

		musicVolume = new JSlider(0, 100); // �����̴�
		musicVolume.setMajorTickSpacing(50); // ū ���� ����
		musicVolume.setPaintTicks(true); // ���� ǥ��
		musicVolume.setPaintLabels(true); // ���� ���̺�� ǥ��
		musicVolume.setForeground(Color.white);
		musicVolume.setOpaque(false);
		musicVolume.setFont(de.font);
		add(musicVolume);
		musicVolume.setBounds(45, 140, 300, 50);

		volumeValue = new JLabel("50"); // ������ ǥ��
		volumeValue.setForeground(Color.white);
		volumeValue.setBounds(350, 100, 100, 100);
		volumeValue.setFont(de.font);
		add(volumeValue);

		box = new JPanel() { // �гο��ٰ� ����Ʈ �߰��ؼ� �簢�� ����
			@Override
			public void paint(Graphics g) {
				g.drawRoundRect(0, 20, 30, 15, 5, 5);
			}
		};
		box.setBounds(348, 121, 100, 100);
		box.setForeground(Color.white);
		add(box);

		musicVolume.addChangeListener(new ChangeListener() { // �����̴� ���� �޾ƿͼ� musicVolume ���̺� �ؽ�Ʈ ��
			@Override
			public void stateChanged(ChangeEvent e) {
				volumeValue.setText(" " + musicVolume.getValue());

			}
		});

		add(de.setBackground());
	}

}
