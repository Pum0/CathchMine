package thread.net;

import java.io.IOException;
import java.net.Socket;

import Main.Main;

public class Client {
	private final static String SERVER = "127.0.0.1";
	private final static int PORT = 9000;
 
	public static void main(String[] args) {
		try {
			Socket socket = new Socket(SERVER, PORT);

			System.out.println("접속 성공");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}