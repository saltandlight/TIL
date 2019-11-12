package day02;

import java.util.Scanner;

public class Scanner1 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in); 
		//자바가 제공해주는 라이브러리(앞 글자가 대문자)
		//임의의 값을 받아들이는 것이 스캐너
		
		System.out.println("Input Number...?");
        String data= sc.nextLine();
        int intNum = Integer.parseInt(data);
        System.out.println(intNum*100);
        sc.close();
	}
}
