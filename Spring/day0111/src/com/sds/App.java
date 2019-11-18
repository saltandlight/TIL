package com.sds;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		AbstractApplicationContext factory
		= new GenericXmlApplicationContext("myspring.xml");
		System.out.println("Spring started");
		
		
		
		//tight coupling
				//spring���� �̸� ��û-> �ش� ��ü�� ������
		TV tv=(TV)factory.getBean("stv");
		//size�� Ŭ�������� �־��ִ� ��=�������ش�.
		tv.up();
		System.out.println(tv);
		
		TV tv2=(TV)factory.getBean("ltv");
		//size�� Ŭ�������� �־��ִ� ��=�������ش�.
		tv2.up();
		System.out.println(tv2);
	}

}
