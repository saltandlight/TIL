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
			// ����� �� �Է¹ޱ�
			System.out.print("Input your number:");
			str=sc.next();
			//q�Է� �� ������
			if(str.contentEquals("q")) {
				sc.close();
				break;
			}
			user=Integer.parseInt(str);
			if(user>3 || user<1) {
				System.out.println("�Է°��� ���� ���� �����ϴ�.");
				continue;
			}
			// ��ǻ�� �� �������� ����
			com=r.nextInt(3)+1;
			System.out.println("Computer Number:"+com);
			// �̱� ����-> vict_cnt++;
			if(user-com==1 || user-com==-2) vict_cnt++;
			//fin_cnt����
			fin_cnt++;
		}
			System.out.printf("%d %d", fin_cnt, vict_cnt);
		
	}

}
