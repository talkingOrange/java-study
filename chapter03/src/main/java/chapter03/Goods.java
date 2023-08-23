package chapter03;

public class Goods {
	String name;
	int price;
	int countStock;
	int countSold;

	//생성자의 오버로딩
	public Goods() {
	}

	public Goods(String name, int price, int countStock, int countSold) {
		this.name = name;
		this.price = price;
		this.countSold = countSold;
		this.countStock = countStock;
	}
	
}