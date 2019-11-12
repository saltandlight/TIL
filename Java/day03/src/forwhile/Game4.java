package forwhile;

import java.util.Random;
import java.util.Scanner;

public class Game4 {
	public static void main(String[] args) {
		int vict_cnt, fin_cnt, user, com;
		String str="";
		vict_cnt=fin_cnt=0;
		Scanner sc=new Scanner(System.in);
		Random r=new Random();
		while(true) {
			// 사용자 값 입력받기
			System.out.print("Input your number:");
			str=sc.next();
			//q입력 시 나가기
			if(str.contentEquals("q")) {
				sc.close();
				break;
			}
			user=Integer.parseInt(str);
			if(user>3 || user<1) {
				System.out.println("입력값이 범위 내에 없습니다.");
				continue;
			}
			// 컴퓨터 값 랜덤으로 생성
			com=r.nextInt(3)+1;
			System.out.println("Computer Number:"+com);
			// 이긴 조건-> vict_cnt++;
			if(user-com==1 || user-com==-2) vict_cnt++;
			//fin_cnt증가
			fin_cnt++;
		}
			System.out.printf("%d %d", fin_cnt, vict_cnt);
		
	}

}
