package http;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class Http2 {

	public static void main(String[] args) 
			throws Exception {
		String urlstr="http://70.12.60.90/test/oracle.zip";
		URL url=new URL(urlstr);
		InputStream is =url.openStream();
		BufferedInputStream bis 
		= new BufferedInputStream(is,1024);
		
		int data=0;
		//oracle.zip 
		String fileName="oracle.zip";
		FileOutputStream fo = new FileOutputStream(fileName);
		BufferedOutputStream bos
		= new BufferedOutputStream(fo);
		
		System.out.print("Start...");
		while((data=bis.read()) != -1) {
//			//���� 
//			System.out.print("*"+data);
			bos.write(data);
		}
		System.out.println("Finish..");
		is.close();
		bos.flush();
		bos.close();
	}

}
