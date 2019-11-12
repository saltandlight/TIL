package marray;

import java.util.Random;

public class Marr5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] ma = new int[5][5];
		
		Random r = new Random();
		
		for(int i=0;i<ma.length;i++) {
			for(int j=0;j<ma[i].length;j++) {
				ma[i][j]=r.nextInt(100)+1;
			}
		}
		
		// 1~100까지의 숫자가 있다. 
		//입력 받은 값까지 출력하시오.
		int a = 56;
		out:
		for(int i=0;i<ma.length;i++) {
			for(int j=0;j<ma[i].length;j++) {
				if(ma[i][j]>=56) break out;
				System.out.print(ma[i][j]+" ");
			}
			System.out.println();
		}
	
		
		
		
	}
}
