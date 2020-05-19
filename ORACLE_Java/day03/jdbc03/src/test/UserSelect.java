package test;

import com.UserBiz;
import com.UserDao;

import frame.Biz;
import frame.Dao;
import vo.User;

public class UserSelect {

	public static void main(String[] args) {
		
		Biz<String, User> biz = new UserBiz();
		try {
			System.out.println(biz.get("id02"));
			
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
