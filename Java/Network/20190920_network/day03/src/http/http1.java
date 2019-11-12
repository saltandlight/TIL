package http;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;

public class http1 {

	public static void main(String[] args) throws Exception {
		URL url = new URL("http://70.12.60.90/test");
		URLConnection conn = url.openConnection();
		//해당 URL로 접속
		
		InputStream is
		=conn.getInputStream();
		
		InputStreamReader isr=new InputStreamReader(is);
		
		BufferedInputStream bis
		=new BufferedInputStream(is);
		
		
		BufferedReader br= new BufferedReader(isr);
		
		int data=0;
		
		StringWriter sw=new StringWriter();
		
		while((data=br.read())!=-1) {
			char c =(char)data;
			sw.write(c);
		}
		System.out.println(sw.toString());
	}
}
