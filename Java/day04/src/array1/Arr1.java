package array1;

import java.util.Random;

public class Arr1 {

	public static void main(String[] args) {
//		int i = 10;
		//�迭�� reference type int�� �⺻���� 0�̹Ƿ� 0���� ä����.
		
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
//		//�ؿ� �ִ� �ִ� �� �� ���Ҵ����� ��. �׷��� �ƹ� �������� ����� ���� ����.
//		for(int temp:a) {//a�ȿ� �ִ� ��Ƽ������ ������ŭ ������.
//			System.out.println(temp);
//		}
	}

}
