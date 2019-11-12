package day03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class Fi3 {

	public static void main(String[] args) throws Exception{
		String fileName="C:\\network\\day03\\test.txt";

		FileReader fr = new FileReader(fileName);
		BufferedReader bis = new BufferedReader(fr);
		

		FileWriter fos=new FileWriter("C:\\network\\day03\\test3.txt");
		BufferedWriter bos = new BufferedWriter(fos);

		String data=null;
		while((data=bis.readLine())!=null) {
			System.out.println(data);
			bos.write(data);
			bos.newLine();
		}
		if(bis != null) {
			bis.close();
		}
		if(bos !=null) {
			bos.close();
		}
	}

}
