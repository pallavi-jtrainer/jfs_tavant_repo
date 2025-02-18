package creational_patterns_pkg;

public class Person {
	private final int id;
	private final String firstName;
	private final String lastName;
	private final int age;
	
//	public Person(int id, String fName, String lName, int age) {
//		this.id = id;
//		this.firstName = fName;
//		this.lastName = lName;
//		this.age = age;
//	}
	
	public static class PersonBuilder {
		private int id;
		private final String firstName;
		private final String lastName;
		private int age;
		
//		public PersonBuilder(int id, String fname, 
//				String lname, int age) {
//			this.id = id;
//			this.firstName = fname;
//			this.lastName = lname;
//			this.age = age;
//		}
		
		public PersonBuilder(String fName, String lName) {
			this.firstName = fName;
			this.lastName = lName;
		}

		public PersonBuilder id(int id) {
			this.id = id;
			return this;
		}
		
		public PersonBuilder age(int age) {
			this.age = age;
			return this;
		}
		
//		public int getId() {
//			return id;
//		}

		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}

//		public int getAge() {
//			return age;
//		}
		
		public Person buildPerson() {
			return new Person(this);
		}
		
	}
	
	private Person(PersonBuilder builder) {
		this.id = builder.id;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.age = builder.age;
		
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}
}
