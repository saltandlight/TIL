package db;

public class UserBiz extends Biz {
	
	DaO dao;
	
	public UserBiz(String ip) {
		dao=new UserDaO(ip); //�� �κ��� UserDaO ���� ��� ��
		
	}
	
	
	
	@Override
	public void register(Object obj) {
		// Transaction start ...
		//�ֱ� ���� �����͸� ������.
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
