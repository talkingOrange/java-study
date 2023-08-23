package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class KeyboardTest {
	public static void main(String[] args) {
		BufferedReader br = null;

		try {
			// 1. 기본 스트림(표준 입력, stdin, System.in)

			// 2. 보조 스트림 1 ( byte | byte | byte -> char )
			InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");

			// 3. 보조스트림 2 ( char1 | char2 | char3 | \n -> "char1char2char3" )
			br = new BufferedReader(isr);

			// 4. 처리
			String line = null;
			while ((line = br.readLine()) != null) {
				if ("quit".equals(line)) {
					break;
				}

				System.out.println(line);
			}

		} catch (UnsupportedEncodingException e) { // UTF-8이 오타가 날 수 있으니까
			System.out.println("Error: " + e);

		} catch (IOException e) {
			System.out.println("Error: " + e);
		} finally {
			try {
				if(br!=null) {
					br.close();
				}
			} catch ( IOException e ) {
				e.printStackTrace();
			}
		}
	}
}
