package ifswhitch;

public class SwitchEx1 {

	public static void main(String[] args) {
		//관리자 Permission Control
		
		int a = 1; //int value, String
		String str="";
		switch(a) { //int값만 들어가고 flaot, double처럼 실수값은 안 됨.
		case 1: str+="Super Admin "; //case에 조건을 쓸 수가 없다.
//			    break;
		case 2: str+="Middle Admin ";
//				break;
		case 3: str+="Admin";
				break;
		default:str="FAIL";
				break;
		}
		System.out.println(str);

	}

}
