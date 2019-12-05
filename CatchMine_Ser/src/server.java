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
		System.out.println("Thread�� �̿��� ���� ���� ���� �۵���");
		System.out.println("-------------------------------------");
		ServerSocket server = null;
		int connectCount = 0;
		
		try {
			server = new ServerSocket(2010);
			while(true) {
				// Ŭ���̾�Ʈ�� ������ ���⸦ ��ٸ��ϴ�.
				Socket connectedClientSocket = server.accept();
				InetAddress ia = connectedClientSocket.getInetAddress();
				int port = connectedClientSocket.getLocalPort(); // ���ӿ� ���� ������ PORT
				String ip = ia.getHostAddress(); // ���ӵ� ���� Client IP
				
				++connectCount; // ������ �� ī��Ʈ
				System.out.print(connectCount);
				System.out.print(" ����-Local Port : " + port);
				System.out.println(" Client IP : " + ip);
				
				// ---------------------------------
				// ������ ���� �κ�
				// ---------------------------------
				// ---------------------------------
				// Handler Ŭ������ client ���� ����
				ThreadServerHandler handler = new ThreadServerHandler(connectedClientSocket);
				// ������ ����, run() ȣ��
				handler.start(); // start() --> run() ȣ��
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

// Ŭ���̾�Ʈ�� �����͸� ������ ������ Ŭ����
class ThreadServerHandler extends Thread {
	
	// �������
	private Socket connectedClientSocket;
	
	// ������
	public ThreadServerHandler(Socket connectedClientSocket) {
		// Client�� ��� �� ��ü�� �ʱⰪ���� �޾� �Ҵ��մϴ�.
		this.connectedClientSocket = connectedClientSocket;
	}
	
	// start() �޼ҵ� ȣ�� �� ����˴ϴ�.
	public void run() {
		try {
			// Ŭ���̾�Ʈ�� ������ ��� �� ��ü ����
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connectedClientSocket.getOutputStream()));
			
			// ���ۿ� ���ڿ��� �����
			writer.write("������ �������� ���� ����");
			writer.newLine(); // �� ����
			writer.flush();
			
		} catch(IOException ignored) {
			
		} finally {
			try {
				connectedClientSocket.close(); // Ŭ���̾�Ʈ ���� ����
			} catch(IOException ignored) {}
		}
	}
}