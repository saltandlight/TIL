package shape;

public class Rectangle extends Shape {
    private int width;
    private int height;
    
    
	public Rectangle() {
	}

	public Rectangle(Point point) {
		super(point);
		// TODO Auto-generated constructor stub
	}

	public Rectangle(Point point, int width, int height) {
//		super();
		super(point);
		this.width = width;
		this.height = height;
	}

	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public double getArea() {
		return width*height;
	}

	@Override
	public double getCircume() {
		return (width+height)*2;
	}

	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + ", point="+this.getPoint()+"]";
	}

}
