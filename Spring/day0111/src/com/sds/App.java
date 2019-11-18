package com.sds;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		AbstractApplicationContext factory
		= new GenericXmlApplicationContext("myspring.xml");
		System.out.println("Spring started");
		
		
		
		//tight coupling
				//spring에게 이름 요청-> 해당 객체를 가져옴
		TV tv=(TV)factory.getBean("stv");
		//size를 클래스내에 넣어주는 것=주입해준다.
		tv.up();
		System.out.println(tv);
		
		TV tv2=(TV)factory.getBean("ltv");
		//size를 클래스내에 넣어주는 것=주입해준다.
		tv2.up();
		System.out.println(tv2);
	}

}
