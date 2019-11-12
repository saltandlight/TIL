package com.sbs.test;

import java.util.ArrayList;

import com.sbs.component.UserBiz;
import com.sbs.frame.Biz;
import com.sbs.vo.User;

public class UserSelectAll {

	public static void main(String[] args) {
		Biz<String, User> biz = new UserBiz();
		ArrayList<User> list =null;
		try {
			list = biz.get();
			for(User u:list) {
				System.out.println(u);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
