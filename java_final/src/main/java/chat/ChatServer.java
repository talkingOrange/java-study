package chat;

import java.io.IOException;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	public static final int PORT = 9999;

	public static void main(String[] args) {
		List<Writer> listWriters = new ArrayList<Writer>();

		ServerSocket serverSocket = null;

		try {
			// 1. 서버 소겟 생성
			serverSocket = new ServerSocket();

			// 2. 바인딩
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress(hostAddress, PORT), 10);
			log("다음 ip/port로 연결을 기다리는 중입니다 : " + hostAddress + "/" + PORT);

			// 3. 요청 대기
			while (true) {
				Socket socket = serverSocket.accept();
				
				Thread thread = new ChatServerThread(socket, listWriters);
				thread.start();
			}
		} catch (IOException e) {
			log("error:" + e);
		}
	}

	public static void log(String message) {
		System.out.println("[ChatServer# " + Thread.currentThread().getId() + "] " + message);
	}
}
