package day03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Fi1 {

	public static void main(String[] args) {
		FileReader fi = null;
		BufferedReader br=null;
		//������ �������� �ѹ� �� ����
		try {
			fi=new FileReader("test.txt");
			br = new BufferedReader(fi);
			String data="";
			
			//byte ������ int���·�
			try {
				while((data=br.readLine()) != null) {
					//br.readLine�� ��Ʈ��
				
					System.out.println(data);
				}
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fi != null) {
				try {
					fi.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					try {
						Thread.sleep(20000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						fi.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
//					e.printStackTrace();
				}
			}
		}
		
	}

}
