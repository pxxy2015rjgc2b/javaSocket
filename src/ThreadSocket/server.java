package ThreadSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(9999);
		Socket socket = null;
		System.out.println("µÈ´ýÁ¬½Ó");
		socket = serverSocket.accept();
		socket.setKeepAlive(true);
		ThreadServerOut outRunnable = new ThreadServerOut(socket);
		Thread threadOut = new Thread(outRunnable);
		threadOut.start();
		ThreadServerIn inRunnable = new ThreadServerIn(socket);
		Thread threadIn = new Thread(inRunnable);
		threadIn.start();
	}
}
