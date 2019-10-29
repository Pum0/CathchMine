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

	public Menu_Option() {
		setSize(400, 600);
		setLayout(null);

		selectMusic = new JLabel("���� ����"); // ���Ǽ��� ���̺�
		add(selectMusic);
		selectMusic.setBounds(50, 100, 100, 20); // setBounds() ũ�� ��ġ ����

		music = new JComboBox<String>(musics); // ����� ���� �޺��ڽ�
		music.setSelectedIndex(0); // �� ó�� ���õȰ� 0�� �ε���
		// music.addActionListener(this);
		add(music);
		music.setBounds(130, 100, 200, 20);

		musicVolume = new JSlider(0, 100); // �����̴�
		musicVolume.setMajorTickSpacing(50); // ū ���� ����
		// musicVolume.setMinorTickSpacing(1); // ���� ���� ����
		musicVolume.setPaintTicks(true); // ���� ǥ��
		musicVolume.setPaintLabels(true); // ���� ���̺�� ǥ��
		add(musicVolume);
		musicVolume.setBounds(45, 120, 300, 50);

		volumeValue = new JLabel("50"); // ������ ǥ��
		volumeValue.setBounds(350, 80, 100, 100);
		add(volumeValue);
		
		box = new JPanel() {	//�гο��ٰ� ����Ʈ �߰��ؼ� �簢�� ����
			@Override
			public void paint(Graphics g) {
				g.drawRoundRect(0, 0, 30, 15, 5, 5);
			}
		};
		box.setBounds(348, 121, 100, 100);
		add(box);
		
		musicVolume.addChangeListener(new ChangeListener() {	//�����̴� ���� �޾ƿͼ� musicVolume ���̺� �ؽ�Ʈ ��
			@Override
			public void stateChanged(ChangeEvent e) {
				volumeValue.setText(" " + musicVolume.getValue());

			}
		});

	}

}
