package bank;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AccApp1 {

	public static void main(String[] args) {
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ("yyyy.MM.dd HH:mm:ss", Locale.KOREA );
		Date currentTime = new Date ();
		String date1 = mSimpleDateFormat.format(currentTime);
		Account ac1 = new Account(1234567890L,500000, 2019, 0.017, date1);
		System.out.println(ac1.toString());
		
		System.out.println("계좌를 만드셨습니다~");
		//나중에 내 머니보다 보내는 머니가 더 크면 송금이 안 되게 해야 함.
		Date currentTime2 = new Date ();
		String date2 = mSimpleDateFormat.format(currentTime2);
		ac1.send(1357924680, "신한은행", 50000, true, 2019, date2);
		System.out.println(ac1.toString());
		System.out.println("50000원을 송금했습니다.");
		
		Date currentTime3 = new Date ();
		String date3 = mSimpleDateFormat.format(currentTime3);
		ac1.plus(50000, date3);
		System.out.println(ac1.toString());
		System.out.println("50000을 입금했습니다.");
		
		
		Date currentTime4 = new Date ();
		String date4 = mSimpleDateFormat.format(currentTime4);
		//minus(money: int, pwd: int, check: boolean, date: String)
		ac1.minus(5000, 2019, true, date4);
		System.out.println(ac1.toString());
		System.out.println("5000을 출금했습니다.");
		
		ac1.moneyRate(0.019);
		System.out.println(ac1.toString());
		System.out.println("이자율이 1.9%로 상승했습니다.");
		
	}

}
