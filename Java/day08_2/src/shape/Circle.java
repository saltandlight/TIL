package shape;

public class Circle extends Shape{
    private int radius;
    private String color;
    
	public Circle() {
		// TODO Auto-generated constructor stub
	}

	public Circle(int radius) {
		super();
		this.radius = radius;
	}


	public Circle(Point point, int radius) {
		super(point);
		this.radius = radius;
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", color=" + color + ", point=" + point + "]";
	}

	public Circle(Point point, int radius, String color) {
		super(point);
		this.radius = radius;
		this.color = color;
	}


	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public void fillColor(String color) {
		this.color=color;
	}


	@Override
	public double getArea() {
		return Math.PI*radius*radius;
	}


	@Override
	public double getCircume() {
		return 2*Math.PI*radius;
	}
	
}
