package ws2;

import java.util.Random;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		/*ws2.Game.java
		[ ĵ��ũ���� ]
		1. 9 x 9 ĵ���� ����
		2. ĵ���ǿ� ABCDE�� ���� ���� �ٸ� ���� 4�� �̻��� ����ؼ� �������� ĵ���ǿ� �ִ´�.
		3. ���� ����, ����ڰ� ���� ���� �ٲٰ� �;��ϴ� ���ĺ��� ��ǥ�� �����ϰ�, �� ���ĺ��� �̿� ���ĺ��� ��ǥ��
			�Է��ؼ� �ڸ��� �ٲ�
			3-1 ��, �̿��� ���ڸ� �ٲ� �� ���� �̿��� ��� ���� �޽��� ���
		4. 3�� �̻��� ���ڰ� �̿��Ǹ� �������� ���� ī��Ʈ �߰�
		5. �̿��Ǽ� ������ ��ĭ�� �������� ���ڸ� �����ؼ� �ֱ�

		6. 1�� ���� 10�� ���߸� ����, �� ���߸� ����

		7, ����, ���� �Ŀ� ���� ����
		*/
		int score=0;
		char[][] board= new char[9][9];
		boolean flag=false;
		//�����¿� �񱳽� ���(���� ����)
		int[] dx= {1,-1,0,0}; //j��ġ
		int[] dy= {0,0,1,-1}; //i��ġ
		
		Random r= new Random();
	    Scanner sc= new Scanner(System.in);

		//�ð� ��� ����
		long start = System.currentTimeMillis();
		char temp=' '; //swap
		//�ݺ���(10�� ���߱�, ���� �ĸ��� �ð� ������ -> ����; �ð��� 1�� �ʰ� �� �����ߴٰ� �ϰ� ���Ͻ�Ű��.)
		//10�� ���߰� ����(�ݺ��� ����) end-start�ؼ� 1�к��� ������ ���� �޽���
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
			
			//3. ���� ����, ����ڰ� ���� ���� �ٲٰ� �;��ϴ� ���ĺ��� ��ǥ�� �����ϰ�, �� ���ĺ��� �̿� ���ĺ��� ��ǥ��
			//�Է��ؼ� �ڸ��� �ٲ�
			System.out.println("���ĺ��� ��ǥ�� �����ϼ���~:)");
			System.out.print("x:");
			int x=sc.nextInt();
			System.out.print("y:");
			int y=sc.nextInt();
			
			System.out.println("�ٲٰ� ���� ���� ���ĺ��� ��ǥ�� �����ϼ���~:)");
			System.out.print("x:");
			int new_x=sc.nextInt();
			System.out.print("y:");
			int new_y=sc.nextInt();
			
			//3-1 ��, �̿��� ���ڸ� �ٲ� �� ���� �̿��� ��� ���� �޽��� ���
			for(int i=0;i<4;i++) {
				int bigyo_x=x+dx[i], bigyo_y=y+dy[i];
				if(bigyo_x==new_x && bigyo_y==new_y) { //���ο� x,y�� ���� ���� ������ Ʈ��� 
					bigyo=true;
				}
			}
			if(bigyo==false) {
				System.out.println("���ĺ��� ��ǥ�� ó�� ��ǥ�� �̿����� �ƴմϴ�.");
				System.out.println("�ٽ� �Է����ּ���!");
			    continue;
			}
			else {
			//swap
			temp=board[y][x];
			board[y][x]=board[new_y][new_x];
			board[new_y][new_x]=temp;
			
			//<--x �Լ� call
			  //new x, new y �� ��
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
				  //x, y�� �� 
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
					//<-x-> �Լ� call
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
				  
				  //new x, new y �� ��
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
				
					  //x, y�� �� 
					  //x--> �Լ� call
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
						  	//new x, new y �� ��
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
				System.out.println("���� ����!!");
				return;
			}
			else if(score>=10) { 
				flag=true;
			   System.out.println("score:"+score);
			}
		  }		
		
		System.out.println("�����߽��ϴ�~!");
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
