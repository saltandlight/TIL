package array1;

import java.util.Arrays;
import java.util.Random;

public class Arr4 {

	public static void main(String[] args) {
		int a []=new int[100];
		//1~4������ ���ڸ� �����ϰ� �迭�� �Է�
		//�հ� ����� ���Ͻÿ�
		Random r = new Random();
		for(int i=0;i<a.length;i++) {
			a[i]=r.nextInt(4)+1;
		}
		System.out.println(Arrays.toString(a));
		
		int count[] = new int[5];
		
		// ��ǥ ����� count �迭�� �ջ��Ͻÿ�.
		for(int i=0;i<a.length;i++)
			count[a[i]]++;
		
		for(int i=0;i<count.length;i++) {
			if(count[i]!=0) System.out.println(i+":"+count[i]+" ");
		}
	}

}
