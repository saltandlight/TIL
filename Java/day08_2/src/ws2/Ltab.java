package ws2;

public class Ltab extends Mobile{
		
	public Ltab() {
		super();
	}
	
	public Ltab(String mobileName, int batterySize, String osType) {
		super(mobileName, batterySize, osType);
	}
	
	@Override
	public int operate(int time) {
		this.setBatterySize(this.getBatterySize() - time*10);
		
		return this.getBatterySize();
	}

	@Override
	public int charge(int time) {
		// TODO Auto-generated method stub
		this.setBatterySize(this.getBatterySize() + time*10);
		return this.getBatterySize();
	}

	
}
