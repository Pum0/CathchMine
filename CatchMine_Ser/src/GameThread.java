import java.net.Socket;

public class GameThread implements Runnable {

	Socket game = null;

	public GameThread(Socket game) {
		this.game = game;
	}

	@Override
	public void run() {
		try {
			while (true) {

			}
		} catch (Exception ee) {
			Thread.interrupted();
		}
	}
}
