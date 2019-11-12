package ws1;

import java.util.Random;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		/*1. ���� 4�ڸ� ���� �ޱ� (0~9) �ߺ� x
		  2. ����ڰ� 4�ڸ� ���� �Է�
		  3. ���ڰ� ������ ball, �ڸ��� ������ strike
		  4. �ƿ� �ȸ����� out
		  5. ������ ��ġ�ϰ� �Ǹ� Ȩ������ ���� ��.

       ex) �������� : 1639
		    ����ڼ��� : 2698 => 1S1B
		    ����ڼ��� : 4578 => out
		    ����ڼ��� : 2439 => 2S
		    ����ڼ��� : 2461 => 2B*/
		boolean flag=false;
		int strike=0, ball=0;
		int[] com=new int[5];
		boolean[] check=new boolean[10];
		int[] user=new int[5];
		Random r= new Random();
		Scanner scan= new Scanner(System.in);
		//1. com[4]�� �ޱ�(��������, �ߺ� ����)
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
		//2. user[4] �Է¹ޱ�
	
		
		
		while(flag==false) {
			strike=ball=0;
			System.out.println("���� �ٸ� 4���� ���ڸ� �Է����ּ���~:)");
			for(int i=0;i<4;i++) {
				user[i]=scan.nextInt();
			}
			//3. ���ڰ� �ִµ� �ڸ��� ���� ������ -> ball++
		    //	  ���ڰ� �ְ� �ڸ��� ������ -> strike++
			//4. �ƿ� ���ڰ� ������ out
			//5. ������ ��ġ�ϰ� �Ǹ� Ȩ������ ���� ��=��� ���� ���� ��ġ�ϰ� �ڸ����� ������ ���� ����
			//   strike=4����
			for(int i=0;i<4;i++) {
				for(int j=0;j<4;j++) {
					if(com[i]==user[j]) {
						if(i==j) strike++;
						else ball++;
					}
				}
			}
			//���ڰ� �ƿ� ������
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
