package Scenes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Main.Design;
import MyListener.Action;
import MyListener.Key;
import MyListener.Mouse;

public class Menu_Option extends JPanel /* implements ActionListener */ {
	public JComboBox<String> music;
	JLabel selectMusic, volumeValue;
	JSlider musicVolume; // �����̴�
	JPanel mainPanel;
	JPanel box;
	public JButton backButton;

	private String musics[] = { "����� 1", "����� 2", "����� 3", "����� 4" };

	Action al = new Action();
	Key kl = new Key();
	Mouse ml = new Mouse();
	Design de = new Design();

	public Menu_Option() {
		setSize(400, 600);
		setLayout(null);

		mainPanel = new JPanel();
		mainPanel.setBounds(40, 40, 300, 400);
		mainPanel.setLayout(null);
		mainPanel.setBorder(de.setBorder());
		add(mainPanel);
		
		selectMusic = new JLabel("���� ����"); // ���Ǽ��� ���̺�
		selectMusic.setForeground(Color.BLACK); // ��Ʈ�� ȭ��Ʈ
		selectMusic.setFont(de.setFont(14));
		mainPanel.add(selectMusic); // �߰�
		selectMusic.setBounds(30, 20, 100, 20); // setBounds() ũ�� ��ġ ����

		music = new JComboBox<String>(musics); // ����� ���� �޺��ڽ�
		music.setBorder(new LineBorder(Color.DARK_GRAY, 1));
		music.setSelectedIndex(0); // �� ó�� ���õȰ� 0�� �ε���
		music.setFont(de.setFont(10));
		mainPanel.add(music);
		music.setBounds(110, 20, 150, 20);

		musicVolume = new JSlider(0, 100); // �����̴�
		musicVolume.setMajorTickSpacing(50); // ū ���� ����
		musicVolume.setPaintTicks(true); // ���� ǥ��
		musicVolume.setPaintLabels(true); // ���� ���̺�� ǥ��
		musicVolume.setForeground(Color.BLACK);
		musicVolume.setOpaque(false);
		musicVolume.setFont(de.setFont(14));
		mainPanel.add(musicVolume);
		musicVolume.setBounds(25, 80, 250, 50);

		volumeValue = new JLabel("50"); // ������ ǥ��
		volumeValue.setForeground(Color.BLACK);
		volumeValue.setBounds(135, 10, 100, 100);
		volumeValue.setFont(de.setFont(14));
		mainPanel.add(volumeValue);

		box = new JPanel() { // �гο��ٰ� ����Ʈ �߰��ؼ� �簢�� ����
			@Override
			public void paint(Graphics g) {
				g.drawRoundRect(0, 20, 35, 20, 5, 5);
			}
		};
		box.setBounds(130, 30, 100, 100);
		box.setForeground(Color.BLACK);
		mainPanel.add(box);
		
		backButton = new JButton("�ڷΰ���", new ImageIcon("image/button/100x40.png"));
		backButton.setHorizontalTextPosition(SwingConstants.CENTER);
		backButton.setBounds(140, 460, 100, 40);
		backButton.setBorderPainted(false);
		add(backButton);

		musicVolume.addChangeListener(new ChangeListener() { // �����̴� ���� �޾ƿͼ� musicVolume ���̺� �ؽ�Ʈ ��
			@Override
			public void stateChanged(ChangeEvent e) {
				volumeValue.setText(""+musicVolume.getValue());
			}
		});

		// ���� �ɼ� �г�
				backButton.addActionListener(al);
				backButton.addMouseListener(ml);
				music.addActionListener(al);
		
		add(de.setBackground());
	}

}
