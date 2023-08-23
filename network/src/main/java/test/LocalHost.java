package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHost {
	public static void main(String[] args) {
		try {
			InetAddress inetAddress  = InetAddress.getLocalHost(); //프로그램이 돌고있는 주소 ***
			
			String hostname = inetAddress.getHostName(); //컴퓨터 이름. (도메인이랑 상관 X)
			String hostIpAdress = inetAddress.getHostAddress(); //ip주소
			
			System.out.println(hostname);
			System.out.println(hostIpAdress);
			
			byte[] IpAddresses  = inetAddress.getAddress(); //진짜 ip address임. byte배열이기 떄문.
			
			for(byte IpAddress : IpAddresses) {
				System.out.println(IpAddress & 0x0000000ff);
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace(); //TCP/IP 안깔려있으면 나옴
		}
	}
}
