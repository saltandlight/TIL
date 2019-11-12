package db;

public class UserBiz extends Biz {
	
	DaO dao;
	
	public UserBiz(String ip) {
		dao=new UserDaO(ip); //이 부분이 UserDaO 인지 얘는 모름
		
	}
	
	
	
	@Override
	public void register(Object obj) {
		// Transaction start ...
		//넣기 전에 데이터를 점검함.
		dao.insert(obj);
		//Transaction end ...
	}

	@Override
	public void remove(Object obj) {
		// Transaction start ...
		dao.delete(obj);
		//Transaction end ...
	}

	@Override
	public Object get(Object obj) {
		User user=null;
		// Transaction start ...
		user = (User)dao.select(obj);
		//Transaction end ...
		return user;
	}

}
