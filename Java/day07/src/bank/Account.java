package bank;

public class Account {
	private String owner;
	private String accNum;
	private double balance;
	public static int cnt=0;
	
	public Account() {
	}

	public Account(String owner, String accNum, double balance) throws Exception {
		if(accNum.length() != 5) {
			throw new Exception("E1000");
		}
		this.owner = owner;
		this.accNum = accNum+cnt;
		this.balance = balance;
		cnt++;
	}

	public String getOwner() {
		return owner;
	}

	public String getAccNum() {
		return accNum;
	}

	public double getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return "Account [owner=" + owner + ", accNum=" + accNum + ", balance=" + balance + "]";
	}
	
	public void withdraw(double money) throws Exception {
		if(money <= 0) {
			throw new Exception("E0001");
		}
		if(balance < money) {
			throw new Exception("E0002");
		}
		else balance -= money;
	}
	
	public void deposit(double money) throws Exception {
		if(money <= 0) {
			throw new Exception("E0001");
		
		}
		balance += money;
	}
	
}
