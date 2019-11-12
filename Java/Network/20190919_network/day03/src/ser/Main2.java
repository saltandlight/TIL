package ser;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Main2 {

	public static void main(String[] args) 
	throws Exception{
		FileInputStream 
		fis= new FileInputStream("user.dat");
		BufferedInputStream 
		bis = new BufferedInputStream(fis);
		ObjectInputStream
		ois = new ObjectInputStream(bis);
		
		
		User user = (User)ois.readObject();
		
		System.out.println(user.toString());

		ois.close();
	}

}
