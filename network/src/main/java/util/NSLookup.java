package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {
	public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			InetAddress[] inetAddress = null;

			try {
				while (true) {
				System.out.print(">> ");
				String line = scanner.nextLine();

				if ("quit".equals(line)) {
					break;
				}
			inetAddress = InetAddress.getAllByName(line);

			for (int i = 0; i < inetAddress.length; i++) {

				System.out.println(inetAddress[i].getHostAddress());
			}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
