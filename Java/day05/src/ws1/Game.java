package ws1;

import java.util.Random;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		/*1. 랜덤 4자리 숫자 받기 (0~9) 중복 x
		  2. 사용자가 4자리 숫자 입력
		  3. 숫자가 있으면 ball, 자리도 같으면 strike
		  4. 아예 안맞으면 out
		  5. 완전히 일치하게 되면 홈런으로 게임 끝.

       ex) 랜덤숫자 : 1639
		    사용자숫자 : 2698 => 1S1B
		    사용자숫자 : 4578 => out
		    사용자숫자 : 2439 => 2S
		    사용자숫자 : 2461 => 2B*/
		boolean flag=false;
		int strike=0, ball=0;
		int[] com=new int[5];
		boolean[] check=new boolean[10];
		int[] user=new int[5];
		Random r= new Random();
		Scanner scan= new Scanner(System.in);
		//1. com[4]를 받기(랜덤으로, 중복 없이)
		for(int i=0;i<4;i++) {
			int num=r.nextInt(10);
			if(check[num]==false) {
				check[num]=true;
				com[i]=num;
			}
			else {
				i--;
				continue;
			}
		}
//		for(int i=0;i<4;i++) {
//			System.out.print(com[i]+" ");
//		}
//		System.out.println();
		//2. user[4] 입력받기
	
		
		
		while(flag==false) {
			strike=ball=0;
			System.out.println("서로 다른 4개의 숫자를 입력해주세요~:)");
			for(int i=0;i<4;i++) {
				user[i]=scan.nextInt();
			}
			//3. 숫자가 있는데 자리가 같지 않으면 -> ball++
		    //	  숫자가 있고 자리가 같은지 -> strike++
			//4. 아예 숫자가 없으면 out
			//5. 완전히 일치하게 되면 홈런으로 게임 끝=모든 수의 값이 일치하고 자리수도 같으면 게임 종료
			//   strike=4조건
			for(int i=0;i<4;i++) {
				for(int j=0;j<4;j++) {
					if(com[i]==user[j]) {
						if(i==j) strike++;
						else ball++;
					}
				}
			}
			//숫자가 아예 없으면
			if(strike==0 && ball==0) System.out.println("out");
			else {
				if(strike==4) System.out.println("homerun!");
				else if(ball==0)
					System.out.println(ball+"B");
				else
					System.out.println(strike+"S"+ball+"B");
			}
//			System.out.println(strike+" "+ball);
			
			if(strike==4) flag=true;
		}
		 
	}

}
