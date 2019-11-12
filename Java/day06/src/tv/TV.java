package tv;

public class TV {
  //attribute
  private String color;
  private boolean power;
  private int channel;
  //public: �����Ӱ� ��𼭵� ������ ������ ����(ĸ��ȭ�� �� ��)
  //private: ĸ��ȭ
  //default: ���� ��Ű�� �������� ������ ����(ĸ��ȭ�� �� ��)
  //constructor:Ŭ���� �̸��� �����ѵ� �Լ��� 
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
	// ���� �� ������ �Ѵ�. 
	// �÷��� �� ���� ���ؼ� �����Ѵ�.(red, blue, green)
	if(color.equals("") || color == null) {
	  return; //�߸� ���� ���� ���´�. 
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
