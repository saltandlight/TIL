package test;

import java.util.ArrayList;

import com.UserDao;

import frame.Dao;
import vo.User;

public class UserSelectAll {

	public static void main(String[] args) {
		Dao<String, User> dao = new UserDao();
		try {
			ArrayList<User> list = new ArrayList<>();
			list=dao.select();
			for(User us:list) {
				System.out.println(us.toString());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
