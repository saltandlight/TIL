package day03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Fi2 {
	public static void main(String[] args) throws Exception{
		FileInputStream fis
		= new FileInputStream("C:\\network\\day03\\test.txt");
		BufferedInputStream bis
		= new BufferedInputStream(fis);
		//���� ����Ʈ�� �Ѳ����� �о����
		FileOutputStream fos
		= new FileOutputStream("C:\\network\\day03\\test2.txt");
		BufferedOutputStream bos
		= new BufferedOutputStream(fos,10);
		
		int data=0;
		while((data=bis.read())!=-1) {
			char c = (char)data;
			System.out.print(c);
			bos.write(data);
		}
		if(bis != null) {
			
			bis.close();
		}
		if(bos!=null) {
			//write �� flush ���ֱ�
			bos.flush();
			bos.close();
			//���ۿ� �����ִ� ������ ���������� ��µ�
		}
	}
}
