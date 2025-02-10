package mainpkg;

public class OuterClass {
	private String greet = "Hello";
	private static String alsoGreet = "Hello World";
	
	public class InnerClass {
		public void sayHello() {
			System.out.println(greet);
		}
	}
	
	public static class StaticInnerClass {
		public void staticMethod() {
			System.out.println(alsoGreet);
		}
	}
}
