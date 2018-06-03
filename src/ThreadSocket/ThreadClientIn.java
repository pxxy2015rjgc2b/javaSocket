package ThreadSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ThreadClientIn implements Runnable {

	private Socket socket;

	public ThreadClientIn(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		BufferedReader bfr;
		while (true) {
			try {
				bfr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String data = null;

				while ((data = bfr.readLine()) != null) {
					System.out.println(data);
				}
			} catch (

			IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
