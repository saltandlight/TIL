package ifswhitch;

import java.util.Random;
import java.util.Scanner;

public class Game1 {

	public static void main(String[] args) {
//		//1. Math.random
//		int num = 0;
//		//Math�� ����Ʈ�� �� �ص� ��.
//		num=(int)(Math.random()*10)+1;  //1~10
//		System.out.println(num);
//		//2. Random
//		Random r= new Random();
//		int num2=0;
//		num2=r.nextInt(3)+1; //1~3���� 
//		//��ǻ�ʹ� 1 2 3 �߿� �ϳ��� ����.
		//1. ����ڴ� 1~3���� �Է��Ѵ�.
		//2. 1~3 �̿��� ���ڰ� ������ "�ȳ�" �̶�� ��� �� ���α׷� �߷�
		//3. ��ǻ�ʹ� 1~3�� ���ڸ� �����ϰ� �����.
		//4. ����� ���ڿ� ���Ͽ� �̰���� ������ ����Ѵ�.
		Scanner sc=new Scanner(System.in);
		int user=0;
		System.out.println("Input 1 Number!");
		user=sc.nextInt();
		
		if(user<1 || user>3) {
			System.out.println("�ȳ�");
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
			System.out.println("�����ϴ�.");
			return;
		}
		if(res==-1 || res==2) {
			System.out.println("�����ϴ�.");
			return;
		}
		System.out.println("�̰���ϴ�.");
				

	}

}
