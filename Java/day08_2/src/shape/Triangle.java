package shape;

public class Triangle extends Shape {
    private int width;
    private int height;
    
	public Triangle() {
		// TODO Auto-generated constructor stub
	}


	public Triangle(Point point) {
		super(point);
		// TODO Auto-generated constructor stub
	}


	public Triangle(Point point, int width, int height) {
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
		return (width*height)/2;
	}

	@Override
	public double getCircume() {
		double c = Math.sqrt(Math.pow(width,2)+Math.pow(height,2));
		return c+width+height;
	}

	@Override
	public String toString() {
		return "Triangle [width=" + width + ", height=" + height+ ", point="+this.getPoint()+"]";
	}

}
