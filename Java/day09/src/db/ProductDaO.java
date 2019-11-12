package db;

public class ProductDaO extends DaO{
	
	public ProductDaO() {
		
	}
	
	public ProductDaO(String ip){
		super(ip);
	}
	@Override
	public void insert(Object obj) {
		connection();
		Product prd=(Product)obj;
		System.out.println(prd.getId()+" "+
				prd.getName()+" "+
				prd.getPrice()+" Inserted...");
		close();
		
	}

	@Override
	public Object select(Object obj) {
		Product prd = null;
		String str = (String)obj;
		
		connection();
		prd= new Product("id02","speaker1",20000);
		close();
		return prd;
	}

	@Override
	public void delete(Object obj) {
		String str = (String)obj;
		connection();
		System.out.println(str+"Deleted...");
		close();
		
	}

}
