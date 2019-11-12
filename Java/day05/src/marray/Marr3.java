package marray;

import java.util.Random;

public class Marr3 {

	public static void main(String[] args) {
		//2차원 배열을 이용하여
		//5명의 학생의 4과목 점수를 
		//생성하여 출력하시오.(랜덤하게 넣기;1~100 사이)
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
		
		//학생별 평균을 출력
		System.out.println("\n학생별 평균------------");
		int st_mean=0;
		int sum=0;
		int fin_sum=0;
		for(int i=0;i<score.length;i++) {
			for(int j=0;j<score[i].length;j++) {
				sum += score[i][j];
				fin_sum+=score[i][j];
			}st_mean=sum/5;
			 System.out.println((i+1)+"번 학생의 평균점수:"+st_mean);
			 sum=0;
		}
		
	
		//과목별 평균을 출력
		System.out.println("\n과목별 평균------------");
		int sub_mean=0;
		sum=0;
		for(int j=0;j<4;j++) {
			for(int i=0;i<5;i++) {
				sum+=score[i][j];
			}sub_mean=sum/4; System.out.println((j+1)+"번 과목 평균점수:"+sub_mean); sum=0;
		}
		

			
		//전체 평균을 출력
		System.out.println("\n전체 평균--------------");
		int tot_mean=fin_sum/(5*4);
		System.out.println("전체 평균:"+tot_mean);

	}

}
