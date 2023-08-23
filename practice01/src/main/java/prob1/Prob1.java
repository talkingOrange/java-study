package prob1;

import java.util.Scanner;

public class Prob1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );
		System.out.print("수를 입력하세요: ");
		int number = scanner.nextInt();
		
		//3의 배수인지 확인하는 문장
		System.out.println( (number % 3 == 0) ?  "3의 배수입니다." : "3의 배수가 아닙니다.");
		
		scanner.close();
	}
}
