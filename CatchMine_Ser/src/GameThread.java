import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.sound.sampled.ReverbType;

public class GameThread implements Runnable {

	Socket game = null;

	DataInputStream in = null;
	DataOutputStream out = null;
	
	public GameThread(Socket game) {
		this.game = game;
		try {
			in = new DataInputStream(game.getInputStream());
			out = new DataOutputStream(game.getOutputStream());
			Server.playList.add(out);
		} catch (IOException e) {
			System.out.println("Game Thread : " + e.getMessage());
		}
	}

	@Override
	public void run() {
		try {
			while (true) {
				int key = in.readInt();
				
				receiveKeyCode(key);
			}
		} catch (Exception ee) {
		}
	}
	
	public void receiveKeyCode(int key) {
		try {
			out.writeInt(key);
			out.flush();
		} catch (IOException e) {
		}
	}
}
