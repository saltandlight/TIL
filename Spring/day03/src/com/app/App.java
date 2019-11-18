package com.app;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.frame.Biz;
import com.frame.Search;
import com.vo.Product;
import com.vo.User;

public class App {
	public static void main(String[] args)  {

		AbstractApplicationContext factory = new GenericXmlApplicationContext("myspring.xml");
		System.out.println("Spring started");

		// tight coupling
		// spring���� �̸� ��û-> �ش� ��ü�� ������
		
		Search<String, User> ubiz = (Search<String, User>)factory.getBean("ubiz"); 
		Biz<String, User> userv = (Biz<String, User>) factory.getBean("ubiz");
			// size�� Ŭ�������� �־��ִ� ��=�������ش�.
		User user = null;
		
		
		/*
		try {
			userv.insert(new User("id11","pwd1","����"));
			System.out.println("Inserted ...");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	   
		*/
		try {
			userv.update(new User("id11", "pwd11", "������"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	    
		/*
		try {
			userv.delete("asdfasdfasd");
			System.out.println("id�� "+"asdfasdfasd�� ȸ���� �����մϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		/*
		try {
			user=userv.select("id06");
			System.out.println(user.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		/*
		ArrayList<User> list = new ArrayList();
		try {
			list=ubiz.search("��");
			for(User item:list) {
				System.out.println(item.toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		/*
		Biz<Integer, Product> prbiz = (Biz<Integer, Product>) factory.getBean("pbiz");
		// size�� Ŭ�������� �־��ִ� ��=�������ش�.
		Product prd = null;
		
		prd=new Product("redshirt", 20000, "red_shirt.jpg");
		try {
			prbiz.insert(prd);
			System.out.println("Inserted..."+prd.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		/*
		prd = new Product(3, "yellowshirt", 200000, "yellow_shirt.jpg");
	    try {
			prbiz.update(prd);
			System.out.println("���� ��: "+prd.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		try {
			prbiz.delete(111);
			System.out.println("Deleted...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			prd=prbiz.select(1);
			System.out.println(prd.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		*/
		
		/*
		ArrayList<Product> list=new ArrayList<Product>();
		
		try {
			list=prbiz.select();
			for(Product it:list) {
				System.out.println(it.toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			*/
		factory.close();
	}

}
