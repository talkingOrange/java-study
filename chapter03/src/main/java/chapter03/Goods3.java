package chapter03;

public class Goods3 {
	public static int countOfGoods = 0;
	
	private String name; //모든 접근이 가능하다(접근 제한이 없다)
	private int price;
	private int countStock;
	private int countSold;
	
	public Goods3() {
		//내부에서는 클래스 이름 생략 가능
		//Goods.countOfGoods++;
		countOfGoods++;
	}

	public Goods3(String name, int price, int countStock, int countSold) {
		super();
		this.name = name;
		this.price = price;
		this.countStock = countStock;
		this.countSold = countSold;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		//정보 보호
		if(price < 0) {
			price = 0;
		}
		this.price = price;
	}

	public int getCountStock() {
		return countStock;
	}

	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}

	public int getCountSold() {
		return countSold;
	}

	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}

	@Override
	public String toString() {
		return "Goods2 [name=" + name + ", price=" + price + ", countStock=" + countStock + ", countSold=" + countSold
				+ "]";
	}
	
	
	public void voidMethod() {
		System.out.println("Goods2 [name=" + name + ", price=" + price + ", countStock=" + countStock + ", countSold=" + countSold
				+ "]"); 
	}
	
}
