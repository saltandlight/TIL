package day02;

public class Variable4 {

	public static void main(String[] args) {
		// Primitive type
		int a=10;
		char c= 'a';
		//Reference Type
		//String�� �տ� �빮�ڰ� �����Ƿ� �ڹ� API�̿��Ͽ� ���ڿ��� ǥ���� ��.
		String s1= "abc";
		String s2 = "abc";
		//���� String Pool ������ abc�� ����Ŵ.(���� �ּ� ����Ŵ)
		String s3 = new String("abc");
		String s4 = new String("abc");
		//��򰡿� �� �������� abc�� ����
		
		if(s4.equals(s3)) { //reference �����̱� ������ �̷��� ���ؾ� ��.
			System.out.println("case1");
		}
		
		int i1=10; //10����
		int i2=010; //8����
		int i3=0x10; //16����
		
		System.out.println(i1+" "+i2+" "+i3);
	}

}
