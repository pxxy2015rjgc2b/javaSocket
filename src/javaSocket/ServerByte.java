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
		// InputStream.read(b)�����ڻ���������ʱһֱ����
		// readLine()����δ�������з�ʱһֱ����
		// inputStreamû�����ݻ�һֱ�ȴ�����������Ԥ��С���ȶ�Ȼ�󷵻ز���һֱ�ȴ�
		while ((len = in.read(b)) != -1) {
			System.out.println(System.currentTimeMillis());
			System.out.println(new String(b).trim().toString());
		}
		System.out.println("����");
	}
}
