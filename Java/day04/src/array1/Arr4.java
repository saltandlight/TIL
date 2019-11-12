package array1;

import java.util.Arrays;
import java.util.Random;

public class Arr4 {

	public static void main(String[] args) {
		int a []=new int[100];
		//1~4까지의 숫자를 랜덤하게 배열에 입력
		//합과 평균을 구하시오
		Random r = new Random();
		for(int i=0;i<a.length;i++) {
			a[i]=r.nextInt(4)+1;
		}
		System.out.println(Arrays.toString(a));
		
		int count[] = new int[5];
		
		// 투표 결과를 count 배열에 합산하시오.
		for(int i=0;i<a.length;i++)
			count[a[i]]++;
		
		for(int i=0;i<count.length;i++) {
			if(count[i]!=0) System.out.println(i+":"+count[i]+" ");
		}
	}

}
