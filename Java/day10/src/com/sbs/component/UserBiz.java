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
			//insert���� ���� �߻�-> Ʈ����� ���尡 ���� �� ��-> ������ ���ᰡ ���� ���� ����
		}catch(Exception e) {
			throw e;
		}finally {
			transactionEnd(); //�ᱹ�� ����Ǹ� �긦 �����Ѵٴ� ��
		}
//		transactionEnd();
		
	}

	@Override
	public void remove(String k) throws Exception {
		transactionStart();
		try {
			dao.delete(k);
			//insert���� ���� �߻�-> Ʈ����� ���尡 ���� �� ��-> ������ ���ᰡ ���� ���� ����
		}catch(Exception e) {
			throw e;
		}finally {
			transactionEnd(); //�ᱹ�� ����Ǹ� �긦 �����Ѵٴ� ��
		}
		
	}

	@Override
	public void modify(User v) throws Exception {
		checkData(v);
		transactionStart();
		try {
			dao.update(v);
			//insert���� ���� �߻�-> Ʈ����� ���尡 ���� �� ��-> ������ ���ᰡ ���� ���� ����
		}catch(Exception e) {
			throw e;
		}finally {
			transactionEnd(); //�ᱹ�� ����Ǹ� �긦 �����Ѵٴ� ��
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
