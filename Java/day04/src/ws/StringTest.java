package ws;

import java.util.Scanner;

public class StringTest {

	public static void main(String[] args) {
	    Scanner scan= new Scanner(System.in);
		//1.�ҹ��ڷ� ���ڿ� �Է¹ޱ�
	    String input_str="";
		System.out.println("�ҹ��� ���ĺ����� �Է����ּ���~:)");
	    input_str=scan.next();
		
	    for(int i=0;i<input_str.length();i++) {
	    	System.out.print(input_str.charAt(i));
	    }
	    System.out.println();
	    
	    
	    //2. input_str�� �빮�ڷ� ���� && for loop�� �̿��ؼ� �Ųٷ� ���
	    String input_str2=input_str.toUpperCase();
	    char[] input_str3=new char[input_str2.length()];
	    
	    int idx=0;
	    for(int i=input_str2.length()-1;i>=0;i--) {
	    	input_str3[idx]=input_str2.charAt(i);
	    	System.out.print(input_str3[idx++]);
	    }
	    System.out.println();
	    //3. input_str3�� �� char�� 5�� ���ؼ� ��ȣȭ �� �� ���
	    for(int i=0;i<idx;i++) {
	    	input_str3[i]=(char)(input_str3[i]+5);
	    	System.out.print(input_str3[i]);
	    }
	    System.out.println();
		//4. 3���� ������� ��ȣ���� ��ȣȭ�ؼ� ���� �Է¹��� ���� ���
	         //(1). 5�� ����
	    for(int i=0;i<idx;i++) {
	    	input_str3[i]=(char)(input_str3[i]-5);
	    }
	    	 //(2). �Ųٷ� ������ //���� 
	    char[] output_str=new char[input_str.length()];
	    idx=0;
	    for(int i=input_str3.length-1;i>=0;i--) {
	    	output_str[idx++]=input_str3[i];
	    }
	         //(3). �ҹ��ڷ� ������ֱ�
	    for(int i=0;i<idx;i++) {
	    	output_str[i]=(char)(output_str[i]+32);
	    	System.out.print(output_str[i]);
	    }
	}
}
