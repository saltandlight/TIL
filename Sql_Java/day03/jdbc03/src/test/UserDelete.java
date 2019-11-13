package test;

import com.UserBiz;

import frame.Biz;
import vo.User;

public class UserDelete {
	public static void main(String[] args) {
//		User u = new User("id23", "pwd97", "Çï·Î");
		Biz<String, User> biz = new UserBiz();
		try {
			biz.remove("id23");
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
