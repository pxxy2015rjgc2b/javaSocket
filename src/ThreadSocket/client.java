package ThreadSocket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 9999);
		ThreadClientOut outRunnable = new ThreadClientOut(socket);
		Thread outThread = new Thread(outRunnable);
		outThread.start();
		ThreadClientIn inRunnable = new ThreadClientIn(socket);
		Thread inThread = new Thread(inRunnable);
		inThread.start();
	}
}
