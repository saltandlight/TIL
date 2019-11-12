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
		//encapsulation: 변경할 수 없음.
		//생성할 떄 constructor를 통해서만 변수 값을 넣음. 
//		tv3.color="yellow"; //자유롭게 바꾸게 되면 정말 의도하지 않은 결과가 나올 수 있음. 모든 해킹은 내부에 있음.
		System.out.println(tv3.getColor());
		
	}

}
