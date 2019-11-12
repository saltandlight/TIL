package array1;

import java.util.Random;

public class Arr1 {

	public static void main(String[] args) {
//		int i = 10;
		//배열도 reference type int의 기본값이 0이므로 0으로 채워짐.
		
		int a[] = new int[6];
		

		Random r=new Random();
		boolean flag=false;
		for(int in=0;in<a.length;in++) {
			a[in]=r.nextInt(9)+1;
			for(int j=0;j<in;j++) {
				while(a[in]==a[j])  a[in]=r.nextInt(9)+1;
			}
		}
		for(int j=0;j<a.length;j++) {
			System.out.println(a[j]);
		}
//		
//		System.out.println(a);
//		System.out.println(a.length);
//		
//
//		
//		for(int ind=0;ind<a.length;ind++) {
//			System.out.println(a[ind]);
//		}
//		
////		System.out.println(ind);
//		//밑에 있는 애는 몇 번 돌았는지는 모름. 그러나 아무 생각없이 출력할 떄는 편함.
//		for(int temp:a) {//a안에 있는 인티저값을 개수만큼 빼내라.
//			System.out.println(temp);
//		}
	}

}
