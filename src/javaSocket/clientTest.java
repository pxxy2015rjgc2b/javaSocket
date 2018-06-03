package javaSocket;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class clientTest {
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		Socket socket = new Socket("localhost", 8888);
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		String data = "ÀÔ“„ «Àß∏Á\r\n";
		Thread.sleep(2000);
		pw.write(data);
		pw.flush();
		Thread.sleep(1000);
		String data2 = "ÀÔ“„ «Àß∏Á";
		pw.write(data2);
		pw.flush();
		socket.shutdownOutput();
	}
}
