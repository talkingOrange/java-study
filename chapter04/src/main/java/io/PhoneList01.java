package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;

public class PhoneList01 {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			File file = new File("phone.txt");

			// 파일 존재 유무에 대해서 Exception을 쓰지 말것. exists()로 확인할 것.
			if (!file.exists()) {
				System.out.println("File Not Found");
			}
			System.out.println("==== 파일정보 ====");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length() + "bytes");

			// 날짜 처리
//		Long timestamp = file.lastModified();
//		Date d = new Date(timestamp);
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String date = sdf.format(d);
			String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss\"").format(new Date(file.lastModified()));
			System.out.println(date);

			System.out.println("==== 전화번호 ====");

			// 1. 기본 스트림(FileInputStream)
			FileInputStream fis = new FileInputStream(file);

			// 2. 보조 스트림 1 ( byte | byte | byte -> char )
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");

			// 3. 보조스트림 2 ( char1 | char2 | char3 | \n -> "char1char2char3" )
			br = new BufferedReader(isr);

			// 4. 처리
			String line = null;
			while ((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, "\t ");

				int index = 0;
				while (st.hasMoreElements()) {
					String token = st.nextToken();

					if (index == 0) { // 이름
						System.out.print(token + ":");
					} else if (index == 1) { // 전화번호1
						System.out.print(token + "-");
					} else if (index == 2) { // 전화번호3
						System.out.print(token + "-");
					}else { //전화번호 3
						System.out.print(token);
						
					}
					index++;
				}
				System.err.println();
			}

		} catch (UnsupportedEncodingException e) {
			System.out.println("Error: " + e);
		} catch (IOException e) { // FilenotFoundException의 부모가 IOException임.
			System.out.println("Error: " + e);
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
