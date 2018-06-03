package ThreadSocket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ThreadClientOut implements Runnable {

	private Socket socket;

	public ThreadClientOut(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Scanner scanner;
		BufferedWriter bfw;
		try {
			String data = "data";
			bfw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bfw.write(data);
			bfw.flush();
			socket.shutdownOutput();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
