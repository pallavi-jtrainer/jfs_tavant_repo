package creational_patterns_pkg;


public class SingletonClass {
	//1. a private static instance
	private static SingletonClass instance;
	
	//2. a private constructor
	private SingletonClass() {}
	
	//3. a public static method
	public static SingletonClass getInstance() {
		if(instance == null) {
			instance = new SingletonClass();
		}
		
		return instance;
	}
	
	public void showMessage() {
		System.out.println("Hello. this is singleton");
	}
}
