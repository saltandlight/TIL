package ws;

import java.util.Arrays;
import java.util.Scanner;

public class GradeTest {

	public static void main(String[] args) {
		int[] sub = new int[4];
		Scanner scan = new Scanner(System.in);
		System.out.println("���� ������ �������� �Է����ּ���~\n���� ���� ���� ����");
		for(int i=0;i<sub.length;i++) {
			sub[i]=scan.nextInt();
		}
		//��ü ����
		Grade grd=new Grade(sub);
		//1. ���� ��� �Ͻÿ�
		System.out.println("�������� ��:"+grd.sum());
//		2. ����� ��� �Ͻÿ�
		System.out.println("�������� ���:"+grd.avg());
//		3. ����� 90�� �̻��̸� A, 80�� �̻��̸� B, 70�� �̻��̸� C, 60�� �̻��̸� D, ���ϸ� F
		System.out.println("���� ����� ����:"+grd.prc_grade());
//		4. �ְ����� ������ ��� �Ͻÿ�
		System.out.println("�ְ����� ����:"+grd.prc_max());
		//5.�������� ������ ����Ͻÿ�
		System.out.println("�������� ����:"+grd.prc_min());
//		6. �������� ���� 
		System.out.println(Arrays.toString(grd.asort()));
//		7. �������� ����
		System.out.println(Arrays.toString(grd.dsort()));
		
	}

}
