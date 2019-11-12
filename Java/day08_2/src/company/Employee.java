package company;

public class Employee {
	protected String id;
	protected String name;
	protected double salary;
	protected String dept; //����Ŭ�������� �����Ӱ� ������ ����
	
	//constructor
	public Employee() {
		
		
	}
	
	public Employee(String id, String name, double salary, String dept) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.dept = dept;
	}
	
	//getter and setter
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public String getDept() {
		return dept;
	}
	
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	//toString
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", dept=" + dept + "]";
	}
	
	//���ݾ�
	public double salaryM() {
		//�� �����ؾ� �� �ݾ��� �󸶳�
		double money=0, temp=0;
		
		// 4�� ����� 8.4% ����
		// ���� 3.2% ����
		
		temp += this.salary * 0.084;
		temp += this.salary*0.032;
		money=this.salary-temp;
		return money;
		
	}
	
	public double annSalary() {
		double money=this.salaryM()*12;
		return money;
	}
	
	
}
