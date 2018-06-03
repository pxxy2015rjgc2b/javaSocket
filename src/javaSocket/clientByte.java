package javaSocket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class clientByte {
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		Socket socket = new Socket("localhost", 9999);
		OutputStream out = socket.getOutputStream();
		String data = "ÀÔ“„ «Àß∏Á";
		byte[] b = data.getBytes();
		Thread.sleep(5000);
		out.write(b);
		while (true) {

		}
	}
}
