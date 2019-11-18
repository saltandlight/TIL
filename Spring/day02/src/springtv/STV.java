package springtv;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("stv")
public class STV implements TV {
	String status;
	int volume;
	//자동적으로 Speaker 타입의 객체를 가지고 옴
	//Speaker 타입 객체 Component가 2개 이상이면 이게 안 먹힘(Autowired)
	//이럴 때는 Qualifier이용(추가적으로 써주기)
	//그런데 좀 번거로워서 Resource를 씀(해당 객체 가져올 수 있다.)
	@Autowired
	Speaker speaker;
	//lose coupling: 뭐가 들어올 지 모름, 아직 구체적인 스피커를 써주지 않았음.
	
	
	public STV() {
		System.out.println("Constructor STV ...");
	}

	
	@Override
	public void turnOn() {
		this.status = "STV ON";
	}

	@Override
	public void turnOff() {
		this.status = "STV OFF";
	}

	@Override
	public void volumeUp(int v) {
		speaker.up();
	}

	@Override
	public void volumeDown(int v) {
		speaker.down();
	}
	@Override
	public String toString() {
		return "STV [status=" + status + ", volume=" + volume + "]";
	}
	
	
	
	
}




