import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Server {
	private final int CHAR_PORT = 9100;
	private final int GAME_PORT = 9200;

	private ServerSocket ChatServer = null;;
	private ServerSocket GameServer = null;;

	Socket ChatSocket;
	Socket GameSocket;

	String SERVER_IP = null;
	
	public static ArrayList<DataOutputStream> outList = new ArrayList<DataOutputStream>();
	public static ArrayList<DataOutputStream> playList = new ArrayList<DataOutputStream>();

	public Server() {
		System.out.println("서버 시작...");
		SERVER_IP = getHostAdd();
		System.out.println(SERVER_IP);
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

				System.out.println(ChatSocket.getPort() + ", " + GameSocket.getPort() + " 연결 성공");
				System.out.println("접속자 수  : " + outList.size() + "\n");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		new Server();
	}
	
	public String getHostAdd() {
		try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			return null;
		}
	}
}