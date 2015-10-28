package com.gxw.www.tcpserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	int port = 2345; // �˿ں�
	ServerSocket serverSocket; // �������׽���

	public TCPServer() {
		try {
			serverSocket = new ServerSocket(port); // ʵ�����׽���
			System.out.println("start server at port " + port); // ������������ʾ��Ϣ

			while (true) { // һֱ�ȴ��ͻ�������
				Socket client = serverSocket.accept(); // �ȴ�����
				System.out.println("Connect: " + client.getInetAddress()); // ����ͻ�����ַ
				DataInputStream in = new DataInputStream(
						client.getInputStream()); // �õ�������
				
				byte[] buffer = new byte[256]; // ������
				in.read(buffer); // �������ݵ�������
				System.out.println(new String(buffer)); // �����Ϣ
				
				DataOutputStream out = new DataOutputStream(
						client.getOutputStream()); // �õ������

				byte[] message = "TTTTT"
						.getBytes(); // �����Ϣ�ַ�����
				out.write(message, 0, message.length); // �����Ϣ
			}
		} catch (IOException ex) {
			ex.printStackTrace(); // ���������Ϣ
		}
	}

	public static void main(String[] args) {
		new TCPServer();
	}

}