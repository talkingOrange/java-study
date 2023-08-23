package prob02;

public class Goods {
	private String drink;
	private int cost;
	private int count;
	
	public Goods() {
	}

	public Goods(String drink, int cost, int count) {
		super();
		this.drink = drink;
		this.cost = cost;
		this.count = count;
	}

	public String getDrink() {
		return drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return drink + "(가격:" + cost + "원)이 " + count + "개 입고 되었습니다.";
	}
}
