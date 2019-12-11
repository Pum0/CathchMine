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
	private boolean stop = false;

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
			while (!stop) {
				String str;
				str = in.readUTF();
				Main.multiMenu.chatArea.append(str);
				Main.multiMenu.chatArea.setCaretPosition(Main.multiMenu.chatArea.getDocument().getLength());
			}
		} catch (IOException e) {
			System.out.println("Chat run ø¿∑˘ : " + e.getMessage());
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

	public void stop(boolean stop) {
		this.stop = stop;
	}
}
