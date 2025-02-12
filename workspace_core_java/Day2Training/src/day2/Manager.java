package day2;

public class Manager extends Employee {
	private double salary;
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public Manager() {}
	
	public Manager(double salary) {
		this.salary = salary;
	}
	
	public Manager(int id, String name, double salary) {
//		super(id, name);
		this.salary = salary;
	}
	
	@Override
	public void acceptData(int id, String name, Department dept) {
		setEmpId(id);
		setEmpName(name);
		setDepartment(dept);
		
	}
	
	public void acceptData(int id, String name, Department dept, double salary) {
		setEmpId(id);
		setEmpName(name);
		setDepartment(dept);
		this.salary=salary;
	}
	
	
}
