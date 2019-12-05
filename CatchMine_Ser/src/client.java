import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class client {
	public void init(String ip, int port) {
		System.out.println("클라이언트 프로그램 작동.....");
		Socket socket = null;
		String line; // 서버로부터 읽어온 문자열 저장
		int cnt=0;
		
		try {
			String serverIP = ip; // IP
			int serverPort = port; // PORT
			
			// 접속할 서버의 ip를 입력받아 접속 실행
			socket = new Socket(serverIP, serverPort);
			InetAddress ia = socket.getInetAddress();
			int _port = socket.getLocalPort(); // 접속에 사용된 서버측 PORT
			String _ip = ia.getHostAddress(); // 접속된 원격 Client IP
			
			System.out.print("클라이언트 접속-Local Port : " + _port);
			System.out.println(" Server IP : " + _ip);
			
			// 서버로부터 데이터를 입력받아 버퍼에 저장합니다.
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			// 버퍼로부터 한 라인씩 읽어 출력합니다.
			// 입력 라인수를 알 수 없으므로 무한루틴
			while(true) {
				try {
					// cnt++;
//					System.out.println("순환중입니다. : " + cnt);
					
					// 서버로부터 출력되는 내용을 읽어오기 위해 순환하면서 기다립니다.
					line = reader.readLine();
					
					// 서버쪽에서 Socket이 닫히면 null값이 전송됨으로 순환문을 벗어납니다.
					if(line == null) {
						break;
					}
					
					// 불규칙적으로 입력되는 데이터를 입력 받을시 지정
					// Thread.sleep(10);
					
					System.out.println(line);
				} catch(Exception e) {
					System.out.println(e.toString());
				}
			}
		} catch(IOException ioe) {
			System.out.println("Exception generated...");
		} finally {
			try {
				socket.close();
				System.out.println("서버와의 접속을 종료합니다.");
			} catch(Exception ignored) {}
		}
	}
	
	public static void main(String[] args) {
//		for(int i = 0; i < 100; i++) {
			client cl = new client();
			cl.init("127.0.0.1", 2010);
//		}
	}
}
