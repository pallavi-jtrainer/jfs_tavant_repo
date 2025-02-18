package model;

public class Admin extends User{
	private final String password;
	
	public String getPassword() {
		return password;
	}
	
	public Admin() {
		userId = 1;
		name = "Admin";
		email = "admin@123";
		password = "Password123";
	}
	
	@Override
	public String getDetails() {
		return "Admin: id: " + getUserId() 
			+ " Name: " + getName()
			+ " Email: " + getEmail();
	}
	
}
