package ws;

import java.util.Arrays;
import java.util.Scanner;

public class GradeTest {

	public static void main(String[] args) {
		int[] sub = new int[4];
		Scanner scan = new Scanner(System.in);
		System.out.println("다음 과목의 성적들을 입력해주세요~\n국어 영어 수학 과학");
		for(int i=0;i<sub.length;i++) {
			sub[i]=scan.nextInt();
		}
		//객체 생성
		Grade grd=new Grade(sub);
		//1. 합을 출력 하시오
		System.out.println("과목성적의 합:"+grd.sum());
//		2. 평균을 출력 하시오
		System.out.println("과목성적의 평균:"+grd.avg());
//		3. 평균이 90점 이상이면 A, 80점 이상이면 B, 70점 이상이면 C, 60점 이상이면 D, 이하면 F
		System.out.println("과목 평균의 성적:"+grd.prc_grade());
//		4. 최고점의 과목을 출력 하시오
		System.out.println("최고점의 과목:"+grd.prc_max());
		//5.최저점의 과목을 출력하시오
		System.out.println("최저점의 과목:"+grd.prc_min());
//		6. 오름차순 정렬 
		System.out.println(Arrays.toString(grd.asort()));
//		7. 내림차순 정렬
		System.out.println(Arrays.toString(grd.dsort()));
		
	}

}
