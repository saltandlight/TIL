package lotto;
 
public class Account {
    // attribute
    private String owner;
    private int balance;
 
    // constructor
    public Account() {
    }
 
    public Account(String owner, int balance) {
        this.owner = owner;
        this.balance = balance;
    }
    // function
 
    public String getOwner() {
        return owner;
    }
 
    public int getBalance() {
        return balance;
 
    }
 
    @Override
    public String toString() {
        return "account [owner=" + owner + ", balance=" + balance + "]";
    }
 
    // function
    public void withdraw(int money) { 
//    		throws Exception {
//        if (money <= 0) {
//            throw new Exception("인출할 금액을 적어주세요");
//        }
//        if (this.balance < money) {
//            throw new Exception("잔액이 부족합니다.");
//        }
        this.balance -= money;
    }
 
    public void deposit(int money) {
    
//throws Exception {
//        if (money <= 0) {
//        	
//            throw new Exception("돈을 넣어주세요");
//        }
        this.balance += money;
    }
 
}



