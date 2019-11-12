package ifswhitch;

import java.util.Random;
import java.util.Scanner;

public class Game1 {

	public static void main(String[] args) {
//		//1. Math.random
//		int num = 0;
//		//Math는 임포트를 안 해도 됨.
//		num=(int)(Math.random()*10)+1;  //1~10
//		System.out.println(num);
//		//2. Random
//		Random r= new Random();
//		int num2=0;
//		num2=r.nextInt(3)+1; //1~3까지 
//		//컴퓨터는 1 2 3 중에 하나를 낸다.
		//1. 사용자는 1~3값을 입력한다.
		//2. 1~3 이외의 문자가 들어오면 "안녕" 이라고 출력 후 프로그램 중료
		//3. 컴퓨터는 1~3의 숫자를 랜덤하게 만든다.
		//4. 사용자 숫자와 비교하여 이겼는지 졌는지 출력한다.
		Scanner sc=new Scanner(System.in);
		int user=0;
		System.out.println("Input 1 Number!");
		user=sc.nextInt();
		
		if(user<1 || user>3) {
			System.out.println("안녕");
			return;
		}
		
//		int com=0;
//		com=(int)(Math.random()*3)+1;
//		System.out.println(com);
		Random r=new Random();
		int com=0;
		com=r.nextInt(3)+1;
		System.out.println(com);
		
		int res=user-com;
		if(res==0) {
			System.out.println("비겼습니다.");
			return;
		}
		if(res==-1 || res==2) {
			System.out.println("졌습니다.");
			return;
		}
		System.out.println("이겼습니다.");
				

	}

}
