package day02;

import java.util.Scanner;

public class Operator3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String data = sc.next();
		char c = data.charAt(0); //0��°�� ���� ���� ĳ���ͷ� �ٲ����
		if(('a'<=c && c<='z') || ('A'<=c && c<='Z')) {
			System.out.println("���� �Դϴ�.");
			sc.close();
			return;
		}
		c++;
		System.out.println(c);
		sc.close();
	}

}
