package com.sds;

public class UserBiz implements Biz{

	Dao dao;
	


	public Dao getDao() {
		return dao;
	}



	public void setDao(Dao dao) {
		this.dao = dao;
	}



	@Override
	public void register() {
		dao.insert();
	}

	
	
}
