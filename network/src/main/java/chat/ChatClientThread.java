package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public class ChatClientThread extends Thread {
	private BufferedReader bufferedReader;
	private Socket socket;

	public ChatClientThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

		try {
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

			while (true) {
				String message = bufferedReader.readLine();
				if (message == null) {
					break;
				}
				System.out.println(message); // 에옹: --이렇게 나오게 해주는 것
			}
		} catch (SocketException e) {
			log("socket" + e);
		} catch (IOException e) {
			log("error: " + e); // 이후 에러가 여기서 발생하고
		} finally {
			System.exit(0); // 끝나버림.
		}
	}

	protected static void log(String message) {
		System.out.println("[ChatClient] " + message);
	}
}
