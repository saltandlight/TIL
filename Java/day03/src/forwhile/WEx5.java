package forwhile;

public class WEx5 {

	public static void main(String[] args) {
//		int i=1;
//		int sum=0;
//		
//		while(i <= 10) {
//			if(i==7) break;
//			if(i%2 == 0) {
//			    i++;
//				continue;
//				//¹ØÀÇ ¸í·É¹® ½ÇÇàÀÌ ¾È µÊ.
//				
//			}
//			sum+=i;
//			i++;
//			System.out.println("Process");
//			
//		}
//		System.out.println(sum);
		int sum=0;
		for(int i=1;i<=10;i++) {
			if(i==6) break;
			if(i%2==0) continue;
			sum+=i;
			System.out.println("Process");
		}
		
//		for(int i=1;i<=5;i++) {
//			if(i%2==0) continue;
//			sum+=i;
//		}
		System.out.println(sum);
	}

}
