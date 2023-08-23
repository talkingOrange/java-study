package prob05;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = 1; // 사용자가 몇 번째 도전인지
		int min = 1; // 선택 가능한 최소의 수
		int max = 100; // 선택 가능한 최대의 수

		while (true) {

			/* 게임 작성 */
			System.out.println("수를 결정하였습니다. 맞추어 보세요");

			// 정답 램덤하게 만들기
			Random random = new Random();
			int correctNumber = random.nextInt(100) + 1;

			while (true) {
				System.out.println(min + "-" + max);
				System.out.print(n + ">>");
				int userNum = scanner.nextInt();

				if (userNum == correctNumber) {
					System.out.println("맞았습니다.");
					break;
				} else if (userNum > correctNumber) {
					System.out.println("더 낮게");
					max = userNum - 1;
				} else {
					System.out.println("더 높게");
					min = userNum + 1;
				}
				n++;
			}
			// 새 게임 여부 확인하기
			System.out.print("다시 하겠습니까(y/n)>>");
			String answer = scanner.next();
			if ("y".equals(answer) == false) {
				break;
			}
		}

		scanner.close();
	}

}