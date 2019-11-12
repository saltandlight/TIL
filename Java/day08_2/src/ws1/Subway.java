package ws1;

public class Subway extends Transportation{
	
	protected boolean express;
	
	
	public Subway(int fare, String id, int line, boolean express) {
		super(fare, id, line);
		this.express = express;
	}

	public Subway(boolean express) {
		super();
		this.express = express;
	}

	public boolean isExpress() {
		return express;
	}

	public void setExpress(boolean express) {
		this.express = express;
	}

	@Override
	public int calFare() {
		if(calDist()<10) {
			return this.fare;
		}
		else {
			this.fare+=(calDist()-10)/5*100;
			return this.fare;
		}
	}

	@Override
	public String toString() {
		return "Subway [express=" + express + ", fare=" + fare + ", id=" + id + ", line=" + line + ", spoint=" + spoint
				+ ", epoint=" + epoint + ", calDist()=" + calDist() + "]";
	}


	
}
