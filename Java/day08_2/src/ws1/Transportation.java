package ws1;

public abstract class Transportation {
	
	protected int fare;
	protected String id;
	protected int line;
	protected Coordination spoint;
	protected Coordination epoint;
	
	
	
	public Transportation() {
		this.spoint = new Coordination();
		this.epoint = new Coordination();
	}

	public Transportation(int fare, String id, int line) {
		
		this.spoint = new Coordination();
		this.epoint = new Coordination();
		this.fare = fare;
		this.id = id;
		this.line = line;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}


	@Override
	public String toString() {
		return "Transportation [fare=" + fare + ", id=" + id + ", line=" + line + ", spoint=" + spoint + ", epoint="
				+ epoint + "]";
	}

	public abstract int calFare();
	
	public double calDist() {
		double dist = 0.0;
		dist = Math.hypot(epoint.getX()-spoint.getX(), epoint.getY()-spoint.getY());
		return dist;
	}
	
	public void move(int x, int y) {
		this.epoint.setX(x);
		this.epoint.setY(y);
	}
	
	
}
