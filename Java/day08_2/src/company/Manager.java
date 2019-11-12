package company;

public class Manager extends Employee{
	private double incentive;

	public Manager() {
	}

	public Manager(String id, String name, double salary, String dept, double incentive) {
//		super(id, name, salary, dept); 
		this.id=id;
		this.name=name;
		this.salary=salary;
		this.dept=dept;
		//���� Ŭ������ ���� �ִ� constructor �� �̿��ϰڴ�. 
		this.incentive = incentive;
	}
	//������(Overriding -�������̵�)

	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", salary=" + salary + ", dept=" + dept + ", incentive="
				+ incentive + "]";
	}

	
	
	@Override
	public double salaryM() {
		// TODO Auto-generated method stub
		double money = 0;
		money = super.salaryM() + this.incentive;
		return money;
	}

	@Override
	public double annSalary() {
		double money= super.annSalary()+this.incentive*12;
		return money;
	}

	
	
}
