package ws2;

public class MobileTest {

	public static void main(String[] args) {
		// ������ Mobile ��ü ����
		Mobile[] mobile = new Mobile[2];
		mobile[0] = new Ltab("Ltab", 500, "AP-01");
		mobile[1] = new Otab("Otab", 1000, "AND-20");
		
		System.out.println("\tMobile\t\tBattery\t\tOS");
		System.out.println("--------------------------------------------");
		
		for(Mobile m : mobile) {
			System.out.println(m.toString());
		}
		System.out.println();
		
		System.out.println("10 �� ����");
		System.out.println("\tMobile\t\tBattery\t\tOS");
		System.out.println("--------------------------------------------");
		
		for(Mobile m : mobile) {
			m.charge(10);
			System.out.println(m.toString());
		}
		System.out.println();
		
		System.out.println("5 �� ��ȭ");
		System.out.println("\tMobile\t\tBattery\t\tOS");
		System.out.println("--------------------------------------------");
		
		for(Mobile m : mobile) {
			m.operate(5);
			System.out.println(m.toString());
		}
	}
}
