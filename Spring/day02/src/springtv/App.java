package springtv;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		System.out.println("Spring Start...");
		
		AbstractApplicationContext factory = 
		new GenericXmlApplicationContext("mytv.xml");
		//얘가 실행되면서 Spring Container가 만들어짐.
		//만들어질 떄 xml을 보고 만듦.
		//일반적인 자바 클래스가 POJO에서 돈다.
		//spring container를 만드는 작업을 함.
		
		System.out.println("Spring Started");
		
		//나 tv줄래? -> Spring
		//해당하는 객체가 튀어나옴. 
		TV stv = (TV)factory.getBean("stv");
		stv.turnOn();
		stv.volumeUp(10);
		System.out.println(stv);
		
	
		
		factory.close();
	}

}
