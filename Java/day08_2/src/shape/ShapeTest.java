package shape;

public class ShapeTest {

	public static void main(String[] args) {
//		Shape s = new Shape(new Point(10,10));
//		Shape s1 = new Circle(new Point(1,1),5);
		
		//heterogeneous Collection(다차원적)
		Shape s[] = new Shape[3];
		s[0]=new Circle(new Point(1,1),5);
		s[1]=new Triangle(new Point(2,2),5,6);
		s[2]=new Rectangle(new Point(3,3),5,6);
		
		//Polymorphism
		for(Shape sh:s) {
			sh.movePoint(5,5);
			if(sh instanceof Circle) {// 현재 배열에 들어가있는 도형 중에 그 아이가 Circle이면~
				Circle c = (Circle)sh;//c와 sh는 타입이 다를 뿐, 주소가 같다. 
				c.fillColor("red");
			}
			System.out.println(sh.toString());
			System.out.println(sh.getArea());
			System.out.println(sh.getCircume());
		}
	}

}
