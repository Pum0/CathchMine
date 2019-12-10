import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class GameThread implements Runnable {

	Socket game = null;

	DataInputStream in = null;
	DataOutputStream out = null;
	
	public GameThread(Socket game) {
		this.game = game;
		try {
			in = new DataInputStream(game.getInputStream());
			out = new DataOutputStream(game.getOutputStream());
		} catch (IOException e) {
		}
	}

	@Override
	public void run() {
		try {
			while (true) {
				System.out.println(in.readUTF());
			}
		} catch (Exception ee) {
			Thread.interrupted();
		}
	}
}
