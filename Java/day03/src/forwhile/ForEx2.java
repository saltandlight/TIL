package forwhile;

public class ForEx2 {

	public static void main(String[] args) {
		
		//���������� ��Ʈ������ ����Ͻÿ�.
		int res;
		for(int i=1;i<=3;i++) {
			for(int j=1;j<=3;j++) {
				res=i-j;
				if(res==0) System.out.print("���º�\t");
				else if(res==1 || res==-2) System.out.print("������\t");
				else System.out.print("�Ľ�\t");
			}
			System.out.println();
		}
		
	}

}
