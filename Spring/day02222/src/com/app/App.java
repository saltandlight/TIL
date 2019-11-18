package com.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.frame.Biz;
import com.vo.Product;
import com.vo.User;

public class App {
	public static void main(String[] args)  {

		AbstractApplicationContext factory = new GenericXmlApplicationContext("myspring.xml");
		System.out.println("Spring started");

		// tight coupling
		// spring���� �̸� ��û-> �ش� ��ü�� ������
		Biz<String, User> userv = (Biz<String, User>) factory.getBean("ubiz");
			// size�� Ŭ�������� �־��ִ� ��=�������ش�.
		User user = null;
		
/*
		try {	
			user = biz.select("id00");
			System.out.println(user.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	*/	 
			
		
		User user1 = new User("id01","pwd01","�̸���");

		
		try {
			userv.insert(user1);
			System.out.println("Inserted Ok From app.");
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		
	
		Biz<Integer, Product> pbiz = (Biz<Integer, Product>) factory.getBean("pbiz");
		
		try {
			pbiz.delete(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	
		factory.close();
	
	}

}
