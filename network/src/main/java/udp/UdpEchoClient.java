package udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

import echo.EchoServer;

public class UdpEchoClient {
	private static final String SERVER_IP = "127.0.0.1";

	public static void main(String[] args) {
		DatagramSocket socket = null;
		Scanner scanner = null;
		
		try {
			//1. 스캐너 생성
			scanner = new Scanner(System.in);
			
			//2. 소켓 생성
			socket = new DatagramSocket();
			while(true) {
				System.out.print(">");
				String line = scanner.nextLine();
				
				if("exit".equals(line)) {
					break;
				}
				
				//3. 보내기
				byte[] sndData = line.getBytes("utf-8");
				DatagramPacket sndPacket = new DatagramPacket(sndData, sndData.length, new InetSocketAddress(SERVER_IP, UdpEchoServer.PORT));
				
				socket.send(sndPacket);
				
				//4. 받아서 읽기
				DatagramPacket rcvPacket = new DatagramPacket(new byte[UdpEchoServer.BUFFER_SIZE], UdpEchoServer.BUFFER_SIZE );
				socket.receive(rcvPacket); // Blocking
				
				byte[] rcvData = rcvPacket.getData();
				int offset = rcvPacket.getLength();
				
				String message = new String(rcvData, 0 , offset, "utf-8");
				
				System.out.println("<" + message);
				
			}
		} catch (SocketException e) {
			System.out.println("[UDP Echo client] error:" + e);
		} catch (IOException e) {
			System.out.println("[UDP Echo client] error:" + e);
		} finally {
			if(scanner != null) {
				scanner.close();
			}
			if (socket != null && socket.isClosed()) {
				socket.close();
			}
		}
	}
	
	private static void log(String message) {
		System.out.println("[EchoClient] " + message);
	}	
}
