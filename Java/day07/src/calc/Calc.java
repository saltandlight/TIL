package calc;

public class Calc {

	private int[] data;
		
	public Calc() {
		;
	}
	
	public Calc(int[] data) {
		this.data=data;
	}
	//1. Sum 
	public int sum() {
		int sum=0;
		for(int temp:data) {
			sum+=temp;
		}
		return sum;
	}
	public double avg() {
		int size=data.length;
		double avg=(double)sum()/size;
		return avg;
	}
	//2. Sort(오름차순)
	public int[]  asort() {
		for(int i=0;i<data.length;i++) {
			for(int j=i+1;j<data.length;j++) {
				if(data[i] > data[j]) {
					int temp=data[i];
					data[i]=data[j];
					data[j]=temp;
				}
			}
		}
		return data;
	}
	//3. Sort(내림차순)
	public int[] dsort() {
		for(int i=0;i<data.length;i++) {
			for(int j=i+1;j<data.length;j++) {
				if(data[i] < data[j]) {
					int temp=data[i];
					data[i]=data[j];
					data[j]=temp;
				}
			}
		}
		return data;
	}
}
