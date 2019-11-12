package forwhile;

public class WEx3 {

	public static void main(String[] args) throws InterruptedException {
	    int i=5;
	    while(i-- != 0) {
	    	Thread.sleep(1000);
	    	//현재 동작되는 프로세스를 1초동안 멈춰라.(millisecond로 하기 때문에 1000은 1초)
	    	System.out.println(i);
	    }
	}

}
