import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
	Socket socket;
	
	public static void main(String[] args) {
		System.out.println("-------------------------------------");
		System.out.println("Thread를 이용한 다중 접속 서버 작동됨");
		System.out.println("-------------------------------------");
		ServerSocket server = null;
		int connectCount = 0;
		
		try {
			server = new ServerSocket(2010);
			while(true) {
				// 클라이언트가 접속해 오기를 기다립니다.
				Socket connectedClientSocket = server.accept();
				InetAddress ia = connectedClientSocket.getInetAddress();
				int port = connectedClientSocket.getLocalPort(); // 접속에 사용된 서버측 PORT
				String ip = ia.getHostAddress(); // 접속된 원격 Client IP
				
				++connectCount; // 접속자 수 카운트
				System.out.print(connectCount);
				System.out.print(" 접속-Local Port : " + port);
				System.out.println(" Client IP : " + ip);
				
				// ---------------------------------
				// 스레드 관련 부분
				// ---------------------------------
				// ---------------------------------
				// Handler 클래스로 client 소켓 전송
				ThreadServerHandler handler = new ThreadServerHandler(connectedClientSocket);
				// 스레드 시작, run() 호출
				handler.start(); // start() --> run() 호출
			}
			} catch(IOException ioe) {
				System.out.println("Exception generated...");
		} finally {
			try {
				server.close();
			} catch(IOException ignored) {}
		}
	}
}

// 클라이언트로 데이터를 전송할 스레드 클래스
class ThreadServerHandler extends Thread {
	
	// 멤버변수
	private Socket connectedClientSocket;
	
	// 생성자
	public ThreadServerHandler(Socket connectedClientSocket) {
		// Client와 통신 할 객체를 초기값으로 받아 할당합니다.
		this.connectedClientSocket = connectedClientSocket;
	}
	
	// start() 메소드 호출 시 실행됩니다.
	public void run() {
		try {
			// 클라이언트로 내용을 출력 할 객체 생성
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connectedClientSocket.getOutputStream()));
			
			// 버퍼에 문자열을 기록함
			writer.write("스레드 다중접속 서버 접속");
			writer.newLine(); // 줄 변경
			writer.flush();
			
		} catch(IOException ignored) {
			
		} finally {
			try {
				connectedClientSocket.close(); // 클라이언트 접속 종료
			} catch(IOException ignored) {}
		}
	}
}