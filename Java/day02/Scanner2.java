package day02;

import java.util.Scanner;

public class Scanner2 {

	public static void main(String[] args) {
		// 2���� ���ڸ� �޾Ƶ��δ�.
		// a/b�� ����Ѵ�.
		// ��� �� �Ҽ��� 3�ڸ����� ����Ͻÿ�.
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
