package mainpkg;

public class Employee {
	private int id;
	private String name;
//	private final String org = "Tavant";
	private final String org;
	
	{
		org = "Tavant";
	}
	
//	private static String org;
//	
//	static {
//		System.out.println("In Employee Static Block");
//		org = "Tavant";
//	}
	
//	public void setOrg(String org) {
//		this.org = org;
//	}
	
	public String getOrg() {
		return org;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
//	public static String getOrg() {
//		return org;
//	}
//	
//	public static void setOrg(String org) {
//		Employee.org = org;
//	}
	
	public void acceptEmployeeDetails(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public void showDetails() {
		System.out.println(id + " " + name);
	}
	
	public Employee() {
//		org = "Tavant";
	}

	public Employee(int id, String name) {
//		this.org = "";
		System.out.println("In constructor");
		this.id = id;
		this.name = name;
	}
	
}
