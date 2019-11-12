package ws;

import java.util.Scanner;

public class StringTest {

	public static void main(String[] args) {
	    Scanner scan= new Scanner(System.in);
		//1.소문자로 문자열 입력받기
	    String input_str="";
		System.out.println("소문자 알파벳들을 입력해주세요~:)");
	    input_str=scan.next();
		
	    for(int i=0;i<input_str.length();i++) {
	    	System.out.print(input_str.charAt(i));
	    }
	    System.out.println();
	    
	    
	    //2. input_str을 대문자로 만듬 && for loop를 이용해서 거꾸로 출력
	    String input_str2=input_str.toUpperCase();
	    char[] input_str3=new char[input_str2.length()];
	    
	    int idx=0;
	    for(int i=input_str2.length()-1;i>=0;i--) {
	    	input_str3[idx]=input_str2.charAt(i);
	    	System.out.print(input_str3[idx++]);
	    }
	    System.out.println();
	    //3. input_str3의 각 char에 5를 더해서 암호화 한 후 출력
	    for(int i=0;i<idx;i++) {
	    	input_str3[i]=(char)(input_str3[i]+5);
	    	System.out.print(input_str3[i]);
	    }
	    System.out.println();
		//4. 3에서 만들어진 암호문을 복호화해서 최초 입력받은 값을 출력
	         //(1). 5를 빼기
	    for(int i=0;i<idx;i++) {
	    	input_str3[i]=(char)(input_str3[i]-5);
	    }
	    	 //(2). 거꾸로 뒤집기 //수정 
	    char[] output_str=new char[input_str.length()];
	    idx=0;
	    for(int i=input_str3.length-1;i>=0;i--) {
	    	output_str[idx++]=input_str3[i];
	    }
	         //(3). 소문자로 만들어주기
	    for(int i=0;i<idx;i++) {
	    	output_str[i]=(char)(output_str[i]+32);
	    	System.out.print(output_str[i]);
	    }
	}
}
