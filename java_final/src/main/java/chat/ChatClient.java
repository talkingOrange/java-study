package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	public static final String SERVER_IP = "192.168.0.145";
	
	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;
		
		try {
			// 1. 키보드 연결
			scanner = new Scanner( System.in );
			
			// 2. socket 생성
			socket = new Socket();

			// 3. 연결
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
			log("connected");

			// 4. reader/writer 생성
			PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
		
			// 5. join 프로토콜
			System.out.println("안녕하세요. 에옹이의 채팅프로그램입니다.");
			System.out.print("닉네임>>");
			String nickname = scanner.nextLine();
			
			
			if(nickname.equals("")) {
				nickname = "익명" ;
			}
			
			printWriter.println("join:" + nickname);
			printWriter.flush();
			

			String ack = bufferedReader.readLine();
			if( "join:ok".equals( ack ) ) {
				System.out.println( nickname + "님 반갑습니다. 채팅에 입장하셨습니다." );
				System.out.println( "채팅방을 나가시고 싶다면, quit를 입력해주세요!" );
			}
			
			// 6. ChatClientReceiveThread 시작
			new ChatClientThread( socket ).start();
			

			// 7. 키보드 입력 처리
			while (true) {
				System.out.print(">>");
				String input = scanner.nextLine();

				if ("quit".equals(input) == true) {
					// 8. quit 프로토콜 처리
					printWriter.println( "quit" );
					break;
				} else {
					// 9. 메시지 처리
					printWriter.println("message:" + input);
					printWriter.flush();
				}
			}

		} catch (IOException ex) {
			log("error:" + ex);
		} finally {
			// 10. 자원정리
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
				if(scanner != null) {
					scanner.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	private static void log(String message) {
		System.out.println("[ChatClient] " + message);
	}	
}
