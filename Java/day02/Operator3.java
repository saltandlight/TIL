package day02;

import java.util.Scanner;

public class Operator3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String data = sc.next();
		char c = data.charAt(0); //0번째의 값을 빼서 캐릭터로 바꿔줘라
		if(('a'<=c && c<='z') || ('A'<=c && c<='Z')) {
			System.out.println("문자 입니다.");
			sc.close();
			return;
		}
		c++;
		System.out.println(c);
		sc.close();
	}

}
