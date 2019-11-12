package tcp1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	int port;
	ServerSocket serverSocket;
	Socket socket;
	// 네트워크를 하기 위해 양쪽 다 있어야 함

	OutputStream out;
	OutputStreamWriter osw;
	BufferedWriter bw;

	
	
	boolean flag = true;

	public Server(int port) throws IOException {
		this.port = port;
		serverSocket = new ServerSocket(port);

	}

	public void startServer() throws IOException {
		System.out.println("Server Start..");
		while (flag) {
			try {
				System.out.println("Server Ready..");
				socket = serverSocket.accept();
				System.out.println("Accepted.." + socket.getInetAddress());

				out = socket.getOutputStream();
				osw = new OutputStreamWriter(out);
				bw = new BufferedWriter(osw);
				bw.write("안뇽");
			} catch (IOException e) {
				throw e;
			} finally {
				if (bw != null) {
					bw.close();
				}
				if (socket != null) {
					socket.close();
				}
			}
		}
		System.out.println("Server end..");
	}

	public static void main(String[] args) {
		Server server = null;
		try {
			server = new Server(8888);
			server.startServer();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
