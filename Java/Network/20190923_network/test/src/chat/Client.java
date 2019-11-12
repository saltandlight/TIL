package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;


public class Client {

	Socket socket;
	boolean rflag=true;
	boolean sflag=true;
	
	public Client() {
		
	}
	
	public Client(String ip, int port) throws IOException {
		boolean flag=true;
		while(flag) {
			try {
				socket=new Socket(ip, port);
				if(socket != null && socket.isConnected()) {
					break;
				}
			} catch (Exception e) {
				System.out.println("Re-Try");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
			
		}//endwhile
		new Receiver(socket).start();
	}
	
	public void sendMsg(String msg) throws IOException {
		Sender sender=null;
		sender=new Sender(socket);
		//소켓은 여러 개 만드는 게 아님 
		sender.setMsg(msg);
		sender.start();
	}
	
	public void start() throws Exception{
		Scanner sc = 
				new Scanner(System.in);
		boolean sflag = true;
		while(sflag) {
			System.out.println("Input Msg.");
			String str = sc.next();
			sendMsg(str);
			if(str.equals("q")) {
				break;
			}
		}
		System.out.println("Bye....");
		
		sc.close();
//		System.out.println("!1111111111111111111111111");
	 }
	
	class Sender extends Thread{
		
		OutputStream out;
		DataOutputStream dout;
		String msg;
		
		public Sender(Socket socket) throws IOException {
			out=socket.getOutputStream();
			dout=new DataOutputStream(out);
		}

		public void setMsg(String msg) {
			this.msg=msg;
		}
		
		public void run() {
			if(dout !=null) {
				try {
					dout.writeUTF(msg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	//별도로 만들면 안 좋은 점.. 멤버를 공유할 수 없음. 
	class Receiver extends Thread{
		Socket socket;
		InputStream in;
		DataInputStream din;
		
		public Receiver(Socket socket) throws IOException {
			this.socket = socket;
			in = socket.getInputStream();
			din=new DataInputStream(in);
		}

		public void run() {
			while(rflag) {
				try {
					String str=din.readUTF();
					if(str.equals("q")) {
						break;
					}
					System.out.println(str);
					//받는 것을 뿌려줌
				} catch (IOException e) {
					
				}
			}
		}
		
	}

	public static void main(String[] args){
		Client client = null;
		try {
			client=new Client("70.12.60.92",8888);
			client.start();
		}catch(Exception e) {
			e.getStackTrace();
		}
		
		return;
	}

}
