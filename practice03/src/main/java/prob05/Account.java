package prob05;

public class Account {
	private String accountNo;
	private int balance;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(String accountNo) {
		super();
		this.accountNo = accountNo;
		System.out.println( accountNo + " 계좌가 개설되었습니다.");
	}

	public Account(String accountNo, int balance) {
		super();
		this.accountNo = accountNo;
		this.balance = balance;
	}
	

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", balance=" + balance + "]";
	}

	public void save(int i) {
		//입금
		balance = i;
		System.out.println(accountNo + " 계좌에 " + i + "만원이 입금되었습니다.");
	}

	public void deposit(int i) {
		//출금
		balance -= i;
		System.out.println(accountNo + " 계좌에 " + i + "만원이 출금되었습니다.");
	}
	
}
