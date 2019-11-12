package day02;

public class Variable4 {

	public static void main(String[] args) {
		// Primitive type
		int a=10;
		char c= 'a';
		//Reference Type
		//String은 앞에 대문자가 있으므로 자바 API이용하여 문자열을 표현한 것.
		String s1= "abc";
		String s2 = "abc";
		//힙의 String Pool 내에서 abc를 가리킴.(같은 주소 가리킴)
		String s3 = new String("abc");
		String s4 = new String("abc");
		//어딘가에 힙 영역에서 abc가 생김
		
		if(s4.equals(s3)) { //reference 변수이기 때문에 이렇게 비교해야 함.
			System.out.println("case1");
		}
		
		int i1=10; //10진수
		int i2=010; //8진수
		int i3=0x10; //16진수
		
		System.out.println(i1+" "+i2+" "+i3);
	}

}
