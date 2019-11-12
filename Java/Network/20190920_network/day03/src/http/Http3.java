package http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Http3 {

    public static void main(String[] args) 
			throws Exception {
		String urlstr="http://70.12.60.90/test/login.jsp";
		String id="aa";
		String pwd="11";
		urlstr+="?id="+id+"&pwd="+pwd;
		URL url = new URL(urlstr);
		HttpURLConnection
		  conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("POST");		
		conn.setReadTimeout(5000);
	    InputStream is = 
	    		conn.getInputStream();
	    //서버로 전송
		InputStreamReader isr 
		= new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		if(conn.getResponseCode()==HttpURLConnection.HTTP_OK) {
			String result=null;
			while((result=br.readLine())!=null){
				System.out.println(result);
			}
		}else {
			System.out.println("Server Down ...");
		}
			
	}

}
