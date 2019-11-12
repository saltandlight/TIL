package tcp1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread {
	int port;
	static ServerSocket serverSocket;
	Socket socket;

	boolean flag = true;

	public ServerThread(int port) throws IOException {
		this.port = port;
		serverSocket = new ServerSocket(port);
	}

	public static void main(String[] args) {

		System.out.println("Server start..");
		ThreadEx1 t1 = new ThreadEx1(8888,serverSocket);
		t1.run();
		System.out.println("Server end..");

	}

}

class ThreadEx1 extends Thread {
	int port;
	ServerSocket serverSocket;
	Socket socket;

	OutputStream out;
	OutputStreamWriter osw;
	BufferedWriter bw;
	boolean flag = true;

	
	
	
	public ThreadEx1(int port,  ServerSocket serverSocket) {
		this.port = port;
		this.serverSocket = serverSocket;
	}

	public void run() {
		while (flag) {
			System.out.println("Server Ready..");
			try {
				socket = serverSocket.accept();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Accepted.." + socket.getInetAddress());

			try {
				out = socket.getOutputStream();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			osw = new OutputStreamWriter(out);
			bw = new BufferedWriter(osw);
			try {
				bw.write("¾È´¨");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}
	}
}