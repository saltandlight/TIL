package com.sbs.test;

import com.sbs.component.UserBiz;
import com.sbs.frame.Biz;
import com.sbs.vo.User;

public class UserInsert {
//당위 테스트
	public static void main(String[] args) {
		Biz<String, User> biz = new UserBiz();
		User u1 = new User("id02", "jame","pwd01");
		try {
			biz.register(u1);
		}catch(Exception e) {
			System.out.println("Insert Error");
			System.out.println(e.getMessage());
		}
		
	}

}
