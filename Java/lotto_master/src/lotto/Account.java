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
//            throw new Exception("������ �ݾ��� �����ּ���");
//        }
//        if (this.balance < money) {
//            throw new Exception("�ܾ��� �����մϴ�.");
//        }
        this.balance -= money;
    }
 
    public void deposit(int money) {
    
//throws Exception {
//        if (money <= 0) {
//        	
//            throw new Exception("���� �־��ּ���");
//        }
        this.balance += money;
    }
 
}



