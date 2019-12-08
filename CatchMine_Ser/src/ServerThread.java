import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.sound.midi.Receiver;

public class ServerThread implements Runnable {

	ServerSocket serverSocket;
	Socket client;

	InputStream is = null;
    InputStreamReader isr = null;
    BufferedReader br = null;


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
	
	public Socket getsocket() {
		return client;
	}
}
