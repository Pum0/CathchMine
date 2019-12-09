package Client;

import java.net.Socket;

public class GameThread implements Runnable {

	Socket game = null;

	public GameThread() {
	}

	public GameThread(Socket game) {
		this.game = game;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
}
