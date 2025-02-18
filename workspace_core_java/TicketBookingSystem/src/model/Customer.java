package model;

public class Customer extends User{
	private String city;
	private String state;
	private String phone;
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String getDetails() {
		return "Customer Details: Id: "
				+ getUserId() + " Name: "
				+ getName() + " Email: " 
				+ getEmail() + " City: "
				+ getCity() + " State: "
				+ getState() + "Phone: "
				+ getPhone();
	}
	
	public Customer() {}

	public Customer(int id, String name, String email, 
			String city, String state, String phone) {
		this.userId = id;
		this.name = name;
		this.email = email;
		this.city = city;
		this.state = state;
		this.phone = phone;
	}
	
	
	
}
