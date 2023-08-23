package prob02;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {

		Goods[] goods = new Goods[COUNT_GOODS];

		int num = 0;

		Scanner scanner = new Scanner(System.in);
		while (num != COUNT_GOODS) {
			// 상품 입력
			String line = scanner.nextLine();
			String[] infos = line.split(" ");

			String name = infos[0];
			int price = Integer.parseInt(infos[1]);
			int count = Integer.parseInt(infos[2]);

			goods[num] = new Goods(name, price, count);

			num++;
		}

		// 상품 출력
		for (int i = 0; i < COUNT_GOODS; i++) {
			System.out.println(goods[i]);
		}

		// 자원정리
		scanner.close();
	}
}
