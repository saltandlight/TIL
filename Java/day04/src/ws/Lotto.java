package ws;

import java.text.NumberFormat;
import java.util.Random;
import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {
	   int [] myarr=new int[10]; //����ȣ
	   int [] dang_num=new int[10]; //��÷��ȣ
	   
	   Scanner sc=new Scanner(System.in);
	 //1.�� ��ȣ �Է¹ޱ�
	   System.out.print("�� ��ȣ: ");
	   for(int i=0;i<6;i++) { 
		   myarr[i]=sc.nextInt();
		   if(myarr[i]<1 || myarr[i]>10) {
			   System.out.println("�Է°��� �߸��Ǿ����ϴ�.");
			   return;
		   }
	   }
	  //2. �� ���� ��÷��ȣ 6�� �ޱ�(1~10) �� �������� �ް�
	     //�ߺ��� ����� ��.
	   Random r=new Random();
	   for(int i=0;i<6;i++) {
		   dang_num[i]=r.nextInt(10)+1;
		   for(int j=0;j<i;j++) {
			   if(dang_num[i]==dang_num[j]) {
				   i--;
			  }
		   }
	   }
	   
	
	   System.out.print("��÷ ��ȣ��: ");
	   for(int i1=0;i1<6;i1++) {
		   System.out.print(dang_num[i1]+" ");
	   }
	   
	  //3. ��÷�� ����(����:10��~100��)
	   //90��=9_000_000_000
	   long mn=9000000000L;
       long money=(long)(Math.random()*mn)+1000000000L;
	  //4. �� ��ȣ�� ���� ��÷��ȣ�� ���� ��ġ�ϸ� ī��Ʈ ����
       int cnt=0;
       for(int i=0;i<6;i++) {
    	   for(int j=1;j<6;j++) {
    		   if(myarr[i]==dang_num[j])
    			   cnt++;
    	   }
       }
	  //5. 4. �Է� ���� ���ڿ� ��÷��ȣ Ȯ��
            //- 3�� ������ : 4�� (��÷�� 5%)
	        //- 4�� ������ : 3�� (��÷�� 10%)
	     	//- 5�� ������ : 2�� (��÷�� 20%)
	        //- 6�� ������ : 1�� (��÷�� 50%)
       //���(grade), �� ��÷��(money), ��÷��(mymoney) ���
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
       
       System.out.println("���: "+grade);
       System.out.println("�� ��÷��: "+nf.format(money)+ "���Դϴ�.");
       System.out.println("��÷���� : "+nf.format((long)my_money)+ "���Դϴ�.");

	}
}
