package forwhile;

public class WEx1 {
	
	public static void main(String[] args) {
//		//for
//		for(int i=1;i<=10;i++) {
//			System.out.println(i);
//		}
//		//while
//		int i=1;
//		while(i<=10) { //조건에 true, false가 들어감.
//			System.out.println(i++);
//		}
//		
		//2중 for 문
//		for(int a=0;a<=10;a++) {
//			for(int b=10;b>=0;b--) {
//				System.out.println(a+" "+b);
//				
//			}
//		}
		
		//While 변경
		int a2, b2;
		a2=0;
		while(a2<=10) {
			b2=10;
			while(b2>=0) {
			  System.out.println(a2+" "+b2);
			  b2--;
		   }a2++; 
		}
		
	}

}
