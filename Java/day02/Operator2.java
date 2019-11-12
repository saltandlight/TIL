package day02;

public class Operator2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		double d=3.14356523;
//		//소숫점 3자리 이하 버림을 계산하고 출력
//		double result1=Math.floor(d*1000)/1000.0;
//		System.out.println(result1);
//		// 소숫점 3자리 이해 반올림을 계산하고 출력
//		double result2=Math.round(d*1000+0.5)/1000.0;
//		System.out.println(result2);
		
		//직각 삼각형 가로세로가 5, 4인 삼각형
		//빗변의 길이를 구하시오
		//hint Math API를 이용할 것
		
		int a=5;
		int b=4;
		double result=Math.sqrt((double)(a*a)+(double)(b*b));
		
		System.out.println(result);
		result=Math.sqrt(Math.pow(5, 2)+Math.pow(4, 2));
		System.out.println(result);
	}
}
