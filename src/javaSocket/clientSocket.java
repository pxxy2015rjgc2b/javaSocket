package javaSocket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class clientSocket {
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		Socket socket = new Socket("localhost", 7000);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		String data = "��������";
		bw.write(data);
		bw.flush();
		bw.write(data);
		bw.flush();
		// socket.shutdownOutput();
		// �Ͽ���������߷��������Ѿ�û�����ݴ��䣬�÷������˵�br.readLine()��ֵΪnull����ѭ������������ִ��
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String data1;
		// ����������Ϊ�Ͽ��������br.readLine�Ͳ�����null
		// ���Խ���������������ֳ������߳�
		while ((data1 = br.readLine()) != null) {
			System.out.println(data1 + "�ͻ���");
		}
		// �ر�������ʹ���ӶϿ�
		// �ر������������ʹsocketҲ�ر�
		br.close();
		bw.close();
	}
}
