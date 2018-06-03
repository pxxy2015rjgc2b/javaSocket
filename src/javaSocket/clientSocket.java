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
		String data = "我是孙毅";
		bw.write(data);
		bw.flush();
		bw.write(data);
		bw.flush();
		// socket.shutdownOutput();
		// 断开输出流告诉服务器端已经没有数据传输，让服务器端的br.readLine()的值为null跳出循环，可以往下执行
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String data1;
		// 若服务器端为断开输出流则br.readLine就不等于null
		// 所以将输出流和输入流分成两个线程
		while ((data1 = br.readLine()) != null) {
			System.out.println(data1 + "客户端");
		}
		// 关闭两个流使链接断开
		// 关闭输入输出流会使socket也关闭
		br.close();
		bw.close();
	}
}
