package array1;

import java.util.Arrays;

public class Arr2 {

	public static void main(String[] args) {
		int a[]=new int[3];
		a[0]=1;
		a[1]=5;
		a[2]=3;
		
		int b[]= {1,5,3};
		int c[]= {6,7,8,9,4};
		
		for(int i=0;i<b.length;i++)
			c[i]=b[i];
		
		System.out.println(Arrays.toString(c));
		
		System.arraycopy(b, 1, c, 3, 2);
		//b의 첫번째 자리를 c의 세번째 자리에 대입하는데 길이가 2
		
		System.out.println(Arrays.toString(c));
	}

}
