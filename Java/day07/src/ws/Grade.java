package ws;

public class Grade {
	int [] data;
	
	Grade(){
		;
	}
	Grade(int[] data){
		this.data=data;
	}
	
	//합을 구하는 함수 
	int sum() {
		int sum=0;
		for(int temp: data) {
			sum += temp;
		}
		return sum;
	}
	
	//평균을 구하는 함수
	double avg() {
		double avg=(double)sum()/data.length;
		return avg;
	}
	//학점을 계산하는 함수(char로 리턴)
	char prc_grade() {
		// 평균이 90점 이상이면 A, 80점 이상이면 B, 70점 이상이면 C, 60점 이상이면 D, 이하면 F
		double avg=avg();
		if(avg>=90) return 'A';
		else if(avg>=80) return 'B';
		else if(avg>=70) return 'C';
		else if(avg>=60) return 'D';
		else return 'F';
	}
	//String 과목 리턴 함수
	String sub_rt(int idx) {
		String sub_name="";
		switch(idx) {
		case 0: sub_name="국어"; break;
		case 1: sub_name="영어"; break;
		case 2: sub_name="수학"; break;
		case 3: sub_name="과학"; break;
		}
		return sub_name;
	}
	//Max 일 때의 인덱스 리턴
	String prc_max() {
		int idx=0, max=0;
		for(int i=0;i<data.length;i++) {
			  //0   29
			if(max <= data[i]) {
				idx=i;
				max=data[i];
			}
		}
		return sub_rt(idx);
	}
	
	//Min 일 때의 인덱스 리턴
	String prc_min() {
		int idx=0, min=200;
		String sub_name="";
		for(int i=0;i<data.length;i++) {
			if(min >= data[i]) {
				idx=i;
				min=data[i];
			}
		}
		return sub_rt(idx);
	}
	//오름차순 정렬
	int[] asort() {
		for(int i=0;i<data.length;i++) {
			for(int j=i+1;j<data.length;j++) {
				if(data[i]>data[j]) {
					int temp=data[i];
					data[i]=data[j];
					data[j]=temp;
				}
			}
		}
		return data;
	}
	//내림차순 정렬
	int[] dsort() {
		for(int i=0;i<data.length;i++) {
			for(int j=i+1;j<data.length;j++) {
				if(data[i]<data[j]) {
					int temp=data[i];
					data[i]=data[j];
					data[j]=temp;
				}
			}
		}
		return data;
	}
}
