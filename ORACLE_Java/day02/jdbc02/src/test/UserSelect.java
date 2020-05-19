package test;

import com.UserDao;

import frame.Dao;
import vo.User;

public class UserSelect {

	public static void main(String[] args) {
		Dao<String, User> dao = new UserDao();
		try {
			System.out.println(dao.select("id02"));
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
