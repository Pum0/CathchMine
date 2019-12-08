import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread implements Runnable {

	ServerSocket serverSocket;
	Socket client;

	public ServerThread(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}

	public void run() {
		while (true) {
			try {
			client = serverSocket.accept();
			System.out.println("connected client : " + client);
			System.out.println(client.getPort());
			} catch(Exception e) {
				
			}
		}
	}
}
