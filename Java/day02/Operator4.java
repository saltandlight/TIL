package day02;

public class Operator4 {

	public static void main(String[] args) {
//		String result="";
//		int a=10;
//		int b=20;
//		result=(a>b)? "A":"B"; 
////		if(a > b) {
////			result="A";
////		}else {
////			result="B";
////		}
//		System.out.println(result);
		
		int i1=20;
		int i2=30;
		int i3=10;
		
		int max=0;
		// 최대 값을 구하시오.
		// 단, 3항 연산자를 이용할 것
//		max=(i1>i2)? i1:i2;
//		max=(max>i3)? max:i3;
		
		max=(i1>i2)? 
				((i1>i3)? i1:i3) : 
					((i2>i3) ? i2:i3);
		System.out.println(max);
		
		
		int min=0;
		min=(i1<i2)? //i1가 더 작음->i3과 비교
				((i1<i3)? i1:i3):
					((i2<i3)? i2:i3);
		System.out.println(min);
				
	}

}
