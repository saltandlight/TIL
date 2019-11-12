package marray;

import java.util.Random;

public class Marr4 {

	public static void main(String[] args) {
		String sa[][]=new String[2][3];
		
		Random r = new Random();
		
		for(int i=0;i<sa.length;i++) {
			for(int j=0;j<sa[i].length;j++) {
				sa[i][j]=i+""+j;
				System.out.print(sa[i][j]+"\t");
			}
			System.out.println();
		}
		
	}

}
