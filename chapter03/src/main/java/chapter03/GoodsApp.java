package chapter03;

public class GoodsApp {
	public static void main(String[] args) {
		Goods camera = new Goods();
		camera.name = "Nikon"; // heap 공간에 Nikon이 생성되고 -> heap의 Goods 객체를 가리킴
		camera.price = 400000;
		camera.countStock = 10;
		camera.countSold = 20;

		System.out.println("상품이름 : " + camera.name + ", 가격 : " + camera.price + ", 재고개수 : " + camera.countStock
				+ ", 팔린개수 : " + camera.countSold);
	}
}
