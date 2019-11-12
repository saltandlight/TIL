package day02;

import java.util.Scanner;

public class Scanner2 {

	public static void main(String[] args) {
		// 2개의 숫자를 받아들인다.
		// a/b를 계산한다.
		// 출력 시 소숫점 3자리까지 출력하시오.
		int a, b;
		a=b=0;
		Scanner scan= new Scanner(System.in);
		System.out.println("Input Number...?");
        String data1 = scan.next();
        String data2 = scan.next();
//      a=Integer.parseInt(data1);
//      b=Integer.parseInt(data2);
//		
//		double c= (double)a/(double)b;
        System.out.println(data1+" "+data2);
        scan.close();
//		System.out.printf("%5.3f", c);
	}

}
