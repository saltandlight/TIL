package ifswhitch;

public class SwitchEx2 {

	public static void main(String[] args) {
	   int month=2;
	   int lastDayOfMonth=0;
	   //해당하는 월의 마지막 일자를 출력하시오.
	   
	   switch(month) {
	   case 1: case 3: case 5: case 7: case 8: case 10: case 12:
		      lastDayOfMonth=31;
			  break;
	   case 2:lastDayOfMonth=28;
	   		  break;
	   case 4: case 6:case 9: case 11:
		      lastDayOfMonth=30;
		      break;
	   default:System.out.println("FAIL");
	   }
	   System.out.println(lastDayOfMonth);
	}

}
