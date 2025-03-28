package mainpkg;

public class Student {
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public int getId() {
		return id;
	}


	public void acceptData(int id, String fn, String ln, int age) {
		this.id = id;
		this.firstName = fn;
		lastName = ln;
		this.age = age;
	}
	
	public void showData() {
		System.out.println(id + " " + firstName + " " + lastName);
	}
	
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return super.toString();
//	}
	
}
