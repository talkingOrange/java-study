package httpd;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.Files;

public class RequestHandler extends Thread {
	private static final String DOCUMENT_ROOT = "./webapp";

	private Socket socket;

	public RequestHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			// logging Remote Host IP Address & Port
			InetSocketAddress inetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			log("connected from " + inetSocketAddress.getAddress().getHostAddress() + ":"
					+ inetSocketAddress.getPort());

			// get IOStream
			OutputStream outputStream = socket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

			String request = null;
			while (true) {
				String line = br.readLine();

				// 브라우저가 연결을 끊으면,
				if (line == null) {
					break;
				}
				// SimpleHttpServer는 요청의 헤더만 처리한다.
				if ("".equals(line)) {
					break;
				}

				// 요청 헤더의 첫번째 라인만 읽음
				if (request == null) {
					request = line;
					break;
				}
				log(line);
			}
			log(request);

			String[] tokens = request.split(" ");
			if ("GET".equals(tokens[0])) {
				responseStaticResource(outputStream, tokens[1], tokens[2]);
			} else {
				// methods : POST, PUT, DELETE, HEAD, CONNECT
				// SimpleHttpServer에서는 무시(400 Bad Request)
				System.out.println("400 Bad Request: " + request);
				responseStatic400Error(outputStream, tokens[2]);
			}

			// 예제 응답입니다.
			// 서버 시작과 테스트를 마친 후, 주석 처리 합니다.
//			outputStream.write("HTTP/1.1 200 OK\r\n".getBytes("UTF-8"));
//			outputStream.write("Content-Type:text/html; charset=utf-8\r\n".getBytes("UTF-8"));
//			outputStream.write("\r\n".getBytes());
//			outputStream.write("<h1>이 페이지가 잘 보이면 실습과제 SimpleHttpServer를 시작할 준비가 된 것입니다.</h1>".getBytes("UTF-8"));

		} catch (Exception ex) {
			log("error:" + ex);
		} finally {
			// clean-up
			try {
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}

			} catch (IOException ex) {
				log("error:" + ex);
			}
		}
	}

	private void responseStatic400Error(OutputStream outputStream, String protocol) throws IOException {
		// post 에러
		
		// HTTP/1.1 400 bad request\r\n
				// Content-Type:text/html; charset=utf-8\r\n
				//\r\n
				// error/400.html 내용
		
		File file = new File(DOCUMENT_ROOT + "/error/400.html");
		if (!file.exists()) {
			System.out.println("400 bad request: 400.html");
			 responseStatic404Error(outputStream, protocol);
			return;
		}

		// nio
		byte[] body = Files.readAllBytes(file.toPath());
		
		outputStream.write("HTTP/1.1 404 bad request\\r\\n".getBytes("UTF-8"));
		outputStream.write("Content-Type:text/html; charset=utf-8\r\n".getBytes("UTF-8"));
		outputStream.write("\r\n".getBytes());
		outputStream.write(body);
	}

	private void responseStatic404Error(OutputStream outputStream, String protocol) throws IOException {
		// 없는 페이지 에러
		
		// HTTP/1.1 404 File Not Found\r\n
		// Content-Type:text/html; charset=utf-8\r\n
		//\r\n
		// error/404.html 내용
		
		File file = new File(DOCUMENT_ROOT + "/error/404.html");
		if (!file.exists()) {
			System.out.println("404 File NOT Found: 404.html");
			 responseStatic404Error(outputStream, protocol);
			return;
		}

		// nio
		byte[] body = Files.readAllBytes(file.toPath());
		
		outputStream.write("HTTP/1.1 404 File Not Found\\r\\n".getBytes("UTF-8"));
		outputStream.write("Content-Type:text/html; charset=utf-8\r\n".getBytes("UTF-8"));
		outputStream.write("\r\n".getBytes());
		outputStream.write(body);
	}

	private void responseStaticResource(OutputStream outputStream, String url, String protocol) throws IOException {
		// default(welcome) file
		if ("/".equals(url)) {
			url = "/index.html";
		}

		File file = new File(DOCUMENT_ROOT + url);
		if (!file.exists()) {
			System.out.println("404 File NOT Found: " + url);
			 responseStatic404Error(outputStream, protocol);
			return;
		}

		// nio
		byte[] body = Files.readAllBytes(file.toPath());
		
		String contentType = Files.probeContentType(file.toPath());
		
		// 응답
		outputStream.write("HTTP/1.1 200 OK\r\n".getBytes("UTF-8"));
		outputStream.write(("Content-Type:" + contentType + "; charset=utf-8\r\n").getBytes("UTF-8"));
		outputStream.write("\r\n".getBytes());
		outputStream.write(body);
	}

	public void log(String message) {
		System.out.println("[RequestHandler#" + getId() + "] " + message);
	}
}
