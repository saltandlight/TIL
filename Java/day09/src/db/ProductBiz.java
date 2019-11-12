package db;

public class ProductBiz extends Biz{
	ProductDaO p_dao;
	public ProductBiz(String ip) {
		p_dao=new ProductDaO(ip);
	}
	@Override
	public void register(Object obj) {
		// Transaction started
		p_dao.insert(obj);
		// Transaction close
		
	}
	@Override
	public void remove(Object obj) {
		// Transaction started
		p_dao.delete(obj);
		// Transaction close
		
	}
	@Override
	public Object get(Object obj) {
		Product prd=null;
		// Transaction started
		prd = (Product)p_dao.select(obj);
		p_dao.select(obj);
		// Transaction close
		return prd;
	}
	
}
