package forwhile;

public class WEx4 {

	public static void main(String[] args) {
//		int sum=0;
//		int i=0;
//		
//		while((sum += ++i) <= 100) { //오른 쪽에 증가된 i가 sum으로 가서 합쳐짐
//			System.out.println(i+" "+sum);
//		}
//		
		//for loop
		for(int j=1, sum2=1;sum2<=100;sum2+=++j) {
			System.out.println(j+" "+sum2);
		}
	}

}
