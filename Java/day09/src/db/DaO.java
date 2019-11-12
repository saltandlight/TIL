package db;

public abstract class  DaO {
	private String ip;

	public DaO() {
		
	}
	public DaO(String ip) {
		this.ip = ip;
	}
	public void connection() {
		System.out.println(ip+":connected..");
	}
	public void close() {
		System.out.println(ip+":closed..");
	}
	public abstract void insert(Object obj);
	public abstract Object select(Object obj);
	public abstract void delete(Object obj);
	
}
