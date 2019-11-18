package com.user;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.frame.Biz;
import com.frame.Dao;
import com.frame.Search;
import com.vo.User;

@Repository("ubiz")
public class UserBiz implements Biz<String, User>,
Search<String, User>{

	@Resource(name="uod")
	Dao<String, User> dao;
	
	@Resource(name="uod")
	Search<String, User> search;
	
	
	@Transactional
	@Override
	public void insert(User v) throws Exception {
		
		dao.insert(v);
	}

	@Override
	public void update(User v) throws Exception {
		dao.update(v);
	}

	@Override
	public void delete(String k) throws Exception {
		dao.delete(k);
	}

	@Override
	public User select(String k) throws Exception {
		/*
		if(k.equals("id00")) {
			throw new Exception("Not Found Exception..");
		}
		*/
		return dao.select(k);
	}

	@Override
	public ArrayList<User> select() throws Exception {
		
		return dao.select();
	}

	@Override
	public ArrayList<User> search(String k) {
	
		return search.search(k);
	}



}
