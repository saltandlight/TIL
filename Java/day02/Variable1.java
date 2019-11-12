package day02;

public class Variable1 {

	public static void main(String[] args) {
		int a=10;
		int b=10;
		double d= 123.456789;
		
		System.out.printf("\treuslt= %d, %d\n", a, b);
		System.out.printf("\tresult = %o\n", a);
		System.out.printf("\tresult = %x\n", a);
		System.out.printf("result=%10.3f\n",  d); //앞자리는 10자리로 하고 소숫점 3번째 자리까지 출력해라.
		System.out.println(d);

	}

}
