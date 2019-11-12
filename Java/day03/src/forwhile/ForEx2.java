package forwhile;

public class ForEx2 {

	public static void main(String[] args) {
		
		//가위바위보 매트릭스를 출력하시오.
		int res;
		for(int i=1;i<=3;i++) {
			for(int j=1;j<=3;j++) {
				res=i-j;
				if(res==0) System.out.print("무승부\t");
				else if(res==1 || res==-2) System.out.print("유저승\t");
				else System.out.print("컴승\t");
			}
			System.out.println();
		}
		
	}

}
