package ws2;

public class Otab extends Mobile{
	
	public Otab() {
		super();
	}
	
	public Otab(String mobileName, int batterySize, String osType) {
		super(mobileName, batterySize, osType);
	}
	
	@Override
	public int operate(int time) {
		this.setBatterySize(this.getBatterySize() - time*12);
		
		return this.getBatterySize();
	}
	
	@Override
	public int charge(int time) {
		// TODO Auto-generated method stub
		this.setBatterySize(this.getBatterySize() + time*8);
		return this.getBatterySize();
	}
}
