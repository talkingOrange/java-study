package prob03;

import java.util.Objects;

public class Money {
	private int amount;

	/* 코드 작성 */
	public Money() {
	}

	public Money(int amount) {
		super();
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Money [amount=" + amount + "]";
	}

	public Object add(Money amount) {
		int addAmount = this.amount + amount.amount;
		return new Money(addAmount);
	}

	public Object minus(Money amount) {
		int minusAmount = this.amount - amount.amount;
		return new Money(minusAmount);
	}

	public Object multiply(Money amount) {
		int multiAmount = this.amount * amount.amount;
		return new Money(multiAmount);
	}

	public Object devide(Money amount) {
		int devideAmount = this.amount / amount.amount;
		return new Money(devideAmount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		return amount == other.amount;
	}

}
