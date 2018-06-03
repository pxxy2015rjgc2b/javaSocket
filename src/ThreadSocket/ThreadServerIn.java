package ThreadSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ThreadServerIn implements Runnable {
	private Socket socket;

	public ThreadServerIn(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				BufferedReader bfr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String data;
				while ((data = bfr.readLine()) != null) {
					System.out.println(data + "½øÀ´ÁË");
				}
			} catch (

			IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
