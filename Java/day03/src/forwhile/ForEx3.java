package forwhile;

public class ForEx3 {

	public static void main(String[] args) {
	  // 3*3의 정방행렬을 출력
      //11 12 13
	  //21 22 23
	  //31 32 33
		
	  for(int i=1;i<=3;i++) {
		  for(int j=1;j<=3;j++) {
			  System.out.printf("%d%d ", i,j);
		  }
		  System.out.println();
	  }
	}

}
