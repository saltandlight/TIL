package ws;
 
import java.util.Random;
import java.util.Scanner;
 
public class Game {
 
    public static void main(String[] args) {
        //빙고 게임
        // 1. 빙고 사이즈 입력(n<=100)
        int n;
        Scanner scan = new Scanner(System.in);
        Random r = new Random();
 
        System.out.println("빙고판의 사이즈를 입력해주세용");
        n=scan.nextInt();
 
        int board[][]=new int[n][n];
        // 2. 정방형의 빙고 판을 만들고 1~100 숫자 입력
            
//        for(int i=0;i<n;i++) {
//            for(int j=0;j<n;j++) {
//                num=r.nextInt(100)+1;
//                if(num_check[num]==false) {
//                    board[i][j] = num;
//                    num_check[num] = true;
//                    count++;
//                } else {
//                    i--;
//                    break;
//                }
//            }
//        }
        int ov = 100;
        
        int[] copy = new int[ov];
        int[] overlap = new int[ov];
        
        for(int i = 0; i < 100; i++)
            overlap[i] = i+1;
                
        int prev = -1;
        
        for(int i = 0; i < n; i++) {                
            for(int j = 0; j < n ; j++) {
                int c = 0;
                int k = 0;
                
                if(ov < 100)
                    while(c < ov) {
                        if(copy[k] == prev) {
                            k++;
                            continue;
                        }
                        else {
                            overlap[c] = copy[k];
                            c++;
                            k++;
                        }
                    }
                
                int n1 = r.nextInt(ov);
                board[i][j] = overlap[n1];
                prev = overlap[n1];
                copy = overlap.clone();
                ov--;  
                overlap = new int[ov];
            }
        }
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.printf("\n");
        }
        // 3. 숫자를 입력 받아서 입력받은 값이 있는 곳은 0으로 변경
        int bingo=0;
        int input=0;
        
        boolean[] rowCheck = new boolean[n];
        boolean[] colCheck = new boolean[n];
        boolean crossCheck1 = false;
        boolean crossCheck2 = false;
        
        int countCall = 0;
        
        while(bingo < 3) {
            System.out.print("1~100까지의 숫자를 입력하세요:\n");
            input=scan.nextInt();
//            input = r.nextInt(100)+1;
            
            boolean flag = false;
            
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(board[i][j] == input) {
                        board[i][j] = 0;
                    }
                } 
            }
            
            if(flag == false) {
                countCall++;
                bingo += checkRow(rowCheck, board);
                bingo += checkCol(colCheck, board);
                
                if(crossCheck1 == false) {
                    int crossCount = 0;
                    for(int i=0; i < board.length; i++) {
                        if(board[i][i] == 0)
                            crossCount += 1;                            
                    }
                    if(crossCount == n) {
                        bingo+=1; crossCheck1=true;
                        System.out.println("대각1 빙고!");
                    }
                }
                
                if(crossCheck2 == false) {
                    int crossCount = 0;
                    for(int i=0; i < board.length; i++) {
                        if(board[i][board.length-1-i] == 0)
                            crossCount += 1;                            
                    }
                    if(crossCount == n) {
                        bingo+=1; crossCheck2=true;
                        System.out.println("대각2 빙고!");
                    }
                }
            }
 
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    System.out.print(board[i][j]+" ");
                }
                System.out.printf("\n");
            }
            
        }
        // 4. 빙고가 되면 표시
        System.out.println("3빙고 성공!");
        System.out.printf("%d 번만에 성공하셨습니다 ^0^\n", countCall);
    }
    
    public static int checkRow(boolean[] rowCheck, int[][] board) {
        int rowCount = 0;
        for(int i = 0; i < board.length; i++) {
            int count = 0;
            if(rowCheck[i] == false) {
                for(int j = 0; j < board[i].length; j++) {
                    if(board[i][j] == 0)
                        count++;
                }
                if(count == board.length) {
                    rowCount++;
                    rowCheck[i] = true;
 
                    System.out.println("행 빙고!");
                }
            }
        }
        
        return rowCount;
    }
    
    public static int checkCol(boolean[] colCheck, int[][] board) {
        int colCount = 0;
        for(int i = 0; i < board.length; i++) {
            int count = 0;
            if(colCheck[i] == false) {
                for(int j = 0; j < board[i].length; j++) {
                    if(board[j][i] == 0)
                        count++;
                }
                if(count == board.length) {
                    colCount++;
                    colCheck[i] = true;
                    System.out.println("열 빙고!");
                }
            }
        }
        
        return colCount;
    }
 
}

