package ws1;

public class Bus extends Transportation{
	
	public Bus() {
		super();
	}
	
	
	public Bus(int i, String string, int j) {
		super(i, string ,j);
	}

	@Override
	public int calFare() {
		if(calDist()<10) {
			return this.fare;
		}
		else {
			this.fare += (calDist()-10)/5*100;
			return this.fare;
		}
	}


	@Override
	public String toString() {
		return "Bus [fare=" + fare + ", id=" + id + ", line=" + line + ", spoint=" + spoint + ", epoint=" + epoint
				+ ", calDist()=" + calDist() + "]";
	}



}
