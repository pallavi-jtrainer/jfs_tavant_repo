package javafeatures;

@FunctionalInterface
public interface IFunctionalInterface {
	public void show();

	private void privateMethod() {
		
	}
	public default void defaltMethod() {
		privateMethod();
	}
}
