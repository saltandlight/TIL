package forwhile;

public class ForEx1 {

	public static void main(String[] args) {
//		System.out.println("Start");
		// 10부터 0까지 출력하시오.
//		for(int i=10;i>=0;i--) {
//			System.out.print(i+" ");
//		}
//		System.out.println();
//		System.out.println("End");
		//홀수만 출력하시오(1~10)
		
		int i=1, j=10;
		int sum=0;
		//i:1~10
		//j:10~1
		for(;i<=10 && j>=1;i++,j--) {
			if(i%5==0 || j%5==0) {
				System.out.println(i+" "+j);
				sum+=i*j;
			}
		}
//		System.out.println("\nLast Value:"+(i+j));
		System.out.println("sum: "+sum);
		
	}

}
