package tv;

public class TV {
  //attribute
  private String color;
  private boolean power;
  private int channel;
  //public: 자유롭게 어디서든 변수에 접근이 가능(캡슐화가 안 됨)
  //private: 캡슐화
  //default: 같은 패키지 내에서만 접근이 가능(캡슐화가 안 됨)
  //constructor:클래스 이름과 동일한데 함수명 
  TV(){
	  color="red";
	  power=false;
	  channel=10;
  }
  
  TV(String color, boolean power, int channel){
	  this.color=color;
	  this.power=power;
	  this.channel=channel;
  }
  
  TV(String color){
	  this.color=color;
	  this.power=false;
	  this.channel=10;
  }
  
  //function
  public String getColor() {
	return color;
}

public void setColor(String color) {
	// 숫자 못 들어오게 한다. 
	// 컬러는 몇 개로 정해서 동작한다.(red, blue, green)
	if(color.equals("") || color == null) {
	  return; //잘못 들어온 것을 막는다. 
	}
	this.color = color;
}

public boolean isPower() {
	return power;
}

public void setPower(boolean power) {
	this.power = power;
}

public int getChannel() {
	return channel;
}

public void setChannel(int channel) {
	this.channel = channel;
}
  void power() {
	  power = !power;
  }
  void channelUp() {
	  channel++;
  }
  void channelDown() {
	  channel--;
  }
  @Override
  public String toString() {
	  return "TV [color=" + color + ", power=" + power + ", channel=" + channel + "]";
  }
}
