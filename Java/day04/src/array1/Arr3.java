package array1;

import java.util.Arrays;
import java.util.Random;

public class Arr3 {

	public static void main(String[] args) {
		int a []=new int[30];
		int sum=0;
		float avg=0f;
		//10~99까지의 숫자를 랜덤하게 배열에 입력-> 0~89까지 +10
		//합과 평균을 구하시오.
		Random r = new Random();

		for(int i=0;i<a.length;i++) {
			a[i]=r.nextInt(90)+10;
			sum+=a[i];
		}
		avg=(float)sum/(float)a.length;
		System.out.println(Arrays.toString(a));
		System.out.println(sum+" "+avg);
		System.out.println("-----------------------");
		
		//최댓갑솨 최소값을 출력하시오.
		int max, min;
		max=a[0]; min=a[0];
       for(int i=1;i<a.length;i++) {
			if(max < a[i]) max=a[i];
			if(min > a[i]) min=a[i];
		}
		
		System.out.println(max+" "+min);
		System.out.println("-----------------------");
		//작은 수부터 정렬하시오.
		int temp=0;
		for(int i=0;i<a.length;i++) {
			for(int j=i+1;j<a.length;j++) {
				if(a[i]>a[j]) {
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(a));
		System.out.println("-----------------------");
		//큰 수부터 정렬하시오.
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a.length-1-i;j++) {
				if(a[j]<a[j+1]) {
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(a));
		//배열에 있는 숫자들의 합을 구하기
		int [] count=new int[100];
		
		for(int j=0;j<a.length;j++) {
			count[a[j]]++;
		}
		
		for(int j=0;j<90;j++) {
			if(count[j]!=0) {
				System.out.println(j+":"+count[j]);
			}
		}
		
	}

}
