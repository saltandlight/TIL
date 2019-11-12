package pipe;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Scanner;

public class OutputThread extends Thread{
	PipedWriter output;
	
	public OutputThread(String name) {
		super(name);
		output = new PipedWriter();
	}
	
	public void run() {
		try {
			while(true) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Input Send Message:");

				String msg = sc.nextLine();
				System.out.println("sent:"+msg);
				output.write(msg);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			if(output!=null) {
				try {
					output.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public PipedWriter getOutput() {
		return output;
	}
	
	public void connect(PipedReader input) {
		try {
			output.connect(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}





