import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	private final int CHAR_PORT = 9100;
	private final int GAME_PORT = 9200;

	private ServerSocket ChatServer = null;;
	private ServerSocket GameServer = null;;

	Socket ChatSocket;
	Socket GameSocket;

	public static ArrayList<DataOutputStream> people = new ArrayList<DataOutputStream>();
	
	public Server() {
		System.out.println("서버 시작...");
		try {
			ChatServer = new ServerSocket(CHAR_PORT);
			GameServer = new ServerSocket(GAME_PORT);
			while (true) {
				ChatSocket = ChatServer.accept();
				GameSocket = GameServer.accept();
				
				ChatThread Chat = new ChatThread(ChatSocket);
				GameThread Game = new GameThread(GameSocket);

				new Thread(Chat).start();
				new Thread(Game).start();
				
				System.out.println(ChatSocket.getPort()+", " + GameSocket.getPort() + " 연결 성공");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		new Server();
	}
}