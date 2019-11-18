package com.sds;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class App {
	public static void main(String[] args) {

		AbstractApplicationContext factory = new GenericXmlApplicationContext("myspr.xml");
		System.out.println("Spring started");

		// tight coupling
		// spring에게 이름 요청-> 해당 객체를 가져옴
		Biz ubz = (Biz) factory.getBean("ub1");
		// size를 클래스내에 넣어주는 것=주입해준다.
		ubz.register();
		//System.out.println(u/z);

		
		
	}

}
