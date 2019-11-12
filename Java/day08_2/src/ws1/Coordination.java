package ws1;

public class Coordination {
	
	private int x = 0;
	private int y = 0;
	
	public Coordination() {
		this.x = 0;
		this.y = 0;
	}

	public Coordination(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Coordination [x=" + x + ", y=" + y + "]";
	}
	
	

}
