package day02;

import java.util.Scanner;

public class Variable3 {

	public static void main(String[] args) {
		// 4과목의 점수를 정수로 입력받는다.
		// 합계와 평균을 구하시오.
		Scanner scan = new Scanner(System.in);
		
		int a, b, c, d;
		
		System.out.println("Input 4 Number...");
		String data1=scan.next();
		String data2=scan.next();
		String data3=scan.next();
		String data4=scan.next();
		
//		a=scan.nextInt();
//		b=scan.nextInt();
//		c=scan.nextInt();
//		d=scan.nextInt();
		a=Integer.parseInt(data1);
		b=Integer.parseInt(data2);
		c=Integer.parseInt(data3);
		d=Integer.parseInt(data4);
		double sum = 0.0;
		double mean = 0.0;
		
		sum=a+b+c+d;
		mean=sum/4;
		System.out.println("합계: "+sum);
		System.out.println("평균: "+mean);

	}

}
