package time;

import java.util.Calendar;

public class Time {
	private int hour;
	private int min;
	private int sec;
	private String date;
	private boolean set;
	
	Time(){
		Calendar cal = Calendar.getInstance();
		//현재 (시,분,초)
		hour = cal.get ( cal.HOUR_OF_DAY ) ;
		min = cal.get ( cal.MINUTE );
		sec = cal.get ( cal.SECOND );
		
		date="월";
		set=false;
	}
	
	Time(int hour, int min, int sec, String date) {
		this.hour = hour;
		this.min = min;
		this.sec = sec;
		this.date = date;
	}
	
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getSec() {
		return sec;
	}
	public void setSec(int sec) {
		this.sec = sec;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public boolean isSet() {
		return set;
	}
	public void setSet(boolean set) {
		this.set = set;
	}
	


}
