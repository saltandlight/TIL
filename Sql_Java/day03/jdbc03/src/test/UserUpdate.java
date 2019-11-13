package test;

import com.UserBiz;

import frame.Biz;
import vo.User;

public class UserUpdate {

	public static void main(String[] args) {
		User u = new User("id79", "pwd01", "피우피우");
		Biz<String, User> biz = new UserBiz();
		try {
			biz.modify(u);
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
