package Server;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// 1. ������ �� �� �д� (��� accept �޴� ��)
// 2. ���ù��� �ڱ� ȥ�ڼ� ��Ʈ��ũ ó��, ��� ���
// 3. ������ Ŭ���̾�Ʈ�� ���� ������ �ִ� ��

public class ChatingServer {
	public ServerSocket serverSocket;
	public Socket socket;
	public String msg;
	public String NickName;

	// ����ڵ��� ������ �����ϴ� ��
	public Map<String, DataOutputStream> clientsMap = new HashMap<String, DataOutputStream>();

//	public void setGui(ServerGUI gui) {
//		this.gui = gui;
//	}
	
//	public void setNickName(String nickName) {
//		this.NickName = nickName;
//	}
//	
//	public String getNick() {
//		return this.NickName;
//	}

	public void setting() {
		// accept �κе� while���� ���� ����ؼ� ����ڸ� ���� �� �ְ� ����� �ش�.
		// ������ �� ���� �湮�ڸ� ��� �޾Ƽ�, ���ù��� ��� �����ؾ��Ѵ�.
		try {
			// ���α׷� ���� ���� ��Ʈ��ũ ���Ѽ� synchronizedMap�� �����������ش�.
			Collections.synchronizedMap(clientsMap);
			serverSocket = new ServerSocket(7778);
			while (true) {
				System.out.println("ä�� ���� �����..");

				socket = serverSocket.accept();
				System.out.println(socket.getInetAddress() + "���� �����Ͽ����ϴ�.");

				// ���⿡ ���ο� ����� Thread Ŭ������ �����ؼ� ���� ������ �־���� �Ѵ�.
				Receiver receiver = new Receiver(socket);
				receiver.start();
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Server setting ���� : " + e.getStackTrace());
		}
	}

	// ���� ���� (Ŭ���̾�Ʈ ���� ���� �� ����)
	public void addClient(String nick, DataOutputStream out) {
		sendMessage(nick + "���� �����ϼ̽��ϴ�.\n");
		System.out.println(nick + "���� �����ϼ̽��ϴ�.");
		clientsMap.put(nick, out);
	}

	public void removeClient(String nick) {
		sendMessage(nick + "���� �����ϼ̽��ϴ�.\n");
		System.out.println(nick + "���� �����ϼ̽��ϴ�.");
		clientsMap.remove(nick);
	}

	// �޽��� ���� ����
	public void sendMessage(String msg) {
		// it == nickname
		Iterator<String> it = clientsMap.keySet().iterator();
		String key;

		while (it.hasNext()) {
			try {
				key = it.next();
				clientsMap.get(key).writeUTF(msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// ���ù��� �� ���� ��Ʈ��ũ ������ �޾Ƽ� ��� ���, ��û�ϴ� ��
	class Receiver extends Thread {
		private DataInputStream in;
		private DataOutputStream out;

		public Receiver(Socket socket) {
			try {
				out = new DataOutputStream(socket.getOutputStream());
				in = new DataInputStream(socket.getInputStream());
				
				// Ŭ���̾�Ʈ ���̵� �޾ƿ���
//				nick = in.readUTF();
				
				NickName = in.readUTF();
				addClient(NickName, out);

			} catch (IOException e) {
				System.out.print("Receiver Error : " + e.getStackTrace());
			}
		}

		@Override
		public void run() {
			try {
				// ��� ��⸸!!
				while (in != null) {
					msg = in.readUTF();
					sendMessage(msg);
//					gui.appendMsg(msg);
					System.out.println(NickName + " : " + msg);
				}
			} catch (IOException e) {
				// ���� ���� �� ���⼭ ���� �߻���. �׷��� ���⼭ �ؽ� ���� �����.
				removeClient(NickName);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChatingServer chat = new ChatingServer();
		chat.setting();
	}
}
