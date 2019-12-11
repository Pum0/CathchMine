package Client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
	Socket chatSocket;
	Socket gameSocket;

	private ServerSocket ChatServer = null;;
	private ServerSocket GameServer = null;;
	
	public ChatThread chat;
	public GameThread game; 
	
	public static String NickName = null;

	public Client(String SERVER_IP) {
		try {
			chatSocket = new Socket(SERVER_IP, 9100);
			gameSocket = new Socket(SERVER_IP, 9200);

			System.out.println("소켓 연결 성공");

			chat = new ChatThread(chatSocket);
			game = new GameThread(gameSocket);

//			new Thread(chat).start();
//			new Thread(game).start();

		} catch (Exception e) {
			System.out.println("소켓 연결 실패");
		}
	}
	
	public void close() {
		try {
			chatSocket.close();
			gameSocket.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}