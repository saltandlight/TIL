package ws;
 
import java.util.Random;
import java.util.Scanner;
 
public class Game {
 
    public static void main(String[] args) {
        //���� ����
        // 1. ���� ������ �Է�(n<=100)
        int n;
        Scanner scan = new Scanner(System.in);
        Random r = new Random();
 
        System.out.println("�������� ����� �Է����ּ���");
        n=scan.nextInt();
 
        int board[][]=new int[n][n];
        // 2. �������� ���� ���� ����� 1~100 ���� �Է�
            
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
        // 3. ���ڸ� �Է� �޾Ƽ� �Է¹��� ���� �ִ� ���� 0���� ����
        int bingo=0;
        int input=0;
        
        boolean[] rowCheck = new boolean[n];
        boolean[] colCheck = new boolean[n];
        boolean crossCheck1 = false;
        boolean crossCheck2 = false;
        
        int countCall = 0;
        
        while(bingo < 3) {
            System.out.print("1~100������ ���ڸ� �Է��ϼ���:\n");
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
                        System.out.println("�밢1 ����!");
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
                        System.out.println("�밢2 ����!");
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
        // 4. ���� �Ǹ� ǥ��
        System.out.println("3���� ����!");
        System.out.printf("%d ������ �����ϼ̽��ϴ� ^0^\n", countCall);
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
 
                    System.out.println("�� ����!");
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
                    System.out.println("�� ����!");
                }
            }
        }
        
        return colCount;
    }
 
}

