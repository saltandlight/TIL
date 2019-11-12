package stat;

public class Calc {
	public static int sum(int a, int b) {
		return (a+b);
	}
	
	//오버로드
	public static int sum(int a[]) {
		int sum=0;
		for(int data:a) {
			sum+=data;
		}
		return sum;
	}
}
