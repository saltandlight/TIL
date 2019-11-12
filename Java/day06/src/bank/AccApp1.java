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
		
		System.out.println("���¸� ����̽��ϴ�~");
		//���߿� �� �ӴϺ��� ������ �Ӵϰ� �� ũ�� �۱��� �� �ǰ� �ؾ� ��.
		Date currentTime2 = new Date ();
		String date2 = mSimpleDateFormat.format(currentTime2);
		ac1.send(1357924680, "��������", 50000, true, 2019, date2);
		System.out.println(ac1.toString());
		System.out.println("50000���� �۱��߽��ϴ�.");
		
		Date currentTime3 = new Date ();
		String date3 = mSimpleDateFormat.format(currentTime3);
		ac1.plus(50000, date3);
		System.out.println(ac1.toString());
		System.out.println("50000�� �Ա��߽��ϴ�.");
		
		
		Date currentTime4 = new Date ();
		String date4 = mSimpleDateFormat.format(currentTime4);
		//minus(money: int, pwd: int, check: boolean, date: String)
		ac1.minus(5000, 2019, true, date4);
		System.out.println(ac1.toString());
		System.out.println("5000�� ����߽��ϴ�.");
		
		ac1.moneyRate(0.019);
		System.out.println(ac1.toString());
		System.out.println("�������� 1.9%�� ����߽��ϴ�.");
		
	}

}
