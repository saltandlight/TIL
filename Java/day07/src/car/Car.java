package car;

public class Car { 
	//수동적인 아이. 능동적인 아이가 아님. 얘를 누군가가 움직이게 하고 누군가는 그 움직인 상태를 보고 싶은 것.
	//attribute
	//기본적으로  attribute는 private으로 들어가야 맞음
	private String name;
	private String color;
	private int fSize;  //최대치
	private int cfSize;
	//=defaultSize*2; //현재 값
	private int speed;
	private int maxSpeed;
	private int defaultSize=100;
	private static int serial=1;
	private static int count=0;
	//기름을 넣고 갈 때 스피드가 올라가면서 기름의 양이 준다.
	
	// initialization block - Car c = new Car(); 시에 일어남.
	{
//		cfSize=defaultSize*2;
//		if(cfSize<=0) {
//			cfSize=0;
//		}
//		cfSize++;
		count++;
		serial=count;
	}
	static {
//		serial*=1000;
		count*=1000;
	}
	
	
	
	
	//constructor
	public Car() { //default; argument가 아무것도 없는 것.
		this.name="K1";
		this.color="red";
		this.fSize=50;
		this.maxSpeed=50;
	}
	public Car(String name, String color, int fSize) {
		this.name = name;
		this.color = color;
		this.fSize = fSize;
	}
	
	public Car(String name, String color, int fSize, int maxSpeed) {
		this.name = name;
		this.color = color;
		this.fSize = fSize;
		this.maxSpeed = maxSpeed;
	}
	public Car(String name, String color, int fSize, int cfSize, int speed) {
		this.name = name;
		this.color = color;
		this.fSize = fSize;
		this.cfSize = cfSize;
		this.speed = speed;
	}
	//overload: 함수명은 같지만 매개변수가 다를 경우 에러 없고 성공적임..
	//function
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getfSize() {
		return fSize;
	}
	public void setfSize(int fSize) {
		this.fSize = fSize;
	}
	public int getCfSize() {
		return cfSize;
	}
	public void setCfSize(int cfSize) throws Exception { //java의 강점
		//이 함수를 사용할 때는 문제가 발생할 수 있습니다.(의미)
		if((this.cfSize+cfSize) > fSize) {
			throw new Exception();
		}
		this.cfSize += cfSize;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		if(this.maxSpeed < speed) {
			this.speed = maxSpeed;
			return;
		}
		this.speed = speed;
	}
	
	public void go(int level) {
		//level 1~5(개발하고 코딩할 부분), 나머지는 자동 generate되서 날아옴.
		//이런 함수를 잘 설계하는 사람이 이 업무를 잘 하는 사람.
		//속도를 올리고 기름을 낮추기
		//speed up 1:10km
		// fuel down 1L 10km
		switch(level) { //direct로 값을 넣어주면 오류데이터가 들어갈 여지가 있다.
		case 1: this.setSpeed(20);
				this.cfSize -= 1;
				break;
		case 2: this.setSpeed(40);
				this.cfSize -= 2;
				break;
		case 3: this.setSpeed(60);
				this.cfSize -= 3;
				break;
		case 4: this.setSpeed(80);
				this.cfSize -= 4;
				break;
		case 5: this.setSpeed(100);
				this.cfSize -= 5;
				break;
		default: break;
		}
		
	}
	
	public void stop() {
		this.speed=0;
	}
	
	@Override
	public String toString() {
		return "Car [name=" + name + ", color=" + color + ", fSize=" + fSize + ", cfSize=" + cfSize + ", speed=" + speed
				+ "]";
		//String 형태로 return 
	}
	
	
}
