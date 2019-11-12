package ws1;

public class TransportTest {

	public static void main(String[] args) {
		Transportation[] T = new Transportation[3];
		T[0] = new Bus(1250, "1111", 2);
		T[1] = new MBus(2600, "2058", 1, false);
		T[2]= new Subway(1250, "4118", 4, false);

		
		for(Transportation tp: T) {
			System.out.println(tp.toString());
			tp.move(4, 4);
			tp.calFare();
			if(tp instanceof MBus) {
				MBus mb = (MBus)tp;
				mb.switch_multi();
			}
			System.out.println(tp.toString());
			System.out.println("--------------------------------------------------");
		}
	}
}
