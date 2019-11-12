package car;

public class Car { 
	//�������� ����. �ɵ����� ���̰� �ƴ�. �긦 �������� �����̰� �ϰ� �������� �� ������ ���¸� ���� ���� ��.
	//attribute
	//�⺻������  attribute�� private���� ���� ����
	private String name;
	private String color;
	private int fSize;  //�ִ�ġ
	private int cfSize;
	//=defaultSize*2; //���� ��
	private int speed;
	private int maxSpeed;
	private int defaultSize=100;
	private static int serial=1;
	private static int count=0;
	//�⸧�� �ְ� �� �� ���ǵ尡 �ö󰡸鼭 �⸧�� ���� �ش�.
	
	// initialization block - Car c = new Car(); �ÿ� �Ͼ.
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
	public Car() { //default; argument�� �ƹ��͵� ���� ��.
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
	//overload: �Լ����� ������ �Ű������� �ٸ� ��� ���� ���� ��������..
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
	public void setCfSize(int cfSize) throws Exception { //java�� ����
		//�� �Լ��� ����� ���� ������ �߻��� �� �ֽ��ϴ�.(�ǹ�)
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
		//level 1~5(�����ϰ� �ڵ��� �κ�), �������� �ڵ� generate�Ǽ� ���ƿ�.
		//�̷� �Լ��� �� �����ϴ� ����� �� ������ �� �ϴ� ���.
		//�ӵ��� �ø��� �⸧�� ���߱�
		//speed up 1:10km
		// fuel down 1L 10km
		switch(level) { //direct�� ���� �־��ָ� ���������Ͱ� �� ������ �ִ�.
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
		//String ���·� return 
	}
	
	
}
