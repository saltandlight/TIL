package tv;

public class TVApp2 {

	public static void main(String[] args) {
		TV tv = new TV();
		System.out.println(tv.toString());
		
		TV tv2 = new TV("blue", false, 10);
		System.out.println(tv2.toString());
		
		TV tv3 = new TV("green");
		System.out.println(tv3.toString());
		tv3.setColor("green");
		//encapsulation: ������ �� ����.
		//������ �� constructor�� ���ؼ��� ���� ���� ����. 
//		tv3.color="yellow"; //�����Ӱ� �ٲٰ� �Ǹ� ���� �ǵ����� ���� ����� ���� �� ����. ��� ��ŷ�� ���ο� ����.
		System.out.println(tv3.getColor());
		
	}

}
