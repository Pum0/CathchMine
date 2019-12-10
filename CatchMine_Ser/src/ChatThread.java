import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ChatThread implements Runnable {

	Socket chat = null;

	DataInputStream in = null;
	DataOutputStream out = null;

	public ChatThread(Socket chat) {
		this.chat = chat;
		try {
			in = new DataInputStream(chat.getInputStream());
			out = new DataOutputStream(chat.getOutputStream());
			Server.outList.add(out);

		} catch (IOException e) {
			System.out.println("chat thread " + e.getMessage());
		}
	}

	@Override
	public void run() {
		try {
			while (true) {
				sendAll(in.readUTF());
			}
		} catch (IOException e) {
			Server.outList.remove(out);
			Thread.interrupted();
		}
	}

	public void sendAll(String str) throws IOException {
		for (DataOutputStream out : Server.outList) {
			out.writeUTF(str);
			out.flush();
		}
	}
}
