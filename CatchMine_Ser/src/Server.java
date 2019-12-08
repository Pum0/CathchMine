import java.net.ServerSocket;

public class Server {
	public static final int PORT = 9000;

	public static void main(String[] args) {
		System.out.println("서버 시작...");
		while (true) {
			try {
				ServerSocket serverSocket = new ServerSocket(9000);
				ServerThread serverThread = new ServerThread(serverSocket);

				new Thread(serverThread).start();
				
			} catch (Exception e) {

			}
		}
	}
	
	

}