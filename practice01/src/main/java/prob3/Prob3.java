package prob3;

import java.util.Scanner;

public class Prob3 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n = 0;
		while (n != 3) {
			System.out.print("���ڸ� �Է��ϼ���: ");
			int number = scanner.nextInt();

			int even = 0;
			int odd = 0;

			for (int i = 1; i <= number; i++) {
				if (i % 2 == 0) {
					even += i;
				} else {
					odd += i;
				}
			}
			System.out.print("��� �� : ");
			System.out.println((number % 2 == 0) ? even : odd);
			n++;
			System.out.println();
		}
	}
}
