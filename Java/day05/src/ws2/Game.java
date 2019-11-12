package ws2;

import java.util.Random;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		/*ws2.Game.java
		[ 캔디크러쉬 ]
		1. 9 x 9 캔디판 생성
		2. 캔디판에 ABCDE와 같이 서로 다른 종류 4개 이상을 사용해서 랜덤으로 캔디판에 넣는다.
		3. 게임 시작, 사용자가 판을 보고 바꾸고 싶어하는 알파벳의 좌표를 선택하고, 그 알파벳의 이웃 알파벳의 좌표를
			입력해서 자리를 바꿈
			3-1 단, 이웃한 문자만 바꿀 수 있음 이외의 경우 에러 메시지 출력
		4. 3개 이상의 문자가 이웃되면 없어지고 점수 카운트 추가
		5. 이웃되서 없어진 빈칸은 랜덤으로 문자를 생성해서 넣기

		6. 1분 내에 10번 맞추면 성공, 못 맞추면 실패

		7, 성공, 실패 후에 게임 종료
		*/
		int score=0;
		char[][] board= new char[9][9];
		boolean flag=false;
		//상하좌우 비교시 사용(에러 검증)
		int[] dx= {1,-1,0,0}; //j위치
		int[] dy= {0,0,1,-1}; //i위치
		
		Random r= new Random();
	    Scanner sc= new Scanner(System.in);

		//시간 재기 시작
		long start = System.currentTimeMillis();
		char temp=' '; //swap
		//반복문(10번 맞추기, 연산 후마다 시간 끝내기 -> 조건; 시간이 1분 초과 시 실패했다고 하고 리턴시키기.)
		//10번 맞추고 나서(반복문 종료) end-start해서 1분보다 작으면 성공 메시지
		boolean bigyo=false;
		int point=0;
		while(flag==false) {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					int num=r.nextInt(4); //0 1 2 3-> A B C D
					switch(num) {
					case 0: board[i][j]='A';
						    break;
					case 1: board[i][j]='B';
							break;
					case 2: board[i][j]='C';
							break;
					case 3: board[i][j]='D'; 
					        break;
					}
				}
			}
			System.out.println("  0 1 2 3 4 5 6 7 8");
			System.out.println("  _________________");
			for(int i=0;i<9;i++) {
				System.out.print(i+"|");
				for(int j=0;j<9;j++) {
					System.out.print(board[i][j]+" ");
				}
				System.out.println();
			}
			
			//3. 게임 시작, 사용자가 판을 보고 바꾸고 싶어하는 알파벳의 좌표를 선택하고, 그 알파벳의 이웃 알파벳의 좌표를
			//입력해서 자리를 바꿈
			System.out.println("알파벳의 좌표를 선택하세요~:)");
			System.out.print("x:");
			int x=sc.nextInt();
			System.out.print("y:");
			int y=sc.nextInt();
			
			System.out.println("바꾸고 싶은 곳의 알파벳의 좌표를 선택하세요~:)");
			System.out.print("x:");
			int new_x=sc.nextInt();
			System.out.print("y:");
			int new_y=sc.nextInt();
			
			//3-1 단, 이웃한 문자만 바꿀 수 있음 이외의 경우 에러 메시지 출력
			for(int i=0;i<4;i++) {
				int bigyo_x=x+dx[i], bigyo_y=y+dy[i];
				if(bigyo_x==new_x && bigyo_y==new_y) { //새로운 x,y가 범위 내에 있으면 트루로 
					bigyo=true;
				}
			}
			if(bigyo==false) {
				System.out.println("알파벳의 좌표가 처음 좌표의 이웃값이 아닙니다.");
				System.out.println("다시 입력해주세용!");
			    continue;
			}
			else {
			//swap
			temp=board[y][x];
			board[y][x]=board[new_y][new_x];
			board[new_y][new_x]=temp;
			
			//<--x 함수 call
			  //new x, new y 일 때
			  point=left(board,new_x, new_y);
			  if(point!=-1) {
				  score++;
				  //point, y ~ new_x, new_y
				  for(int j=point; j<=new_x;j++) {
					  int num2=r.nextInt(4);
					  switch(num2) {
						case 0: board[new_y][j]='A';
							    break;
						case 1: board[new_y][j]='B';
								break;
						case 2: board[new_y][j]='C';
								break;
						case 3: board[new_y][j]='D'; 
						        break;
						}
				  }
			  }
			 
			  else {
				  //x, y일 때 
				  point=left(board,x, y);
				  if(point!=-1) {
					  score++;
					  for(int j=point; j<=x;j++) {
						  int num2=r.nextInt(4);
						  switch(num2) {
							case 0: board[y][j]='A';
								    break;
							case 1: board[y][j]='B';
									break;
							case 2: board[y][j]='C';
									break;
							case 3: board[y][j]='D'; 
							        break;
							}
					  }
				  }
				  else {
					//<-x-> 함수 call
					  if(x>=1) {
						  point=middle(board, x, y);
						  if(point!=-1) {
							  score++;
							  int num3=r.nextInt(4);
							  int num4=r.nextInt(4);
							  switch(num3) {
								case 0: board[y][x-1]='A';
									    break;
								case 1: board[y][x-1]='B';
										break;
								case 2: board[y][x-1]='C';
										break;
								case 3: board[y][x-1]='D'; 
								        break;
								}
							  switch(num4) {
								case 0: board[y][x+1]='A';
									    break;
								case 1: board[y][x+1]='B';
										break;
								case 2: board[y][x+1]='C';
										break;
								case 3: board[y][x+1]='D'; 
								        break;
								}
						  }//endif(point)
					  }//end if x
				  
				  //new x, new y 일 때
					  if(new_x>=1) {
						  point=middle(board, new_x, new_y);
						  if(point!=-1) {
							  score++;
							  int num3=r.nextInt(4);
							  int num4=r.nextInt(4);
							  switch(num3) {
								case 0: board[new_y][new_x-1]='A';
									    break;
								case 1: board[new_y][new_x-1]='B';
										break;
								case 2: board[new_y][new_x-1]='C';
										break;
								case 3: board[new_y][new_x-1]='D'; 
								        break;
							  }
							  switch(num4) {
								case 0: board[new_y][new_x+1]='A';
									    break;
								case 1: board[new_y][new_x+1]='B';
										break;
								case 2: board[new_y][new_x+1]='C';
										break;
								case 3: board[new_y][new_x+1]='D'; 
								        break;
								}
						  }//endif(point)
					  }//end if x
				
					  //x, y일 때 
					  //x--> 함수 call
					  point=right(board, x,y);
					  if(point!=-1) {
						  score++;
						  for(int j=x;j<=point;j++) {
							  int num5=r.nextInt(4);
							  switch(num5) {
								case 0: board[y][j]='A';
									    break;
								case 1: board[y][j]='B';
										break;
								case 2: board[y][j]='C';
										break;
								case 3: board[y][j]='D'; 
								        break;
								}
						  }
					  }
					  else {
						  	//new x, new y 일 때
						  point=right(board, new_x, new_y);
						  if(point!=-1) {
							  score++;
							  for(int j=new_x;j<=point;j++) {
								  int num5=r.nextInt(4);
								  switch(num5) {
									case 0: board[new_y][j]='A';
										    break;
									case 1: board[new_y][j]='B';
											break;
									case 2: board[new_y][j]='C';
											break;
									case 3: board[new_y][j]='D'; 
									        break;
									}//end_switch
							  }//end for
						  }//end if
					  }//end else
					  
				  }//end else
			  }
			long end = System.currentTimeMillis();
			long time=end-start;
			if(time>60000) {
				System.out.println("score:"+score);
				System.out.println("게임 실패!!");
				return;
			}
			else if(score>=10) { 
				flag=true;
			   System.out.println("score:"+score);
			}
		  }		
		
		System.out.println("성공했습니다~!");
		}
	}
	static int left(char[][] board,int x, int y) {
		//x:j, y:i
		int count=0;
		for(int j=x;;j--) {
			if(board[y][j]!=board[y][x]) {
				if(count==0) return -1;
				else return x-count;
			}else {
				count++;
			}
		}
	}
	
	static int middle(char[][] board, int x, int y) {
		int count=0;
		if(board[y][x]==board[y][x-1] && board[y][x]==board[y][x+1])
			count++;
		if(count>0) return count;
		else return -1;
	}
	
	static int right(char[][] board, int x, int y) {
		int count=0;
		for(int j=x;;j++) {
			if(board[y][j]!=board[y][x]) {
				if(count==0) return -1;
				else return x+count;
			}else {
				count++;
			}
		}
	}
}
