package ifswhitch;

public class IfEx2 {

	public static void main(String[] args) {
		int a = 87;
		char c='F';
		//조건 잘못 주면 여러 개에 다 걸릴 수 있음.
		if(90 <= a) {
			c='A';
		}else if(80 <= a) {
			c='B';
		}else if(70 <= a) {
			c='C';
		}else {//모든 위에 것에 해당하지 않는 것들 포함.-> 이런 습관- 안정적 소프트퉤어 개발에 좋다.
			//위의 것에 전혀 부합되지 않은 것 의미.
			c='F';
		}
		System.out.println(c);
	}

}
