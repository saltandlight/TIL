package ifswhitch;

import java.util.Scanner;
import java.lang.Math;

public class IfEx3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Intput 3 Number.");
		int n1=Integer.parseInt(sc.next());
		int n2=Integer.parseInt(sc.next());
		int n3 = Integer.parseInt(sc.next());
		int min=0, max=0;
		//Min
		min=Math.min(n1, n2);
		min=Math.min(min, n3);
//		if(n1<n2) { 
//			min=n1;
//			if(n3<min)
//				min=n3;
//		}else {
//			min=n2;
//			if(n3<min) min=n3;
//		}
					
		//Max
		max=Math.max(n1, n2);
		max=Math.max(max, n3);
//		max=(n1>n2)? 
//				((n1>n3)? n1:n3):  //n1�� n2���� ū�� n3���� ŭ//n1�� n2���� ū�� n3���� �۰ų� ����.
//					((n2>n3)? n2: n3);
//					
		System.out.printf("Min:%d, Max:%d", min, max);
		
	}

}
