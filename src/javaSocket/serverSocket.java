package javaSocket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

//������д��Ϊ�����߳̿���ʹ������ֹһֱ�������ݣ�ʹдҲ����ֹ��һֱд������

public class serverSocket {
	public static void main(String[] args) throws IOException, InterruptedException {
		ServerSocket server = new ServerSocket(7000);
		while (true) {
			System.out.println("�ȴ�����");
			Socket socket = server.accept();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			String data;
			// ���ͻ��˲��Ͽ��������br.readLine()һֱ����==null��һֱ��ѭ�������ر���br.readLine()�Ż�����ѭ������ִ��
			while ((data = br.readLine()) != null) {
				System.out.println(data);
			}
			socket.shutdownInput();

			bw.write("���ǲ���ɵ�ϣ��װ���");
			bw.flush();
			bw.write("�Ҳ���");
			bw.flush();
			br.close();
		}
	}
}
