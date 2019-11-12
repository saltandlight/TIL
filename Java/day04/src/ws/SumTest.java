package ws;

import java.util.Random;

public class SumTest {

	public static void main(String[] args) {
		/*1. 100���� ������ �迭�� 1~100������ ���ڸ� ������ �߻� ��Ų��. �ߺ� ������� �ʴ´�. 
		  2. ¦�� ��°�� �ִ� �����鸸 50���� �迭�� ����
		  3. Ȧ�� ��°�� �ִ� �����鸸 50���� �迭�� ���� 
		  4. ¦�� ��° �迭�� ù��° ���ڿ� Ȧ�� ��° �迭�� ������ ���ڸ� �ջ�, 
		       �ٽ� ¦�� ��° �ι�° ���ڴ� Ȧ�� ��° �迭�� ���������� �ι�° ���ڿ��� �ջ� 
		       �̷������� �ջ��� ����� ��� �Ͻÿ� 
		 */
		
		//�ʿ��� �迭 num[], even[], odd[], sum[]
		final int MAX=60;
		
		int [] num=new int[100];  //���� �߻�
		int [] even=new int[MAX]; //¦�� 
		int [] odd=new int[MAX];  //Ȧ��
		int [] sum=new int[MAX];  //���콺 ��
		boolean [] check=new boolean[110];
		
		for(int i=0;i<100;i++) {
			check[i]=false;
		}
       //1. 100���� ������ �迭�� 1~100������ ���ڸ� ������ �߻� ��Ų��. �ߺ� ������� �ʴ´�. 
		Random r= new Random();
		for(int i=0;i<100;i++) {
			num[i]=r.nextInt(100)+1;
			if(check[num[i]]==true) {
				i--;
				continue;
			}
			else check[num[i]]=true;
		}
		
		for(int i=0;i<100;i++) {
			for(int j=i+1;j<100;j++) {
				if(num[i]==num[j])
					System.out.println("�ѹ��� ���� �ߺ��˴ϴ�.");
			}
		}
		//	2. ¦�� ��°�� �ִ� �����鸸 50���� �迭�� ����
		//  3. Ȧ�� ��°�� �ִ� �����鸸 50���� �迭�� ���� 
		int odd_idx, even_idx;
		odd_idx=even_idx=0;
		for(int i=0;i<100;i++) {
		  if(num[i]%2==0) {
			  even[even_idx++]=num[i];
		  }
		  else odd[odd_idx++]=num[i];
		}
		
	
		/*4. ¦�� ��° �迭�� ù��° ���ڿ� Ȧ�� ��° �迭�� ������ ���ڸ� �ջ�, 
		       �ٽ� ¦�� ��° �ι�° ���ڴ� Ȧ�� ��° �迭�� ���������� �ι�° ���ڿ��� �ջ� 
		       �̷������� �ջ��� ����� ��� �Ͻÿ� */
		//¦�� �迭 for ���� 0~even_idx-1
		   //Ȧ�� �迭 odd_idx-1~0
		int k=0;
		for(int i=0, j=odd_idx-1;i<even_idx;i++,j--) {
			sum[k]=even[i]+odd[j];
			System.out.println(" "+sum[k++]+" ");
		}
		
		
		

	}
}



