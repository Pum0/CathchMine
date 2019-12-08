//package thread.net;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.io.PrintWriter;
//import java.net.Socket;
//import java.nio.charset.StandardCharsets;
//
//public class ChatThread implements Runnable {
//
//	Socket socket;
//
//	String str = null;
//
//	public ChatThread(Socket socket) {
//		this.socket = socket;
//	}
//
//	@Override
//	public void run() {
//		try {
//			BufferedReader br = new BufferedReader(
//					new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
//			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
//
//			while (true) {
//				reader(br);
//			}
//		} catch (Exception e) {
//
//		}
//	}
//
//	public void reader(BufferedReader br) throws IOException {
//		str = null;
//		str = br.readLine();
//		System.out.println(str);
//	}
//
//	public void writer(PrintWriter pw) throws IOException {
//		pw.write(str);
//		
//	}
//}
