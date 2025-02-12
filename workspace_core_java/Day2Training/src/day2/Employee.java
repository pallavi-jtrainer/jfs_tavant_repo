package day2;

public abstract class Employee {
	private int empId;
	private String empName;
	private Department department;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public Department getDepartment() {
		return department;
	}
	
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public final void finalMethod() {
		System.out.println("Final method");
	}
	
	public abstract void acceptData(int id, String name, Department dept);
//	public Employee() {}
//	
//	public Employee(int empId, String empName) {
//		this.empId = empId;
//		this.empName = empName;
//	}
//	
//	public Employee(int empId, String empName, Department department) {
//		this.empId = empId;
//		this.empName = empName;
//		this.department = department;
//	}	
}
