package Main;

import javax.swing.JFrame;

import Scenes.Create_Room;
import Scenes.MainLogin;
import Scenes.Menu_Main;
import Scenes.Menu_Multi;
import Scenes.Menu_Option;
import Scenes.Menu_Rule;
import Scenes.Menu_Single;
import Scenes.Multi_Room;
import Scenes.PlayMusic;
import Scenes.SignUp;
import thread.net.Client;

public class Main extends JFrame {
	public static MainLogin mainLogin = new MainLogin();
	public static Menu_Main mainMenu = new Menu_Main();
	public static Menu_Single singleMenu = new Menu_Single();
	public static Menu_Multi multiMenu = new Menu_Multi();
	public static Menu_Rule ruleMenu = new Menu_Rule();
	public static Menu_Option optionMenu = new Menu_Option();
	public static SignUp signUp = new SignUp();
	public static Create_Room createRoom = new Create_Room();
	public static Multi_Room multiRoom = new Multi_Room();

	public static PlayMusic backgroundMusic = new PlayMusic("backgroundMusic1.mp3", true);
	public static String NickName = null;

	Client cli = new Client();

	public Main() {
		super("Catch-Mine");
		setSize(400, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);

		// 로그인창 추가 부분
		add(mainLogin);

		// 메인 배경음악 재생
		backgroundMusic.start();

		add(mainMenu);
		mainMenu.setVisible(false);
		add(singleMenu);
		singleMenu.setVisible(false);
		add(multiMenu);
		multiMenu.setVisible(false);
		add(ruleMenu);
		ruleMenu.setVisible(false);
		add(optionMenu);
		optionMenu.setVisible(false);
		add(multiRoom);
		multiRoom.setVisible(false);

		setVisible(true);
	}

	public static void main(String[] args) {
		new Main();
	}

}
