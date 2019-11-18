package com.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.frame.Biz;
import com.product.Product;
import com.user.User;

public class App {
	public static void main(String[] args)  {

		AbstractApplicationContext factory = new GenericXmlApplicationContext("myspring.xml");
		System.out.println("Spring started");

		// tight coupling
		// spring에게 이름 요청-> 해당 객체를 가져옴
		Biz<String, User> biz = (Biz<String, User>) factory.getBean("ubiz");
			// size를 클래스내에 넣어주는 것=주입해준다.
		User user = null;
		
/*
		try {	
			user = biz.select("id00");
			System.out.println(user.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	*/	 
			
		
		User user1 = new User("id01","pwd01","이말자");

		
		try {
			biz.insert(user1);
			System.out.println("Inserted Ok From app.");
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		factory.close();
	
	}

}
