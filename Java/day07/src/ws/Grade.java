package ws;

public class Grade {
	int [] data;
	
	Grade(){
		;
	}
	Grade(int[] data){
		this.data=data;
	}
	
	//���� ���ϴ� �Լ� 
	int sum() {
		int sum=0;
		for(int temp: data) {
			sum += temp;
		}
		return sum;
	}
	
	//����� ���ϴ� �Լ�
	double avg() {
		double avg=(double)sum()/data.length;
		return avg;
	}
	//������ ����ϴ� �Լ�(char�� ����)
	char prc_grade() {
		// ����� 90�� �̻��̸� A, 80�� �̻��̸� B, 70�� �̻��̸� C, 60�� �̻��̸� D, ���ϸ� F
		double avg=avg();
		if(avg>=90) return 'A';
		else if(avg>=80) return 'B';
		else if(avg>=70) return 'C';
		else if(avg>=60) return 'D';
		else return 'F';
	}
	//String ���� ���� �Լ�
	String sub_rt(int idx) {
		String sub_name="";
		switch(idx) {
		case 0: sub_name="����"; break;
		case 1: sub_name="����"; break;
		case 2: sub_name="����"; break;
		case 3: sub_name="����"; break;
		}
		return sub_name;
	}
	//Max �� ���� �ε��� ����
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
	
	//Min �� ���� �ε��� ����
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
	//�������� ����
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
	//�������� ����
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
