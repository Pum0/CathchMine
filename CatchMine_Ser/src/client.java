import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class client {
	public void init(String ip, int port) {
		System.out.println("Ŭ���̾�Ʈ ���α׷� �۵�.....");
		Socket socket = null;
		String line; // �����κ��� �о�� ���ڿ� ����
		int cnt=0;
		
		try {
			String serverIP = ip; // IP
			int serverPort = port; // PORT
			
			// ������ ������ ip�� �Է¹޾� ���� ����
			socket = new Socket(serverIP, serverPort);
			InetAddress ia = socket.getInetAddress();
			int _port = socket.getLocalPort(); // ���ӿ� ���� ������ PORT
			String _ip = ia.getHostAddress(); // ���ӵ� ���� Client IP
			
			System.out.print("Ŭ���̾�Ʈ ����-Local Port : " + _port);
			System.out.println(" Server IP : " + _ip);
			
			// �����κ��� �����͸� �Է¹޾� ���ۿ� �����մϴ�.
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			// ���۷κ��� �� ���ξ� �о� ����մϴ�.
			// �Է� ���μ��� �� �� �����Ƿ� ���ѷ�ƾ
			while(true) {
				try {
					// cnt++;
//					System.out.println("��ȯ���Դϴ�. : " + cnt);
					
					// �����κ��� ��µǴ� ������ �о���� ���� ��ȯ�ϸ鼭 ��ٸ��ϴ�.
					line = reader.readLine();
					
					// �����ʿ��� Socket�� ������ null���� ���۵����� ��ȯ���� ����ϴ�.
					if(line == null) {
						break;
					}
					
					// �ұ�Ģ������ �ԷµǴ� �����͸� �Է� ������ ����
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
				System.out.println("�������� ������ �����մϴ�.");
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
