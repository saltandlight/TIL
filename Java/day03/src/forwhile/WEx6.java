
package forwhile;

public class WEx6 {

	public static void main(String[] args) {
		//�������� ����Ͻÿ�
		//¦���ܸ� ����Ͻÿ�
		//����� 49�϶� ���߼���
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
