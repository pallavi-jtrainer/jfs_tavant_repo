package mainpkg;

public class MainClass {

	public static void main(String[] args) {
//		Studnet s = new Studnet();
//		s.acceptData(1, "Pallavi", "Prasad", 18);
//		s.showData();
		
//		int arr[] = new int[5];
//		for(int i: arr) {
//			i = 1 * i;
//		}
		
		
//		Student students[] = new Student[5];
////		System.out.println(students[0]);
//		students[0] = new Student();
//		students[0].showData();
//		Student s = new Student();
//		s.showData();
		
		
//		Employee e = new Employee(101, "Prithvi");
////		Employee.setOrg("Infosys");
//		
//		Employee e1 = new Employee(102, "Pranav");
//		e.showDetails();
//		System.out.println("E1 " + Employee.getOrg());
//		e1.showDetails();
//		System.out.println("E2 " + Employee.getOrg());
//		
		
		OuterClass ou = new OuterClass();
		OuterClass.InnerClass ic = ou.new InnerClass();
		ic.sayHello();
		
		OuterClass.StaticInnerClass sc = new OuterClass.StaticInnerClass();
		sc.staticMethod();
		
		//e.id = 101;
		
	}

}
