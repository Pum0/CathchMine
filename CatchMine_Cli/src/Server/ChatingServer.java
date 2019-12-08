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

// 1. 서버가 할 일 분담 (계속 accept 받는 것)
// 2. 리시버가 자기 혼자서 네트워크 처리, 계속 듣기
// 3. 서버가 클라이언트의 맵을 전파해 주는 것

public class ChatingServer {
	public ServerSocket serverSocket;
	public Socket socket;
	public String msg;
	public String NickName;

	// 사용자들의 정보를 저장하는 맵
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
		// accept 부분도 while문을 돌려 계속해서 사용자를 받을 수 있게 만들어 준다.
		// 서버가 할 일은 방문자를 계속 받아서, 리시버를 계속 생성해야한다.
		try {
			// 프로그램 돌다 보면 네트워크 엉켜서 synchronizedMap로 교통정리해준다.
			Collections.synchronizedMap(clientsMap);
			serverSocket = new ServerSocket(7778);
			while (true) {
				System.out.println("채팅 서버 대기중..");

				socket = serverSocket.accept();
				System.out.println(socket.getInetAddress() + "에서 접속하였습니다.");

				// 여기에 새로운 사용자 Thread 클래스를 생성해서 소켓 정보를 넣어줘야 한다.
				Receiver receiver = new Receiver(socket);
				receiver.start();
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Server setting 오류 : " + e.getStackTrace());
		}
	}

	// 맵의 내용 (클라이언트 정보 저장 및 삭제)
	public void addClient(String nick, DataOutputStream out) {
		sendMessage(nick + "님이 접속하셨습니다.\n");
		System.out.println(nick + "님이 접속하셨습니다.");
		clientsMap.put(nick, out);
	}

	public void removeClient(String nick) {
		sendMessage(nick + "님이 종료하셨습니다.\n");
		System.out.println(nick + "님이 접속하셨습니다.");
		clientsMap.remove(nick);
	}

	// 메시지 내용 전파
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

	// 리시버가 할 일은 네트워크 소켓을 받아서 계속 듣고, 요청하는 일
	class Receiver extends Thread {
		private DataInputStream in;
		private DataOutputStream out;

		public Receiver(Socket socket) {
			try {
				out = new DataOutputStream(socket.getOutputStream());
				in = new DataInputStream(socket.getInputStream());
				
				// 클라이언트 아이디 받아오기
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
				// 계속 듣기만!!
				while (in != null) {
					msg = in.readUTF();
					sendMessage(msg);
//					gui.appendMsg(msg);
					System.out.println(NickName + " : " + msg);
				}
			} catch (IOException e) {
				// 접속 종료 시 여기서 에러 발생함. 그래서 여기서 해쉬 내용 지운다.
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
