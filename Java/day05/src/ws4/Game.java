package ws4;


import java.util.Random;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		int player1=5000, player2=5000;
		int jusawi=0;
		int player1_x, player1_y;
		int player2_x, player2_y;
		player1_x=player1_y=player2_x=player2_y=0;
		int[][] board = new int[8][8];
		boolean[][] check=new boolean[8][8];
		Random r= new Random();
		
		//�� �׵θ� �Ҵ�
		for(int j=0;j<8;j++)
		  board[0][j]=r.nextInt(100)+1;
		
		//������ �׵θ� �Ҵ�
		for(int i=0;i<8;i++) {
			board[i][7]=r.nextInt(100)+1;
		}

		//�Ʒ��� �׵θ� �Ҵ�
		for(int j=0;j<7;j++) {
			board[7][j]=r.nextInt(100)+1;
		}
		
		//���� �׵θ� �Ҵ�
		for(int i=1;i<7;i++) {
			board[i][0]=r.nextInt(100)+1;
		}
		
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		int num=0;
		Scanner scan = new Scanner(System.in);
		//�� �÷��̾ �ֻ����� �� �� �� ����.(1~6 �� ����)
		while(true) {
			//plyaer1
			System.out.println("player1: �ֻ����� �����ּ���");
			jusawi=scan.nextInt();
			
			if(jusawi>6 || jusawi<0) {
				System.out.println("���ڰ� �߸��Ǿ����ϴ�.\n���α׷��� �ٽ� �������ּ���~");
				return;
			}
			if(player1_x==0&&player1_y<8) {
				num=player1_y+jusawi;
				if(num<8)	player1_y=num;
				else {
					player1_y=7; player1_x=num-7;
				}
			}
			else if(player1_y==7) {
				num=player1_x+jusawi;
				if(num<8) {player1_x=num;}
				else {
					player1_x=7; 
					player1_y=7-(num-7);
				}
			}
			else if(player1_x==7) { 
				num=player1_y-jusawi;
				if(num>=0) player1_y=num;
				else {
					player1_y=0; player1_x=7+num;
				}
			}
			else if(player1_y==0) {
				num=player1_x-jusawi;
				if(num>=0) player1_x=num;
				else {
					player1_x=0;player1_y=-num; 
				}
			}
			
			//�������� ���� ��Ҵ��� �˻� (������� ����, �ƴϸ� �� ������ �����.)
			if(check[player1_x][player1_y]==true) {
				System.out.println("�������� ���� ��ҽ��ϴ�!!!!!!! ");
				player1 = player1- board[player1_x][player1_y]*2;
				System.out.println("player1�� �ܿ��ݾ�: "+player1);
			}
			else {
			//�÷��̾ ���� �� ������ ����~
				System.out.println("���� ��ðڽ��ϱ�?(Y/N)");
				String ans1=scan.next();
				if(ans1.contentEquals("Y")) {
					check[player1_x][player1_y]=true;
					player1 -= board[player1_x][player1_y];
					System.out.println("�� ����: "+board[player1_x][player1_y]);
					System.out.println("�� ��ġ:"+player1_x+" "+player1_y);
					System.out.println("���� �����ϼ̽��ϴ�~");
					System.out.println("plyaer1�� �ܿ��ݾ�: "+player1);
				}
			}
			if(player1 <= 0) {
				System.out.println("player1 �� �й��߽��ϴ�.");
				return;
			}
			//player2
			System.out.println("player2: �ֻ����� �����ּ���");
			jusawi=scan.nextInt();
			if(jusawi>6 || jusawi<0) {
				System.out.println("���ڰ� �߸��Ǿ����ϴ�.\n���α׷��� �ٽ� �������ּ���~");
				return;
			}
			if(player2_x==0&&player2_y<8) {
				num=player2_y+jusawi;
				if(num<8)	player2_y=num;
				else {
					player2_y=7; player2_x=num-7;
				}
			}else if(player2_y==7) {
				num=player2_x+jusawi;
				if(num<8) {player2_x=num;}
				else {
					player2_x=7; 
					player2_y=7-(num-7);
				}
			}else if(player2_x==7) { 
				num=player2_y-jusawi;
				if(num>=0) player2_y=num;
				else {
					player2_y=0; player2_x=7+num;
				}
			}else if(player2_y==0) {
				num=player2_x-jusawi;
				if(num>=0) player2_x=num;
				else {
					player2_x=0;player2_y=-num; 
				}
			}
			if(check[player2_x][player2_y]==true) {
				System.out.println("�������� ���� ��ҽ��ϴ�!!!!!!! ");
				player2 = player2- board[player2_x][player2_y]*2;
				System.out.println("player2�� �ܿ��ݾ�: "+player2);
			} 
			else {
			//�÷��̾ ���� �� ������ ����~
				System.out.println("���� ��ðڽ��ϱ�?(Y/N)");
				String ans2=scan.next();
				if(ans2.contentEquals("Y")) {
					check[player2_x][player2_y]=true;
					player2 -= board[player2_x][player2_y];
					System.out.println("�� ����: "+board[player2_x][player2_y]);
					System.out.println("�� ��ġ:"+player2_x+" "+player2_y);
					System.out.println("���� �����ϼ̽��ϴ�~");
					System.out.println("plyaer2�� �ܿ��ݾ�: "+player1);
				}
			}
		
			if(player2 <=0) {
				System.out.println("player2 �� �й��߽��ϴ�.");
				return;
			}
		}	
	}
}
