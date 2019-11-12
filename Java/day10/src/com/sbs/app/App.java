package com.sbs.app;

import java.util.ArrayList;
import java.util.Scanner;

import com.sbs.component.UserBiz;
import com.sbs.frame.Biz;
import com.sbs.vo.User;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		out:
		while(true) {
			System.out.println("MENU:r,g...");
			String cmd = sc.next();

			Biz<String, User> ubiz = new UserBiz();
			ArrayList<User> list =null;
			switch(cmd) {
			case "r": 
				System.out.println("Input User Info");
				String id=sc.next();
				String pwd=sc.next();
				String name=sc.next();
				User u1 = new User(id, name, pwd);
				try {
					ubiz.register(u1);
				
				}catch(Exception e) {
					System.out.println("Insert Error");
					System.out.println(e.getMessage());
				}
				break;
			case "g": 
				try {
					list = ubiz.get();
					for(User u:list) {
						System.out.println(u);
					}
				}catch(Exception e) {
					System.out.println("Get Error");
				}
				break;
			case "q": 
				System.out.println("Bye..");
				break out;
			}
		}
		sc.close();

	}

}
