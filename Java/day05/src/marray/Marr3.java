package marray;

import java.util.Random;

public class Marr3 {

	public static void main(String[] args) {
		//2���� �迭�� �̿��Ͽ�
		//5���� �л��� 4���� ������ 
		//�����Ͽ� ����Ͻÿ�.(�����ϰ� �ֱ�;1~100 ����)
		int score[][]=new int[5][4];
		
		Random r = new Random();
		
		for(int i=0;i<score.length;i++) {
			for(int j=0;j<score[i].length;j++) {
				score[i][j]=r.nextInt(100)+1;
			}
		}
		
		for(int temp[]:score) {
			for(int data:temp) {
				System.out.print(data+" ");
			}System.out.println();
		}
		
		//�л��� ����� ���
		System.out.println("\n�л��� ���------------");
		int st_mean=0;
		int sum=0;
		int fin_sum=0;
		for(int i=0;i<score.length;i++) {
			for(int j=0;j<score[i].length;j++) {
				sum += score[i][j];
				fin_sum+=score[i][j];
			}st_mean=sum/5;
			 System.out.println((i+1)+"�� �л��� �������:"+st_mean);
			 sum=0;
		}
		
	
		//���� ����� ���
		System.out.println("\n���� ���------------");
		int sub_mean=0;
		sum=0;
		for(int j=0;j<4;j++) {
			for(int i=0;i<5;i++) {
				sum+=score[i][j];
			}sub_mean=sum/4; System.out.println((j+1)+"�� ���� �������:"+sub_mean); sum=0;
		}
		

			
		//��ü ����� ���
		System.out.println("\n��ü ���--------------");
		int tot_mean=fin_sum/(5*4);
		System.out.println("��ü ���:"+tot_mean);

	}

}
