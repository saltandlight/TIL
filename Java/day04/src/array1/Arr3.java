package array1;

import java.util.Arrays;
import java.util.Random;

public class Arr3 {

	public static void main(String[] args) {
		int a []=new int[30];
		int sum=0;
		float avg=0f;
		//10~99������ ���ڸ� �����ϰ� �迭�� �Է�-> 0~89���� +10
		//�հ� ����� ���Ͻÿ�.
		Random r = new Random();

		for(int i=0;i<a.length;i++) {
			a[i]=r.nextInt(90)+10;
			sum+=a[i];
		}
		avg=(float)sum/(float)a.length;
		System.out.println(Arrays.toString(a));
		System.out.println(sum+" "+avg);
		System.out.println("-----------------------");
		
		//�ִ񰩼� �ּҰ��� ����Ͻÿ�.
		int max, min;
		max=a[0]; min=a[0];
       for(int i=1;i<a.length;i++) {
			if(max < a[i]) max=a[i];
			if(min > a[i]) min=a[i];
		}
		
		System.out.println(max+" "+min);
		System.out.println("-----------------------");
		//���� ������ �����Ͻÿ�.
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
		//ū ������ �����Ͻÿ�.
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
		//�迭�� �ִ� ���ڵ��� ���� ���ϱ�
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
