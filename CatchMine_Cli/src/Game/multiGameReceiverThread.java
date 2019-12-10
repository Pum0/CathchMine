package Game;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class multiGameReceiverThread implements Runnable {

	Socket socket;
	multiGame multigame;

	public multiGameReceiverThread(Socket socket, multiGame multigame) {

		this.socket = socket;
		this.multigame = multigame;

	}

	@Override
	public void run() {
		try {
			System.out.println("MultiGame Start !!");
			DataInputStream in = new DataInputStream(socket.getInputStream());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			
		}

		catch (Exception e) {
		}

	}

}
