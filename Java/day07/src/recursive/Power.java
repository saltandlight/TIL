package recursive;

public class Power {

	public static void main(String[] args) {
		int x=2;
		int n=5;
		int result=0;
		
		result=power(x,n);
		System.out.println(result);
		System.out.println(sum_power(x, n));

	}
	//1. 함수 말로 정의 
	private static int power(int x, int n) {
	    //2.기저조건
		if(n==1) return x;
		//3.진행된다는 가정하에 연산 수행
		else {
			return x*power(x, n-1);
		}
	}
	
	private static int sum_power(int x, int n) {
		if(n==1) 
			return power(x,1);
		else 
			return power(x, n)+sum_power(x,n-1);
	}

}
