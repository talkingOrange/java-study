package prob02;

import java.util.Scanner;

public class Prob02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] intArray = new int[5];
		double sum = 0;

		/* Ű���忡�� �迭 ũ�⸸ŭ �Է� �޾� �迭�� �����ϴ� �ڵ� */

		System.out.println("5���� ���ڸ� �Է��ϼ���.");

		for (int i = 0; i < 5; i++) {
			intArray[i] = scanner.nextInt();
		}

		/* �迭�� ����� ���� �� ���ϱ� */
		for (int i = 0; i < 5; i++) {
			sum += intArray[i];
		}
		
		/* ��� */
		System.out.println(sum/5.0);

		scanner.close();
	}
}
