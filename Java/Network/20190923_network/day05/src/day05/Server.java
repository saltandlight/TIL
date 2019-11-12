package day05;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Server {

	boolean flag = true;
	boolean rflag = true;
//	Socket socket;
	ServerSocket serverSocket;
	Map<String, DataOutputStream> map = new HashMap<>();

	public Server() {

	}

	public Server(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		System.out.println("Server Start..");
		Runnable r = new Runnable() {
			@Override
			public void run() {
				while (flag) {
					System.out.println("Server Ready..");
					Socket socket = null;
					try {
						socket = serverSocket.accept();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						new Receiver(socket).start();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// 소켓을 매번 새로 만들어야 함 (사용자는 복수다)
					System.out.println(socket.getInetAddress());

				}
				System.out.println("Server End..");
			}
		};
		new Thread(r).start();
	}

	public void start() throws IOException {
		// socket이라는 레이어는 continuous한 게 맞음.
		Scanner sc = new Scanner(System.in);
		boolean sflag = true;
		while (sflag) {
			System.out.println("Input Msg....");
			String str = sc.next();
			sendMsg(str);
			if (str.equals("q")) {
				break;
			}
		}
		sc.close();
//				System.out.println("Input Msg.");
	}

	public void sendMsg(String msg) {
		Sender sender = new Sender();
		sender.setMsg(msg);
		sender.start();
	}

	class Sender extends Thread {

		String msg;

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public void run() {
			Collection<DataOutputStream> col = map.values();
			// 키값 무시하고 value값들을 끄집어낼 수 있음.

			Iterator<DataOutputStream> it = col.iterator();
			while (it.hasNext()) {
				try {
					it.next().writeUTF(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	class Receiver extends Thread {
		Socket socket;
		InputStream in;
		DataInputStream din;
		OutputStream out;
		DataOutputStream dout;
		String ip;

		public Receiver(Socket socket) throws Exception {
			this.socket = socket;
			in = socket.getInputStream();
			din = new DataInputStream(in);
			out = socket.getOutputStream();
			dout = new DataOutputStream(out);
			ip = socket.getInetAddress().toString();
			map.put(ip, dout);
		}

		public void run() {
			try {
				while(rflag) {
					String str = 
							din.readUTF();
					if(str.equals("q")) {
						map.remove(ip);
						break;
					}
					System.out.println(str);
					sendMsg(str);
				}
				if(socket != null) {
					socket.close();
				}
			}catch(Exception e) {
				System.out.println("비정상 아웃:"+ip);
				map.remove(ip);
				System.out.println("나간 후 접속자 수:"+map.size());
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) {
		Server server = null;
		try {
			server = new Server(8888);
			server.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
