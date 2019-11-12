package bank;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Account {
	private String bank_name;
	private Long acc_num; //10자리를 디폴트 10000000000000
	private int money; //0
	private int pwd; //1000
	private boolean check; //false
	private double rate; 
	private String date; 
	
	SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy.MM.dd HH:mm:ss", Locale.KOREA );
	


	Account(){
		acc_num=1000000000L;
		money=0;
		pwd=1000;
		check=false;
		rate=0.017;
		Date currentTime = new Date ();
		date = mSimpleDateFormat.format(currentTime);
	}



	public String getBank_name() {
		return bank_name;
	}



	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}



	public Long getAcc_num() {
		return acc_num;
	}



	public void setAcc_num(Long acc_num) {
		this.acc_num = acc_num;
	}



	public int getMoney() {
		return money;
	}



	public void setMoney(int money) {
		this.money = money;
	}



	public int getPwd() {
		return pwd;
	}



	public void setPwd(int pwd) {
		this.pwd = pwd;
	}



	public boolean isCheck() {
		return check;
	}



	public void setCheck(boolean check) {
		this.check = check;
	}



	public double getRate() {
		return rate;
	}



	public void setRate(double rate) {
		this.rate = rate;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	Account(Long acc_num, int money, int pwd, double rate, String date) {
		this.acc_num = acc_num;
		this.money = money;
		this.pwd = pwd;
		this.rate = rate;
		this.date = date;
	}
	
	void send(long acc_num, String bank_name, int money, boolean check,int pwd,String date) {//UML 수정
//		System.out.println("예금주 은행이 "+bank_name+", 예금주 계좌번호가 "+ acc_num+"이 맞습니까?");
		if(check==true && pwd==this.pwd) {
			this.money -= money;
		}
		this.date=date;
	}
	
	void plus(int money, String date) {
		this.money += money;
	}
	
	void minus(int money, int pwd, boolean check, String date) {
		if(check==true && pwd==this.pwd)
			this.money-=money;
	}
	
	@Override
	  public String toString() {
		  return "[계좌번호=" + acc_num + ", 돈=" + money + ",비밀번호=" + pwd+", 이자율="+rate+", 날짜="+date+"]";

	  }
	
	void moneyRate(double rate) { //수정 매개변수 type도 수정
		this.rate=rate;
		money *= (1+rate);
	}
	
}
