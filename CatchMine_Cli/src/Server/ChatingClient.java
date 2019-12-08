package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import Main.Main;

public class ChatingClient {
	private Socket socket;

	private DataInputStream in;
	private DataOutputStream out;

//	private Menu_Multi Menu_Multi;

	private String msg;
	public String NickName;

//	public void setGui(Menu_Multi Menu_Multi) {
//		this.Menu_Multi = Menu_Multi;
//	}

	public void connect() {
		try {
			socket = new Socket("localhost", 7778);
			System.out.println("서버 연결 됨");

			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());

			// 접속하자마자 닉네임 전송, 서버가 이걸 닉넴으로 인식하고 맵에 넣음
			out.writeUTF(NickName);
			System.out.println("클라이언트 : 닉네임 전송 완료");
			
			while (in != null) {
				msg = in.readUTF();
				Main.multiMenu.appendMsg(msg);
			}

		} catch (Exception e) {
			System.out.println("ChatingClient Connect Error : " + e.getStackTrace());
		}
	}

//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		try {
//			while (in != null) {
//				msg = in.readUTF();
//				Main.multiMenu.appendMsg(msg);
//			}
//		} catch (IOException e) {
//			System.out.println("Connect run Error" + e.getStackTrace());
//			// 접속 종료 시 여기서 에러 발생함. 그래서 여기서 해쉬 내용 지운다.
////				removeClient(NickName);
//		}
//	}

	public void sendMessage(String msg) {
		try {
			out.writeUTF(msg);
		} catch (IOException e) {
			System.out.printf("Client Message send Error : " + e.getStackTrace());
		}
	}

	public void setNickName(String nick) {
		this.NickName = nick;
	}

	public String getNickName() {
		return this.NickName;
	}

//	public static void main(String[] args) {
//		ChatingClient client = new ChatingClient();
//		client.connect();
//	}
}
