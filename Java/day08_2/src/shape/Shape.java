package shape;

public abstract class Shape {
	protected Point point;

	public Shape() {
	}

	public Shape(Point point) {
		this.point = point;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "Shape [point=" + point + "]";
	}
	
	public abstract double getArea(); // 하위 클래스에서 꼭 구현해야 함.
	public abstract double getCircume(); 
	
	public void movePoint(int mv_x, int mv_y) {
		this.point.setX(mv_x);
		this.point.setY(mv_y);
	}
}
