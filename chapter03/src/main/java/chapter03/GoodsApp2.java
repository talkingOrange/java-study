package chapter03;

import mypackage.Goods2;

public class GoodsApp2 {
	public static void main(String[] args) {
		Goods2 camera = new Goods2();
		
		// public : 접근 제한이 없다.
		camera.name = "Nikon"; 
		
		// protected : 같은 패키지에서 접근이 가능하다.
		// 			   더 중요한 접근 제어는 자식에서 접근 가능하다.
		//camera.price = 400000; 다른 패키지 이동 시 오류
		
		// 디폴트 : 같은 패키지에서 접근이 가능하다.
		//camera.countStock = 10; 다른 패키지 이동 시 오류
		
		// private : 같은 클래스에서만 접근이 가능하다.
		//camera.countSold = 20;
		camera.m();

		//System.out.println("상품이름 : " + camera.name + ", 가격 : " + camera.price + ", 재고개수 : " + camera.countStock
		//		+ ", 팔린개수 : " + camera.countSold);
	}
}
