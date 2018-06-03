package ThreadSocket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ThreadServerOut implements Runnable {

	private Socket socket;

	public ThreadServerOut(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Scanner scanner;
		while (true) {
			try {
				BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				String data = "Œ“ «ÀÔ“„";
				bfw.write(data);
				bfw.flush();
				Thread.sleep(1000);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
