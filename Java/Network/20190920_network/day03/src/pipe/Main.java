package pipe;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputThread it=new InputThread("");
		OutputThread ot = new OutputThread("");
		it.connect(ot.getOutput());
		
		it.start();
		ot.start();
		
	}

}
