package recursive;

public class Factorial {

	public static void main(String[] args) {
		int n=6;
		int result=0;
		result=factorial(n);
		System.out.println(result);

	}
	//1. 말로 함수를 정의
	//2. 기저조건
	//3. 연산 정의
//
//	private static int factorial(int n) {
//		if(n<=1) return 1;
//		else {
//			return n*factorial(n-1);
//		}
//	}
	//
	private static int factorial(int n) {
		int result=0;
		if(n<=1) result= 1;
		else {
			result=n*factorial(n-1);
		}
		return result;
	}
}
