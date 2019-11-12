package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;



public class Http4 {

	public static void main(String[] args) throws Exception{

		//Main Thread
		//id pwd입력받음(쓰캐너로)
		//id pwd 값을 쓰레드를 통해 서버로 전송하기
		String urlstr="http://70.12.60.90/test/login.jsp";
		Scanner scan = new Scanner(System.in);
		String id=null;
		String pwd=null;
		ThreadEx1 t1;
		
		while(true) {
			System.out.println("Input ..");
			id=scan.next();
			pwd=scan.next();
			urlstr+="?id="+id+"&pwd="+pwd;
			t1=new ThreadEx1(id,pwd, urlstr);
			t1.start();
		}
		
		
		
	}

}

class ThreadEx1 extends Thread{
	String id;
	String pwd;
	String urlstr;
	
	public ThreadEx1() {
		super();
	}

	public ThreadEx1(String id, String pwd, String urlstr) {
		this.id = id;
		this.pwd = pwd;
		this.urlstr = urlstr;
	}

	public void run(){
		System.out.println("id: "+id);
		System.out.println("pwd: "+pwd);
		URL url = null;
		try {
			url = new URL(urlstr);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpURLConnection conn = null;
		try {
			conn = (HttpURLConnection)url.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.setRequestMethod("POST");
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		conn.setReadTimeout(5000);
	    InputStream is = null;
		try {
			is = conn.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //서버로 전송
		InputStreamReader isr 
		= new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		try {
			if(conn.getResponseCode()==HttpURLConnection.HTTP_OK) {
				String result=null;
				while((result=br.readLine())!=null){
					System.out.println(result);
				}
			}else {
				System.out.println("Server Down ...");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}