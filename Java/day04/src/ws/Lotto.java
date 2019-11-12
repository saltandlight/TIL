package ws;

import java.text.NumberFormat;
import java.util.Random;
import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {
	   int [] myarr=new int[10]; //내번호
	   int [] dang_num=new int[10]; //당첨번호
	   
	   Scanner sc=new Scanner(System.in);
	 //1.내 번호 입력받기
	   System.out.print("내 번호: ");
	   for(int i=0;i<6;i++) { 
		   myarr[i]=sc.nextInt();
		   if(myarr[i]<1 || myarr[i]>10) {
			   System.out.println("입력값이 잘못되었습니다.");
			   return;
		   }
	   }
	  //2. 그 날의 당첨번호 6개 받기(1~10) 중 랜덤으로 받고
	     //중복은 없어야 함.
	   Random r=new Random();
	   for(int i=0;i<6;i++) {
		   dang_num[i]=r.nextInt(10)+1;
		   for(int j=0;j<i;j++) {
			   if(dang_num[i]==dang_num[j]) {
				   i--;
			  }
		   }
	   }
	   
	
	   System.out.print("당첨 번호는: ");
	   for(int i1=0;i1<6;i1++) {
		   System.out.print(dang_num[i1]+" ");
	   }
	   
	  //3. 당첨금 생성(범위:10억~100억)
	   //90억=9_000_000_000
	   long mn=9000000000L;
       long money=(long)(Math.random()*mn)+1000000000L;
	  //4. 내 번호의 값이 당첨번호의 값과 일치하면 카운트 증가
       int cnt=0;
       for(int i=0;i<6;i++) {
    	   for(int j=1;j<6;j++) {
    		   if(myarr[i]==dang_num[j])
    			   cnt++;
    	   }
       }
	  //5. 4. 입력 받은 숫자와 당첨번호 확인
            //- 3개 맞으면 : 4등 (당첨금 5%)
	        //- 4개 맞으면 : 3등 (당첨금 10%)
	     	//- 5개 맞으면 : 2등 (당첨금 20%)
	        //- 6개 맞으면 : 1등 (당첨금 50%)
       //등수(grade), 총 당첨금(money), 당첨금(mymoney) 출력
       int grade=0;
       double my_money=0;
       switch(cnt) {
       case 3: grade=4; my_money=money*0.05;
       		   break;
       case 4: grade=3; my_money=money*0.1;
       		   break;
       case 5: grade=2; my_money=money*0.2;
       		   break;
       case 6: grade=1; my_money=money*0.5;
       		   break;
       }
       NumberFormat nf = NumberFormat.getInstance();
       System.out.println();
       
       System.out.println("등수: "+grade);
       System.out.println("총 당첨금: "+nf.format(money)+ "원입니다.");
       System.out.println("당첨금은 : "+nf.format((long)my_money)+ "원입니다.");

	}
}
