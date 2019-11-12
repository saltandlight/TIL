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
		//여러 바이트를 한꺼번에 읽어들임
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
			//write 후 flush 해주기
			bos.flush();
			bos.close();
			//버퍼에 남아있는 내용이 정상적으로 출력됨
		}
	}
}
