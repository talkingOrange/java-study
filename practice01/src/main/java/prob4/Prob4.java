package prob4;

import java.util.Scanner;

public class Prob4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("���ڿ��� �Է��ϼ��� : ");
		String text = scanner.nextLine();
		String answer= "";
		for(int i =0 ; i< text.length(); i++) {
			answer += text.charAt(i);
			System.out.println(answer);
		}
		System.out.println(text);
		
		scanner.close();
	}

}
