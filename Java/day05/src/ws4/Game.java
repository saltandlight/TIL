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
		
		//위 테두리 할당
		for(int j=0;j<8;j++)
		  board[0][j]=r.nextInt(100)+1;
		
		//오른쪽 테두리 할당
		for(int i=0;i<8;i++) {
			board[i][7]=r.nextInt(100)+1;
		}

		//아래쪽 테두리 할당
		for(int j=0;j<7;j++) {
			board[7][j]=r.nextInt(100)+1;
		}
		
		//왼쪽 테두리 할당
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
		//각 플레이어가 주사위를 한 번 씩 던짐.(1~6 중 난수)
		while(true) {
			//plyaer1
			System.out.println("player1: 주사위를 굴려주세요");
			jusawi=scan.nextInt();
			
			if(jusawi>6 || jusawi<0) {
				System.out.println("숫자가 잘못되었습니다.\n프로그램을 다시 실행해주세요~");
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
			
			//소유주의 땅을 밟았는지 검사 (밟았으면 벌금, 아니면 살 것인지 물어본다.)
			if(check[player1_x][player1_y]==true) {
				System.out.println("소유주의 땅을 밟았습니다!!!!!!! ");
				player1 = player1- board[player1_x][player1_y]*2;
				System.out.println("player1의 잔여금액: "+player1);
			}
			else {
			//플레이어가 땅을 살 것인지 결정~
				System.out.println("땅을 사시겠습니까?(Y/N)");
				String ans1=scan.next();
				if(ans1.contentEquals("Y")) {
					check[player1_x][player1_y]=true;
					player1 -= board[player1_x][player1_y];
					System.out.println("땅 가격: "+board[player1_x][player1_y]);
					System.out.println("땅 위치:"+player1_x+" "+player1_y);
					System.out.println("땅을 구매하셨습니다~");
					System.out.println("plyaer1의 잔여금액: "+player1);
				}
			}
			if(player1 <= 0) {
				System.out.println("player1 이 패배했습니다.");
				return;
			}
			//player2
			System.out.println("player2: 주사위를 굴려주세요");
			jusawi=scan.nextInt();
			if(jusawi>6 || jusawi<0) {
				System.out.println("숫자가 잘못되었습니다.\n프로그램을 다시 실행해주세요~");
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
				System.out.println("소유주의 땅을 밟았습니다!!!!!!! ");
				player2 = player2- board[player2_x][player2_y]*2;
				System.out.println("player2의 잔여금액: "+player2);
			} 
			else {
			//플레이어가 땅을 살 것인지 결정~
				System.out.println("땅을 사시겠습니까?(Y/N)");
				String ans2=scan.next();
				if(ans2.contentEquals("Y")) {
					check[player2_x][player2_y]=true;
					player2 -= board[player2_x][player2_y];
					System.out.println("땅 가격: "+board[player2_x][player2_y]);
					System.out.println("땅 위치:"+player2_x+" "+player2_y);
					System.out.println("땅을 구매하셨습니다~");
					System.out.println("plyaer2의 잔여금액: "+player1);
				}
			}
		
			if(player2 <=0) {
				System.out.println("player2 이 패배했습니다.");
				return;
			}
		}	
	}
}
