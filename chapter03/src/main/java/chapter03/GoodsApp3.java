package chapter03;

public class GoodsApp3 {
	public static void main(String[] args) {
		
		//Goods3 camera = new Goods3("Nikon", 4000, 10, 20);
		//System.out.println(camera);
		Goods3 camera = new Goods3();
		
		camera.setName("Yewon");
		camera.setPrice(30000);
		camera.setCountStock(20);
		camera.setCountSold(30);
		
		// 정보은닉(데이터보호)
		camera.setPrice(-1);
		
		// countOfGoods 테스트
		Goods3 goods1 = new Goods3();
		Goods3 goods2 = new Goods3();
		Goods3 goods3 = new Goods3();
		
		System.out.println(Goods3.countOfGoods);
		
		System.out.println("Goods2 [name=" + camera.getName() + ", price=" + camera.getPrice() + ", countStock=" + camera.getCountStock() + ", countSold=" + camera.getCountSold()
				+ "]");
		
		
		Goods tv = new Goods("TV", 40000, 10, 20);

		Goods phone = new Goods(); // 이를 위해 기본 생성자도 넣어주어야 함.
		
	}
}
