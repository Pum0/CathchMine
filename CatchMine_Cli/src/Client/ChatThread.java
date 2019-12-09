package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import Main.Main;

public class ChatThread implements Runnable {

	Socket chat = null;

	DataInputStream in = null;
	DataOutputStream out = null;

	String NickName = null;

	public ChatThread() {
		// TODO Auto-generated constructor stub
	}

	public ChatThread(Socket chat) {
		this.chat = chat;

		try {
			in = new DataInputStream(chat.getInputStream());
			out = new DataOutputStream(chat.getOutputStream());

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void run() {
		try {
			while (true) {
				String str;
				str = in.readUTF();
				System.out.println(str);
				Main.multiMenu.chatArea.append(str);
			}
		} catch (IOException e) {
			System.out.println("Client run ø¿∑˘ : " + e.getMessage());
		}
	}

	public void sendMessage(String str) {
		try {
			out.writeUTF(Client.NickName + " : " + str + "\n");
			out.flush();
		} catch (IOException e) {
		}
	}

	public void enterChat() {
		try {
			out.writeUTF("\"" + Client.NickName + "\" ¥‘¿Ã ¿‘¿Â«œºÃΩ¿¥œ¥Ÿ.\n");
			out.flush();
		} catch (IOException e) {
		}
	}

	public void exitChat() {
		try {
			out.writeUTF("\"" + Client.NickName + "\" ¥‘¿Ã ≈¿Â«œºÃΩ¿¥œ¥Ÿ.\n");
			out.flush();
		} catch (IOException e) {
		}
	}
}
