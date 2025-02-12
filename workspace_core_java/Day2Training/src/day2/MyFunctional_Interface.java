package day2;

@FunctionalInterface
public interface MyFunctional_Interface {
	public void abstractMethod();
	
	public static void staticMethod() {
		System.out.println("Static inside functional interface");
	}
	
	public default void defaultMethod() {
		System.out.println("Default inside functional interface");
	}
}
