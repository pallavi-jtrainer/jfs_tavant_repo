package day2;

public class ImplClass implements Interface1{

	@Override
	public void addNumbers(int a, int b) {
		System.out.println(a + b);
		
	}

	@Override
	public void showEmployeeDetails(Employee e) {
		System.out.println("In employee details method");
		
	}
	
	public void demo() {
		MyFunctional_Interface inf = new MyFunctional_Interface() {
			
			@Override
			public void abstractMethod() {
				System.out.println("In anonymous inner class method");
				
			}
		};
		inf.abstractMethod();
		MyFunctional_Interface.staticMethod();
		inf.defaultMethod();
	}

}
