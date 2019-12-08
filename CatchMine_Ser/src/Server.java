import java.net.ServerSocket;

public class Server {
	public static final int PORT = 9000;

	
	public static void main(String[] args) {
		System.out.println("서버 시작...");
		while (true) {
			try {
				ServerSocket serverSocket = new ServerSocket(9000);
				ServerThread serverThread = new ServerThread(serverSocket);
				ChatThread chatThread = new ChatThread(serverThread.getsocket());
				
				new Thread(serverThread).start();
				new Thread(chatThread).start();

			} catch (Exception e) {

			}
		}
	}
	
	

}