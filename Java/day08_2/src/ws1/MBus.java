package ws1;

public class MBus extends Bus {
	
	protected boolean multi_fl;
	
	public MBus() {
		
	}
	
	public MBus(int i, String string, int j, boolean multi_fl) {
		super(i, string ,j);
		this.multi_fl=multi_fl;
	}
	
	public void switch_multi() {
		multi_fl=!multi_fl;
//		return multi_fl;s
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
		return "MBus [multi_fl=" + multi_fl + ", fare=" + fare + ", id=" + id + ", line=" + line + ", spoint=" + spoint
				+ ", epoint=" + epoint + ", calDist()=" + calDist() + "]";
	}




	
}
