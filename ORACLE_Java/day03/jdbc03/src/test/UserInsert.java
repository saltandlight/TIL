package test;

import com.UserBiz;

import frame.Biz;
import vo.User;

public class UserInsert {

	public static void main(String[] args) {
		User u = new User("id101", "pwd22", "¿Ã∏ª");
		Biz<String, User> biz = new UserBiz();
		try {
			biz.register(u);
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
