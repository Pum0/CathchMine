package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class GameThread implements Runnable {

	Socket game = null;

	DataInputStream in = null;
	DataOutputStream out = null;

	int key;
	
	private boolean stop = false;
	
	public GameThread() {

	}

	public GameThread(Socket game) {
		this.game = game;

		try {
			in = new DataInputStream(game.getInputStream());
			out = new DataOutputStream(game.getOutputStream());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void run() {
		try {
			while (!stop) {
			key	= in.readInt();
				
				
			}
		} catch (Exception e) {
			System.out.println("Game run ¿À·ù : " + e.getMessage());
		}
	}

	public void sendKeyCode(int key) {
		try {
			out.writeInt(key);
			out.flush();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int getKeyCode() {
		return key;
	}

	public void stop(boolean stop) {
		this.stop = stop;
	}
}
