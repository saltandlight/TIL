
package forwhile;

public class WEx6 {

	public static void main(String[] args) {
		//구구단을 출력하시오
		//짝수단만 출력하시오
		//결과가 49일때 멈추세요
		out:
		
		for(int i=2;i<=9;i++) {
			if(i%2==0) continue;
			for(int j=1;j<=9;j++) {
				int result=i*j;
				if(result==49) break out;
				System.out.printf(i+"x"+j+"="+result+"\t");
			}
			System.out.println();
		}

	}

}
