package pipe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.StringWriter;

public class InputThread extends Thread{
	PipedReader input;
	BufferedReader br;
	
	public InputThread(String name) {
		super(name);
		input = new PipedReader();
		br=new BufferedReader(input);
	}
	public void run() {
		String data = null;
		StringBuffer sb = new StringBuffer();
		try {
			while(true) {
				System.out.println("Ready");

				while((data = br.readLine()) != null) {
					sb.append(data);
				}
				System.out.println("Received:"+sb.toString());
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public PipedReader getInput() {
		return input;
	}
	public void connect(PipedWriter output) {
		try {
			input.connect(output);
			System.out.println("connected:");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}




