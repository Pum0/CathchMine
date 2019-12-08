package thread.net;
//package thread.net;
//
//import java.io.IOException;
//import java.net.Socket;
//
//import Main.Main;
//
//public class Client {
//	private final static String SERVER = "127.0.0.1";
//	private final static int PORT = 9000;
// 
//	ChatThread chat;
//	public Client() {
//		try {
//			Socket socket = new Socket(SERVER, PORT);
//			System.out.println("立加 己傍");
//			
//			chat = new ChatThread(socket);
//			new Thread(chat).start();
//			
//		} catch (IOException e) {
//			System.out.println("立加 角菩");
//		}
//	}
//	
//}