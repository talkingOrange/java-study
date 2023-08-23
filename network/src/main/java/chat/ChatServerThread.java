package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ChatServerThread extends Thread {

	private String nickname = "익명";
	private Socket socket;
	private static List<Writer> listWriters;

	public ChatServerThread(Socket socket) {
		this.socket = socket;
	}

	public ChatServerThread(Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}


	@Override
	public void run() {
		BufferedReader bufferedReader = null;
		PrintWriter printWriter = null;
		try {
			// 1. Remote Host Information
			InetSocketAddress remoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			ChatServer.log("connected by client[" + remoteSocketAddress.getAddress().getHostAddress() + ":"
					+ remoteSocketAddress.getPort() + "]");

			// 2. 스트림 얻기
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8),
					true);

			// 3. 요청 처리

			while (true) {
				String request = bufferedReader.readLine();

				if (request == null) {
					doQuit(printWriter);
					ChatServer.log("클라이언트로부터 연결 끊김");
					break;
				}
				 
				// 4. 프로토콜 분석 및 처리 로직 작성
				String[] tokens = request.split(":"); 
				String message = tokens.length == 1 ? "":tokens[1];
				
				
				if ("join".equals(tokens[0])) {
					doJoin(message, printWriter);
				} else if ("message".equals(tokens[0])) {
					doMessage(message);
				} else if ("quit".equals(tokens[0])) {
					doQuit(printWriter);
				} else {
					ChatServer.log("에러:알수 없는 요청(" + tokens[0] + ")");
				}

			}
		} catch (Exception e) {
			log("error:" + e);
		}
	}

	/////////////////////////////////////////////////////////

	private void doJoin(String nickName, Writer writer) {
		this.nickname = nickName;
	
		String data = nickName + "님이 참여하였습니다.";
		broadcast(data);

		/* writer pool에 저장 */
		addWriter(writer);

		// ack
		PrintWriter printWriter = (PrintWriter) writer;
		printWriter.println("join:ok");
		printWriter.flush();

	}

	private void addWriter(Writer writer) {
		synchronized (writer) {
			listWriters.add(writer);
		}
	}

	private void broadcast(String data) {
		synchronized (listWriters) {
			for (Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter) writer;
				printWriter.println(data);
				printWriter.flush();
			}
		}
	}

	/////////////////////////////////////////////////////

	private void doMessage(String message) {
	    String data = this.nickname + ":" + message;
	    broadcast(data);
	}

	private void doQuit(Writer writer) {
		removeWriter(writer);
		String data = nickname + "님이 퇴장했습니다.";
		broadcast(data);
		
		PrintWriter printWriter = null;
		
		// ack
		printWriter.println("quit");
		printWriter.flush();
	}

	private void removeWriter(Writer writer) {
		synchronized (listWriters) {
			listWriters.remove(writer);
		}

	}

	// (+) log
	static void log(String message) {
		System.out.println("[ChatServerThread# " + Thread.currentThread().getId() + "] " + message);
	}
}