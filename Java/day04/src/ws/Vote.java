package ws;

import java.util.Random;

public class Vote {
  
	public static void main(String[] args) {
		final int MAX=50;
		int [] arr=new int[60];		
		int [] cnt=new int[6];
		Random r= new Random();
		
		//arr�� 1~5������ �� �������� �ޱ�(50����ŭ)
		for(int i=0;i<MAX;i++) {
			arr[i]=r.nextInt(5)+1;
			cnt[arr[i]]++;
		}
		
		
		int min=100; int max=0;
		int min_idx, max_idx;
		min_idx=max_idx=0;
		
		for(int i=1;i<6;i++) {
			System.out.print(cnt[i]+" ");
			if(min>cnt[i]) {
				min=cnt[i]; min_idx=i;
			}
			if(max<cnt[i]) {
				max=cnt[i]; max_idx=i;
			}
		}
		System.out.println("\n���� ��ǥ�� ���� ���� �ĺ�: "+max_idx);
		System.out.println("���� ��ǥ�� ���� ���� �ĺ�: "+min_idx);
		
		//���� ǥ ���� �޴� ������ ����
		int temp=0;
		for(int i=1;i<6;i++) {
			for(int j=i+1;j<6;j++) {
				if(cnt[i]<cnt[j]) {
					temp=cnt[i];
					cnt[i]=cnt[j];
					cnt[j]=temp;
				}
			}
		}
		


		//cnt�迭 �̿�
		for(int i=1;i<6;i++) {
		 System.out.print(cnt[i]+"  ");
		}
		System.out.println();
		
		//���� ǥ�� ���� �޴� ������ ����
		for(int i=0;i<6;i++) {
			for(int j=i+1;j<6;j++) {
				if(cnt[i]>cnt[j]) {
					temp=cnt[i];
					cnt[i]=cnt[j];
					cnt[j]=temp;
				}
			}
		}
		//cnt�迭 �̿�
		for(int i=1;i<6;i++)
			System.out.print(cnt[i]+"  ");

	
	}

}
