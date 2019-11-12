package com.sbs.component;

import java.util.ArrayList;

import com.sbs.frame.Biz;
import com.sbs.frame.Dao;
import com.sbs.vo.User;

public class UserBiz extends Biz<String, User> {
	
	Dao<String, User> dao;
	
	public UserBiz() {
		dao = new UserDao();	
	}
	
	@Override
	public void register(User v) throws Exception {
		checkData(v);
		transactionStart();
		try {
			dao.insert(v);
			//insert에서 에러 발생-> 트랜잭션 엔드가 실행 안 됨-> 정상적 종료가 되지 않은 상태
		}catch(Exception e) {
			throw e;
		}finally {
			transactionEnd(); //결국에 실행되면 얘를 실행한다는 뜻
		}
//		transactionEnd();
		
	}

	@Override
	public void remove(String k) throws Exception {
		transactionStart();
		try {
			dao.delete(k);
			//insert에서 에러 발생-> 트랜잭션 엔드가 실행 안 됨-> 정상적 종료가 되지 않은 상태
		}catch(Exception e) {
			throw e;
		}finally {
			transactionEnd(); //결국에 실행되면 얘를 실행한다는 뜻
		}
		
	}

	@Override
	public void modify(User v) throws Exception {
		checkData(v);
		transactionStart();
		try {
			dao.update(v);
			//insert에서 에러 발생-> 트랜잭션 엔드가 실행 안 됨-> 정상적 종료가 되지 않은 상태
		}catch(Exception e) {
			throw e;
		}finally {
			transactionEnd(); //결국에 실행되면 얘를 실행한다는 뜻
		}
		
	}

	@Override
	public User get(String k) throws Exception {
		
		return dao.select(k);
	}

	@Override
	public ArrayList<User> get() throws Exception {
		// TODO Auto-generated method stub
		return dao.select();
	}

}
