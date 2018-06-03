package javaSocket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

//将读和写分为两个线程可以使读不终止一直接受数据，使写也不终止，一直写入数据

public class serverSocket {
	public static void main(String[] args) throws IOException, InterruptedException {
		ServerSocket server = new ServerSocket(7000);
		while (true) {
			System.out.println("等待链接");
			Socket socket = server.accept();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			String data;
			// 若客户端不断开输出流则br.readLine()一直不会==null会一直在循环，当关闭了br.readLine()才会跳出循环往下执行
			while ((data = br.readLine()) != null) {
				System.out.println(data);
			}
			socket.shutdownInput();

			bw.write("你是不是傻瓜，亲爱的");
			bw.flush();
			bw.write("我不是");
			bw.flush();
			br.close();
		}
	}
}
