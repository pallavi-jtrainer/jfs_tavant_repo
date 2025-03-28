package exceptionspkg;

public class InvalidAgeException extends Exception{
	
	public InvalidAgeException() {
		super("Invalid Age");
	}
	
	public InvalidAgeException(String msg) {
		super(msg);
	}
}
