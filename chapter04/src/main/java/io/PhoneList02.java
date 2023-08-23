package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class PhoneList02 {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("phone.txt");

		// 파일 존재 유무에 대해서 Exception을 쓰지 말것. exists()로 확인할 것.
		if (!file.exists()) {
			System.out.println("File Not Found");
		}
		System.out.println("==== 파일정보 ====");
		System.out.println(file.getAbsolutePath());
		System.out.println(file.length() + "bytes");

		// 날짜 처리
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss\"").format(new Date(file.lastModified()));
		System.out.println(date);

		System.out.println("==== 전화번호 ====");

		Scanner scanner = new Scanner(file);
		while(scanner.hasNextLine()) {
			String name = scanner.next();
			String phone1 = scanner.next();
			String phone2 = scanner.next();
			String phone3 = scanner.next();
			
			System.out.println(name + ":" + phone1 + "-" + phone2+ "-" + phone3);
		}
		scanner.close();
	}
}
