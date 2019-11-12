package ws;

import java.util.Random;

public class Vote {
  
	public static void main(String[] args) {
		final int MAX=50;
		int [] arr=new int[60];		
		int [] cnt=new int[6];
		Random r= new Random();
		
		//arr에 1~5범위의 값 랜덤으로 받기(50개만큼)
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
		System.out.println("\n가장 투표를 많이 받은 후보: "+max_idx);
		System.out.println("가장 투표를 적게 받은 후보: "+min_idx);
		
		//가장 표 많이 받는 순으로 정렬
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
		


		//cnt배열 이용
		for(int i=1;i<6;i++) {
		 System.out.print(cnt[i]+"  ");
		}
		System.out.println();
		
		//가장 표를 적게 받는 순으로 정렬
		for(int i=0;i<6;i++) {
			for(int j=i+1;j<6;j++) {
				if(cnt[i]>cnt[j]) {
					temp=cnt[i];
					cnt[i]=cnt[j];
					cnt[j]=temp;
				}
			}
		}
		//cnt배열 이용
		for(int i=1;i<6;i++)
			System.out.print(cnt[i]+"  ");

	
	}

}
