package forwhile;

public class WEx3 {

	public static void main(String[] args) throws InterruptedException {
	    int i=5;
	    while(i-- != 0) {
	    	Thread.sleep(1000);
	    	//���� ���۵Ǵ� ���μ����� 1�ʵ��� �����.(millisecond�� �ϱ� ������ 1000�� 1��)
	    	System.out.println(i);
	    }
	}

}
