package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in  );

		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };
		int[] answer = {0,0,0,0,0,0,0,0,0,0};
		System.out.print("�ݾ�: ");
		int number = scanner.nextInt();
		
		for(int i =0; i<answer.length; i++) {
			answer[i] = number / MONEYS[i];
			
			number = number - answer[i] * MONEYS[i];
			System.out.println(MONEYS[i] + "�� : " + answer[i] + "��");
		}
		
		scanner.close();
 	}
}