package prob1;

import java.util.Scanner;

public class Prob1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );
		System.out.print("���� �Է��ϼ���: ");
		int number = scanner.nextInt();
		
		//3�� ������� Ȯ���ϴ� ����
		System.out.println( (number % 3 == 0) ?  "3�� ����Դϴ�." : "3�� ����� �ƴմϴ�.");
		
		scanner.close();
	}
}
