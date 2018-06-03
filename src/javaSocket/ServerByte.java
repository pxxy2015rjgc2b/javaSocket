package javaSocket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerByte {
	public static void main(String[] args) throws IOException, InterruptedException {
		ServerSocket server = new ServerSocket(9999);
		Socket socket = server.accept();
		InputStream in = socket.getInputStream();
		byte[] b = new byte[1024 * 1024 * 80];
		int len;
		long startTime = System.currentTimeMillis();
		System.out.println(startTime);
		// InputStream.read(b)不会在缓冲区不满时一直阻塞
		// readLine()会在未读到换行符时一直阻塞
		// inputStream没有数据会一直等待，数据量比预期小会先读然后返回不会一直等待
		while ((len = in.read(b)) != -1) {
			System.out.println(System.currentTimeMillis());
			System.out.println(new String(b).trim().toString());
		}
		System.out.println("跳出");
	}
}
