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
		System.out.println("�Ѿ�����");
		BufferedReader bfr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String data;
		// ��δ�յ����з��������ر�ʱbfr.readLine��һֱ�����ȴ����з�����������ִ��
		while ((data = bfr.readLine()) != null) {

			System.out.println(data);
		}
	}
}
