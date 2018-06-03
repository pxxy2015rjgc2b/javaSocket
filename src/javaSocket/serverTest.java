package javaSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class serverTest {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8888);
		Socket socket = server.accept();
		System.out.println("已经连接");
		BufferedReader bfr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String data;
		// 在未收到换行符或者流关闭时bfr.readLine会一直阻塞等待换行符出现再往下执行
		while ((data = bfr.readLine()) != null) {

			System.out.println(data);
		}
	}
}
