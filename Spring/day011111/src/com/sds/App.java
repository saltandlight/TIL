package com.sds;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class App {
	public static void main(String[] args) {

		AbstractApplicationContext factory = new GenericXmlApplicationContext("myspr.xml");
		System.out.println("Spring started");

		// tight coupling
		// spring���� �̸� ��û-> �ش� ��ü�� ������
		Biz ubz = (Biz) factory.getBean("ub1");
		// size�� Ŭ�������� �־��ִ� ��=�������ش�.
		ubz.register();
		//System.out.println(u/z);

		
		
	}

}
