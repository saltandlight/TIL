package day02;

public class Operator2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		double d=3.14356523;
//		//�Ҽ��� 3�ڸ� ���� ������ ����ϰ� ���
//		double result1=Math.floor(d*1000)/1000.0;
//		System.out.println(result1);
//		// �Ҽ��� 3�ڸ� ���� �ݿø��� ����ϰ� ���
//		double result2=Math.round(d*1000+0.5)/1000.0;
//		System.out.println(result2);
		
		//���� �ﰢ�� ���μ��ΰ� 5, 4�� �ﰢ��
		//������ ���̸� ���Ͻÿ�
		//hint Math API�� �̿��� ��
		
		int a=5;
		int b=4;
		double result=Math.sqrt((double)(a*a)+(double)(b*b));
		
		System.out.println(result);
		result=Math.sqrt(Math.pow(5, 2)+Math.pow(4, 2));
		System.out.println(result);
	}
}
