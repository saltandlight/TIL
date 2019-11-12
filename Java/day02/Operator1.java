package day02;

public class Operator1 {

	public static void main(String[] args) {
//		int a = 10;
//		int b = 10;
//		int result=a++ + b++;//11+11=22
//		System.out.printf("%d %d %d\n", a,b,result);
//       //11 11 22
//		
//		
//		if(a++ < 20 || b++ < 20) { //실행되면 a값만 증가됨.
//			System.out.println(a+" "+b);
//		}
	
		double i1=0.0;
		double i2=0.0;
		double i3 = i1/i2;
	
		System.out.println(i3);
		//예외상황... i2는 변수..! 0이 아닐수도 있다.
		//분모는 0이 아닐 수도 있다.  이럴 때는 정상이고 저럴 때는 비정상
		
		//분모가 0일 때는 무조건 infinity or NaN
		//
	}
}
