package ws;

import java.util.Random;

public class SumTest {

	public static void main(String[] args) {
		/*1. 100개의 정수형 배열에 1~100까지의 숫자를 난수로 발생 시킨다. 중복 허용하지 않는다. 
		  2. 짝수 번째에 있는 정수들만 50개의 배열에 저장
		  3. 홀수 번째에 있는 정수들만 50개의 배열에 저장 
		  4. 짝수 번째 배열의 첫번째 숫자와 홀수 번째 배열의 마지막 숫자를 합산, 
		       다시 짝수 번째 두번째 숫자는 홀수 번째 배열의 마지막에서 두번째 숫자와의 합산 
		       이런식으로 합산한 결과를 출력 하시오 
		 */
		
		//필요한 배열 num[], even[], odd[], sum[]
		final int MAX=60;
		
		int [] num=new int[100];  //난수 발생
		int [] even=new int[MAX]; //짝수 
		int [] odd=new int[MAX];  //홀수
		int [] sum=new int[MAX];  //가우스 합
		boolean [] check=new boolean[110];
		
		for(int i=0;i<100;i++) {
			check[i]=false;
		}
       //1. 100개의 정수형 배열에 1~100까지의 숫자를 난수로 발생 시킨다. 중복 허용하지 않는다. 
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
					System.out.println("넘버의 값이 중복됩니다.");
			}
		}
		//	2. 짝수 번째에 있는 정수들만 50개의 배열에 저장
		//  3. 홀수 번째에 있는 정수들만 50개의 배열에 저장 
		int odd_idx, even_idx;
		odd_idx=even_idx=0;
		for(int i=0;i<100;i++) {
		  if(num[i]%2==0) {
			  even[even_idx++]=num[i];
		  }
		  else odd[odd_idx++]=num[i];
		}
		
	
		/*4. 짝수 번째 배열의 첫번째 숫자와 홀수 번째 배열의 마지막 숫자를 합산, 
		       다시 짝수 번째 두번째 숫자는 홀수 번째 배열의 마지막에서 두번째 숫자와의 합산 
		       이런식으로 합산한 결과를 출력 하시오 */
		//짝수 배열 for 문은 0~even_idx-1
		   //홀수 배열 odd_idx-1~0
		int k=0;
		for(int i=0, j=odd_idx-1;i<even_idx;i++,j--) {
			sum[k]=even[i]+odd[j];
			System.out.println(" "+sum[k++]+" ");
		}
		
		
		

	}
}



