package ifswhitch;

public class SwitchEx1 {

	public static void main(String[] args) {
		//������ Permission Control
		
		int a = 1; //int value, String
		String str="";
		switch(a) { //int���� ���� flaot, doubleó�� �Ǽ����� �� ��.
		case 1: str+="Super Admin "; //case�� ������ �� ���� ����.
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
